/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.Connexion;
import java.sql.Connection;
import java.util.ArrayList;
import model.CompositionMateriel;
import model.CompositionService;

public class M_Service {
    
    public double revientSalarial(String nomService) {
        double rv = 0;
        try {
            M_CompositionService mcs = new M_CompositionService();
            Connexion con = new Connexion();
            Connection connect = con.getConnexion("garage", "postgres", "pg");
            ArrayList<CompositionService> acs = mcs.decompositionService(connect, nomService);
            for(int i = 0; i < acs.size(); i++) {
                rv += (acs.get(i).getSalaireHoraire()*acs.get(i).getDuree());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rv;
    }
    
    public double revientMateriel(String nomService) {
        double rm = 0;
        try {
            M_CompositionMateriel mcm = new M_CompositionMateriel();
            Connexion con = new Connexion();
            Connection connect = con.getConnexion("garage", "postgres", "pg");
            ArrayList<CompositionMateriel> acm = mcm.decompositionMaterielService(connect, nomService);
            for(int i = 0; i < acm.size(); i++) {
                rm += (acm.get(i).getPrixConsommation()*acm.get(i).getVolumeConsommation());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rm;
    }
    
    public double prixRevient(String nomService) {
        double revientSalarial = this.revientSalarial(nomService);
        double revientMateriel = this.revientMateriel(nomService);
        double marge = (revientSalarial + revientMateriel)*(20/100);
        
        return (revientSalarial + revientMateriel + marge);
    }
}
