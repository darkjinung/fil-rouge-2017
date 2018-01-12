package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * A concrete {@link AccountsRepository} backed by an in-memory list of static {@link Account} entities.
 */
public class DummyAccountsRepository extends AccountsRepository {

    // Hold entities in a simple list.
    private final List<Account> mAccounts;

    DummyAccountsRepository() {
        // Define a single account
        Account a1 = new Account();
        a1.setUsername("admin@ecp.sio.fr");
        a1.setPasswordHash(DigestUtils.sha1Hex("password")); //password hashed
        // Warning: the list below will be immutable (be the contained entities can be modified)
        mAccounts = Collections.singletonList(a1);
    }

    @Override
    public Account getAccount(String username) {
        return mAccounts.stream()
                .filter(account -> account.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    // Below are (unused) variants of getAccount(username)

    // A simple loop with index
    public Account getAccountWithIndexedLoop(String username) {
        for (int i = 0; i < mAccounts.size(); i++) {
            Account a = mAccounts.get(i);
            if (a.getUsername().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }

    // A better iteration syntax for collections, more readable
    public Account getAccountWithIteration(String username) {
        for (Account a: mAccounts) {
            if (a.getUsername().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }

    // A newer "stream" manipulation syntax, with method chaining
    public Account getAccountWithStream(String username) {
        return mAccounts
                // Obtain a streamable view of the list
                .stream()
                // Keep only items matching a predicate (function that return a boolean)
                .filter(new Predicate<Account>() {
                    @Override
                    public boolean test(Account account) {
                        return account.getUsername().equalsIgnoreCase(username);
                    }
                })
                // Get the first item (returns an Optional<Movie>)
                .findFirst()
                // If not found, return null
                .orElse(null);
    }

    // Same version as above, where the Predicate is replaced by a lambda
    public Account getAccountWithStreamLambda(String username) {
        return mAccounts.stream()
                .filter(account -> account.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

}
