/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Date;

public class Employe {
    
    private int idEmploye;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private NiveauEtude niveauEtude;
    private Specialite [] specialite;
    
    public static int calculAge(Date dtn) {
        int annee = Integer.parseInt(String.valueOf(dtn).split("/")[2]);
        int a = Integer.parseInt(String.valueOf(LocalDate.now()).split("-")[0]);
        return (a - annee);
    }
    
    public static boolean checkAge(Date dtn) {
        int age = calculAge(dtn);
        if(age > 18) {
            return true;
        }
        return false;
    }

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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) throws Exception {
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

    public Employe(String nom, String prenom, Date dateNaissance, NiveauEtude niveauEtude, Specialite[] specialite) throws Exception {
        if(checkAge(dateNaissance) == false) {
            throw new Exception("Age invalide");
        } else {
            this.nom = nom;
            this.prenom = prenom;
            this.dateNaissance = dateNaissance;
            this.niveauEtude = niveauEtude;
            this.specialite = specialite;
        }
    }
    
    
    
    
}
