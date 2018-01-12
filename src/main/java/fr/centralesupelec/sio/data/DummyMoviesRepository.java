package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.*;
import org.apache.commons.collections.ArrayStack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A concrete {@link MoviesRepository} backed by an in-memory list of static {@link Movie} entities.
 */
// This class is not accessible outside of its package.
class DummyMoviesRepository extends MoviesRepository {

    // Hold entities in a simple list.
    private final List<Movie> mMovies;

    DummyMoviesRepository() {
        //Define some Genre
        Genre g1 = new Genre(0,"fantasy");
        Genre g2 = new Genre(1,"fantasy");
        Genre g3 = new Genre(2,"fantasy");
        Genre g4 = new Genre(3,"fantasy");
        Genre g5 = new Genre(4,"fantasy");
        Genre g6 = new Genre(5,"fantasy");


        // Define some static movies on creation
        // Movie 1 : LOTR
        Movie m1 = new Movie();
        m1.setId(1);
        m1.setTitle("Lord of the Rings: The Return of the King");
        Set<Genre> sgenre = new HashSet<>();
        sgenre.add(g1);
        m1.setGenres(sgenre);
            //Actors
        Actor a1 = new Actor();
        a1.setId(1);
        a1.setPrénom("Orlando");
        a1.setNom("Bloom");
        a1.setAwards(Arrays.asList("Best Cast Ensemble;2002;ACCA;The Lord of the Rings: The Twin Towers","Best Cast Ensemble;2003;ACCA;The Lord of the Rings: The Return of the King"));
        a1.setNominations(Arrays.asList("Best Actor in a Supporting Role;2003;AFI Awards;Ned Kelly"));
        a1.setDateOfBirth(new GregorianCalendar(1977, 1, 13).getTime());
            //Directors
        Director d1 = new Director();
        d1.setId(1);
        d1.setPrénom("Christopher");
        d1.setNom("Nollan");
        d1.setDateOfBirth(new GregorianCalendar(1955,1,9).getTime());
        m1.setListActors(Arrays.asList(a1));
        m1.setListDirectors(Arrays.asList(d1));

        //M2
        Movie m2 = new Movie();
        m2.setId(2);
        m2.setTitle("Star Wars VIII: The Last Jedi");
        m2.setGenres(sgenre);
        m2.setListActors(Arrays.asList(a1));
        m2.setListDirectors(Arrays.asList(d1));

        //M3
        Movie m3 = new Movie();
        m3.setId(3);
        m3.setTitle("Kingsman 2: The Golden Circle");
        m3.setGenres(sgenre);
        m3.setListActors(Arrays.asList(a1));
        m3.setListDirectors(Arrays.asList(d1));

        mMovies = Arrays.asList(m1, m2, m3);
    }

    @Override
    public List<Movie> getMovies() {
        return mMovies;
    }

    /*
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
     */
    @Override
    public List<Movie> getMovies(String title, List<String> genres, List<Long> directors, List<Long> actors, int offset, int limit) {
        //Embeded lambda function, using streams and filters
        return mMovies
                //Opening a stream on all the movies in our database
                .stream()
                //We first filter by title, to see if the parameter entered by the user is contained in one of the title of our movies.
                //If the user didn't input the "title" parameter, the filter will always return true because of default parameters
                .filter(movie -> movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                //We then filter by "genres", streaming on every "genre" of this movie and comparing each of them to the inputed genre by the user
                .filter(movie -> movie.getGenres().stream().anyMatch( genre -> {
                    if(genres.isEmpty()) return true;
                    else return genres.contains(genre.getName());
                }))
                //Same for directors
                .filter(movie -> movie.getListDirectors().stream().anyMatch(director -> {
                    if(directors.isEmpty()) return true;
                    else return directors.contains(director.getId());
                }))
                //Same for actors
                .filter(movie -> movie.getListActors().stream().anyMatch(actor -> {
                    if(actors.isEmpty()) return true;
                    else return actors.contains(actor.getId());
                }))
                .skip(offset)
                .limit(limit)
                //Repack de la collection filtré
                .collect(Collectors.toList());
    }

    @Override
    public Movie getMovie(long id) {
        // See DummyAccountsRepository for more details an variants.
        return mMovies.parallelStream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Genre> getMoviesGenre() {
        Set<Genre> moviesGenres = new HashSet<>();
        for(Movie m : mMovies)
            moviesGenres.addAll(m.getGenres());
        return moviesGenres;
    }

    @Override
    public Genre getGenre(long id) {
        for(Movie tmpMovies : mMovies)
            for(Genre g : tmpMovies.getGenres())
                if(g.getId() == id)
                    return g;
        return null;
    }

    @Override
    public Set<Actor> getActors() {
        Set<Actor> mActors = new HashSet<>();
        for (Movie tmpMovies : mMovies)
            if(tmpMovies.getListActors() != null)
                for (Actor tmpPerson : tmpMovies.getListActors())
                        mActors.add(tmpPerson);
        return mActors;
    }

    @Override
    public Actor getActor(long id) {
        for(Movie tmpMovies : mMovies)
            for (Actor tmpPerson : tmpMovies.getListActors())
                    if(tmpPerson.getId() == id)
                        return tmpPerson;
        return null;
    }

    @Override
    public Set<Director> getDirectors() {
        Set<Director> mDirectors = new HashSet<>();
        for (Movie tmpMovies : mMovies)
            if(tmpMovies.getListDirectors() != null)
                for (Director tmpPerson : tmpMovies.getListDirectors())
                        mDirectors.add(tmpPerson);
        return mDirectors;
    }

    @Override
    public Director getDirector(long id) {
        for(Movie tmpMovies : mMovies)
            for (Director tmpPerson : tmpMovies.getListDirectors())
                    if(tmpPerson.getId() == id)
                        return tmpPerson;
        return null;
    }
}
