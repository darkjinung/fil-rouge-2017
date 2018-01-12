package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * A {@link MoviesRepository} backed by a database.
 */
// Example implementation of another storage
class DatabaseMoviesRepository extends MoviesRepository {

    @Override
    public List<Movie> getMovies() {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Movie getMovie(long id) {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Set<Genre> getMoviesGenre() {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Genre getGenre(long id) {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Set<Actor> getActors() {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Actor getActor(long id) {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Set<Director> getDirectors() {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public Director getDirector(long id) {
        throw new UnsupportedOperationException("Awaiting DB implementation!");
    }

    @Override
    public List<Movie> getMovies(String title, List<String> genres, List<Long> directors, List<Long> actors, int offset, int limit) {
        throw new UnsupportedOperationException("Awaiting DB implementation");
    }
}
