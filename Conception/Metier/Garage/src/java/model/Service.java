/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Harrijohn Philippe
 */
public class Service {
    
    private int idService;
    private String nomService;
    private double prixHoraire;
    private TraitementService [] traitementService;

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

    public double getPrixHoraire() {
        return prixHoraire;
    }

    public void setPrixHoraire(double prixHoraire) {
        this.prixHoraire = prixHoraire;
    }

    public TraitementService[] getTraitementService() {
        return traitementService;
    }

    public void setTraitementService(TraitementService[] traitementService) {
        this.traitementService = traitementService;
    }
    
    
}
