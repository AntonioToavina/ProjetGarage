package Model;

import java.sql.Date;
import java.time.temporal.ChronoUnit;

public class Employe {

    private int idEmploye;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private NiveauEtude niveauEtude;
    private Specialite [] specialite;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

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

    public boolean checkDateNaissance(Date birth){
        boolean val=true;
        double age=ChronoUnit.YEARS.between(birth.toLocalDate().atStartOfDay(),new Date(System.currentTimeMillis()).toLocalDate().atStartOfDay() );
        System.out.println(age);
        if(age<18)
            val=false;

        System.out.println(val);

        return val;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance)throws Exception {
        if(!checkDateNaissance(dateNaissance))
            throw  new Exception("Date de naissance non valide");

        this.dateNaissance = dateNaissance;
    }

    public NiveauEtude getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(NiveauEtude niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public Specialite[] getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite[] specialite) {
        this.specialite = specialite;
    }
}
