package Model;

public class Service {
    private int idService;
    private String nomService;
    private double prixHoraire;
    private TraitementService [] traitementService;
    private double taux;

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

    /**
     * @return the taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * @param taux the taux to set
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }
}
