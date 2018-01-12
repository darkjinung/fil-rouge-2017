package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.*;
import org.apache.commons.collections.ArrayStack;

import java.lang.reflect.Array;
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

        //A few variables
        Set<Genre> sgenres = new HashSet<>();
        Set<String> salias = new HashSet<>();
        //Define some Genre
        Genre gcrime = new Genre(0,"Crime");
        Genre gdrama = new Genre(1,"Drama");
        Genre gaction = new Genre(2,"Action");
        Genre gadventure = new Genre(3,"Adventure");
        Genre gsci_fi = new Genre(4,"Sci-fi");
        Genre gmystery = new Genre(5,"Mystery");
        Genre gfantasy = new Genre(6,"Fantasy");
        Genre gmusical = new Genre(7,"Musical");
        Genre gbibliography = new Genre(8,"Bibliography");
        Genre gtest = new Genre(999,"Test");


        // Define some static movies on creation
        // Movie 1 : The Godfather
        Movie m1 = new Movie(1,"The Godfather");
        sgenres.clear();
        sgenres.add(gcrime); sgenres.add(gdrama);
        m1.setGenres(sgenres);
            //Actors
        Actor a1 = new Actor();
        a1.setId(1);
        a1.setPrénom("Al");
        a1.setNom("Pacino");
        salias.clear(); salias.add("Joe Paterno");salias.add("Danny Collins");salias.add("Jack Gramm");salias.add("Tony D'Amato");salias.add("Carlito");
        a1.setAlias(salias);
        a1.setAwards(Arrays.asList("Best Actor in leading role;1993;Oscar;Scent of a Woman","Best Performance by an Actor in a Motion Picture - Drama;1993;Golden Globe;Scent of a Woman"));
        a1.setNominations(Arrays.asList("Outstanding Lead Actor in a Miniseries or a Movie;2013;Primetime Emmy;Phil Spectror"));
        a1.setDateOfBirth(new GregorianCalendar(1940, 4, 25).getTime());
        Actor a2 = new Actor();
        a2.setId(2);
        a2.setPrénom("James");
        a2.setNom("Caan");
        salias.clear(); salias.add("Agent Gamble");salias.add("George Lawrence Secord");salias.add("Schuuster");salias.add("Max Saltzman");salias.add("Gerry");
        a2.setAlias(salias);
        a2.setAwards(Arrays.asList("Best Actor;1976;Golden Scroll;Rollerball","Outstanding Cast Performance - Feature;2016;Action on Film Award;The Red Maple Leaf"));
        a2.setNominations(Arrays.asList("Best Actor;1990;Saturn Award;Misery"));
        a2.setDateOfBirth(new GregorianCalendar(1940, 3, 26).getTime());
        Actor a3 = new Actor();
        a3.setId(3);
        a3.setPrénom("Marlon");
        a3.setNom("Brando");
        salias.clear(); salias.add("Don Vito Corleone");salias.add("Boss");salias.add("Max");salias.add("McCarthy");salias.add("Jor-El");
        a3.setAlias(salias);
        a3.setAwards(Arrays.asList("Best Actor - Drama;1954;Golden Globe;On the Waterfront","Best Actor in a Leading Role;1972;Oscar;The Godfather"));
        a3.setNominations(Arrays.asList("Best Actor in a Supporting Role;1989;Oscar;A Dry White Season"));
        a3.setDateOfBirth(new GregorianCalendar(1924, 4, 3).getTime());
            //Directors
        Director d1 = new Director();
        d1.setId(1);
        d1.setPrénom("Francis Fred");
        d1.setNom("Coppola");
        d1.setAwards(Arrays.asList("Best Director - Motion Picture;1979;Golden Globe;Apocalypse Now","Best Foreign Producer;1981;David;Kagemusha"));
        d1.setNominations(Arrays.asList("Best Screenplay - Motion Picture;1975;Golden Globe;The Conversation"));
        d1.setDateOfBirth(new GregorianCalendar(1939,4,7).getTime());
        m1.setListActors(Arrays.asList(a1,a2,a3));
        m1.setListDirectors(Arrays.asList(d1));

        //M2
        Movie m2 = new Movie(2,"Spider-Man: Homecoming");
        sgenres.clear();
        sgenres.add(gaction); sgenres.add(gadventure); sgenres.add(gsci_fi);
        m2.setGenres(sgenres);
        //Actors
        Actor a4 = new Actor();
        a4.setId(4);
        a4.setPrénom("Tom");
        a4.setNom("Holland");
        salias.clear(); salias.add("Peter Parker"); salias.add("Spiderman"); salias.add("Samuel Insull"); salias.add("Bradley Baker"); salias.add("Jack Fawcett");
        a4.setAlias(salias);
        a4.setAwards(Arrays.asList("EE Rising Star Award;2017;BAFTA Awards","Breakthrough Performance of the Year;2016;Golden Schomes;Captain America: Civil War"));
        a4.setNominations(Arrays.asList("Best Actor;2018;Evening Standard British Film Award;Spider-Man: Homecoming"));
        a4.setDateOfBirth(new GregorianCalendar(1996, 6, 1).getTime());
        Actor a5 = new Actor();
        a5.setId(5);
        a5.setPrénom("Gwyneth");
        a5.setNom("Paltrow");
        salias.clear(); salias.add("Pepper Potts"); salias.add("Johanna"); salias.add("Maya Ganesh"); salias.add("Phoebe");
        a5.setAlias(salias);
        a5.setAwards(Arrays.asList("Best Actress in a Leading Role;1998;Osar;Shakespeare in Love"," Outstanding Guest Actress in a Comedy Series;2011;Primetime Emmy;Glee"));
        a5.setNominations(Arrays.asList(" Best Supporting Actress;1995;Saturn Award;Se7en"));
        a5.setDateOfBirth(new GregorianCalendar(1972, 9, 27).getTime());
        //Directors
        Director d2 = new Director();
        d2.setId(2);
        d2.setPrénom("Jon");
        d2.setNom("Watts");
        d2.setAwards(Arrays.asList(""));
        d2.setNominations(Arrays.asList("Grand Special Prize;2015;Deauville Film Festival;Cop Car","Audience Award;2015;Edinburgh International Film Festival;Cop Car"));
        d2.setDateOfBirth(new GregorianCalendar(1981,6,28).getTime());
        m2.setListActors(Arrays.asList(a4,a5));
        m2.setListDirectors(Arrays.asList(d2));

        //M3
        Movie m3 = new Movie(3,"Blade Runner 2049");
        sgenres.clear();
        sgenres.add(gdrama); sgenres.add(gmystery); sgenres.add(gsci_fi);
        m3.setGenres(sgenres);
        //Actors
        Actor a6 = new Actor();
        a6.setId(6);
        a6.setPrénom("Ryan");
        a6.setNom("Gosling");
        salias.clear(); salias.add("K"); salias.add("Holland March"); salias.add("Sebastian"); salias.add("Driver");
        a6.setAlias(salias);
        a6.setAwards(Arrays.asList("Best Performance by an Actor in a Motion Picture - Musical or Comedy;2017;Golden Globe;La La Land"));
        a6.setNominations(Arrays.asList("Best Performance by an Actor in a Leading Role;2017;Oscar;La La Land"));
        a6.setDateOfBirth(new GregorianCalendar(1980, 11, 12).getTime());
        Actor a7 = new Actor();
        a7.setId(7);
        a7.setPrénom("Mark");
        a7.setNom("Arnold");
        salias.clear(); salias.add("General McCoy");
        a7.setAlias(salias);
        a7.setAwards(Arrays.asList("Best Actor;2017;Unrestricted View Film Festival;Mile End"));
        a7.setNominations(Arrays.asList(""));
        a7.setDateOfBirth(new GregorianCalendar(1957, 5, 23).getTime());
        Actor a8 = new Actor();
        a8.setId(8);
        a8.setPrénom("Robin");
        a8.setNom("Wright");
        salias.clear(); salias.add("Claire Underwood");
        a8.setAlias(salias);
        a8.setAwards(Arrays.asList(" Best Performance by an Actress in a Television Series - Drama;2014;Golden Globe;House of Cards"));
        a8.setNominations(Arrays.asList(" Outstanding Drama Series;2017;Primetime Emmy Awards;House of Cards"));
        a8.setDateOfBirth(new GregorianCalendar(1966, 4, 8).getTime());
        //Directors
        Director d3 = new Director();
        d3.setId(3);
        d3.setPrénom("Denis");
        d3.setNom("Villeneuve");
        d3.setAwards(Arrays.asList("Best Feature Film;2011;Adelaide Film Festival;Incendis"));
        d3.setNominations(Arrays.asList("Best Narrative Feature;2013;Abu Dhabi Film Festival;Enemy"," Best Achievement in Directing;2017;Oscar;Arrival"));
        d3.setDateOfBirth(new GregorianCalendar(1967,10,3).getTime());
        m3.setListActors(Arrays.asList(a6,a7,a8));
        m3.setListDirectors(Arrays.asList(d3));

        //tests
        Actor atest = new Actor();
        atest.setId(999);
        atest.setPrénom("Bob");
        atest.setNom("TheClerc");
        salias.clear(); salias.add("Le bob");
        atest.setAlias(salias);
        atest.setAwards(Arrays.asList(""));
        atest.setNominations(Arrays.asList(""));
        atest.setDateOfBirth(new GregorianCalendar(1900, 1, 1).getTime());
        Director dtest = new Director();
        dtest.setId(999);
        dtest.setPrénom("Joe");
        dtest.setNom("TheChild");
        dtest.setAwards(Arrays.asList(""));
        dtest.setNominations(Arrays.asList(""));
        dtest.setDateOfBirth(new GregorianCalendar(1900,1,1).getTime());

        // more movies just for search tests
        Movie m4 = new Movie(4,"Star Wars");
        sgenres.clear();
        sgenres.add(gaction); sgenres.add(gadventure); sgenres.add(gfantasy);
        m4.setGenres(sgenres);
        m4.setListActors(Arrays.asList(atest));
        m4.setListDirectors(Arrays.asList(dtest));

        Movie m5 = new Movie(5,"Logan");
        sgenres.clear();
        sgenres.add(gaction);sgenres.add(gdrama);sgenres.add(gsci_fi);
        m5.setGenres(sgenres);
        m5.setListActors(Arrays.asList(atest));
        m5.setListDirectors(Arrays.asList(dtest));

        Movie m6 = new Movie(6,"The Greatest Showman");
        sgenres.clear();
        sgenres.add(gdrama);sgenres.add(gmusical);sgenres.add(gbibliography);
        m6.setGenres(sgenres);
        m6.setListActors(Arrays.asList(atest));
        m6.setListDirectors(Arrays.asList(dtest));

        Movie m7 = new Movie(7,"Guardians of the Galaxy");
        sgenres.clear();
        sgenres.add(gaction);sgenres.add(gadventure);sgenres.add(gsci_fi);
        m7.setGenres(sgenres);
        m7.setListActors(Arrays.asList(atest));
        m7.setListDirectors(Arrays.asList(dtest));

        Movie m8 = new Movie(8,"Rogue One");
        sgenres.clear();
        sgenres.add(gaction);sgenres.add(gadventure);sgenres.add(gsci_fi);
        m8.setGenres(sgenres);
        m8.setListActors(Arrays.asList(atest));
        m8.setListDirectors(Arrays.asList(dtest));

        mMovies = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8);
    }

    @Override
    public List<Movie> getMovies() {
        return mMovies;
    }

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
                    else return genres.contains(genre.getName().toLowerCase());
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
