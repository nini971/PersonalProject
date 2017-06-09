package beans;

/**
 * Created by Nicolas Th on 24/05/2017.
 */

public class StudentBean {
    //---------------------------
    //  ATTRIBUTE
    //---------------------------
    private String nom, prenom;

    //---------------------------
    //   CONSTRUCTOR
    //---------------------------
    public StudentBean(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    //--------------------
    // GETTER / SETTER
    //--------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
