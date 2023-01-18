/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class CompositionMateriel {
    
    private int idMateriel;
    private String nomMateriel;
    private double volumeConsommation;
    private double prixConsommation;
    private String unite;
    private int idService;
    private String nomService;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public double getVolumeConsommation() {
        return volumeConsommation;
    }

    public void setVolumeConsommation(double volumeConsommation) {
        this.volumeConsommation = volumeConsommation;
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

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }
    
    
}
