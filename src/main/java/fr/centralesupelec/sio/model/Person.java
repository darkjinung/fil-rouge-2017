package fr.centralesupelec.sio.model;

import java.util.Date;

//J'ai nommé cette classe personne afin de généraliser tout type
// //de personnes qui peutvent être présentes dans un filme tel que:
//  Actor / Director / Producer / Cameraman / StunArtist / etc...
public abstract class Person {

    //Encapsulsation
    private long id;
    private String nom;
    private String prénom;
    private Date dateOfBirth;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
