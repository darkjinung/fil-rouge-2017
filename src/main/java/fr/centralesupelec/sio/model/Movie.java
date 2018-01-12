package fr.centralesupelec.sio.model;

import java.util.List;
import java.util.Set;

/**
 * An entity class for a movie.
 */
public class Movie {

    private long id;
    private String title;
    private Set<Genre> genres;
    // Actors and directors
    private List<Actor> listActors;
    private List<Director> listDirectors;

    //For faster construction
    public Movie(long pid, String ptitle)
    {
        this.id = pid;
        this.title = ptitle;
    }
    public Movie(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public List<Actor> getListActors() {
        return listActors;
    }

    public void setListActors(List<Actor> listActors) {
        this.listActors = listActors;
    }

    public List<Director> getListDirectors() {
        return listDirectors;
    }

    public void setListDirectors(List<Director> listDirectors) {
        this.listDirectors = listDirectors;
    }
}