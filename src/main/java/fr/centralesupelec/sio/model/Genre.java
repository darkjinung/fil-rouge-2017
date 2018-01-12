package fr.centralesupelec.sio.model;

import java.util.EnumSet;

public class Genre {

    private int id;
    private String name;

    public Genre(int pId, String pName){
        this.id = pId;
        this.name = pName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
