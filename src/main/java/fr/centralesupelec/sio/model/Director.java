package fr.centralesupelec.sio.model;

import java.util.List;

public class Director extends Person {

    //Les directeurs peuvent avoir des awards
    //Encapsulation
    private List<String> nominations;
    private List<String> awards;

    public List<String> getNominations() {
        return nominations;
    }

    public void setNominations(List<String> nominations) {
        this.nominations = nominations;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

}
