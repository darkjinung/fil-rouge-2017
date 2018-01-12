package fr.centralesupelec.sio.model;

import java.util.List;
import java.util.Set;

public class Actor extends Person {

    //Actors can have mulitple awards & nominations, we therefore use a List
    private List<String> nominations;
    private List<String> awards;
    private Set<String> alias;

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

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
}
