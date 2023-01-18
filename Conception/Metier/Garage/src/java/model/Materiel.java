/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ITU
 */
public class Materiel {
    private int idMateriel;
    private String nom;
    private double prixConsommation;
    private String unite;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixConsommation() {
        return prixConsommation;
    }

    public void setPrixConsommation(double prixConsommation) {
        this.prixConsommation = prixConsommation;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
}
