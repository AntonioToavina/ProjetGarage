package Model;

public class DepenseMateriel_Service {
    private int idDepenseMateriel;
    private Materiel materiel;
    private Service service;
    private int volumeConsommation;

    public int getIdDepenseMateriel() {
        return idDepenseMateriel;
    }

    public void setIdDepenseMateriel(int idDepenseMateriel) {
        this.idDepenseMateriel = idDepenseMateriel;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getVolumeConsommation() {
        return volumeConsommation;
    }

    public void setVolumeConsommation(int volumeConsommation) {
        this.volumeConsommation = volumeConsommation;
    }
}
