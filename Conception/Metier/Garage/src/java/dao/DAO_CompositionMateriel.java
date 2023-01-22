/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.CompositionMateriel;

public class DAO_CompositionMateriel {
    public ArrayList<CompositionMateriel> decompositionMaterielService(Connection connect, String nomService) throws Exception {
        boolean isOpen = false;
        if(connect == null) {
            Connexion con = new Connexion();
            connect = con.getConnexion("garage", "postgres", "pg");
            isOpen = true;
        } else {
            isOpen = true;
        }
        String sql = "select idmateriel, nommateriel, volumeconsommation, prixconsommation, unite, idservice, nomservice from v_depensemateriel dm where(nomservice = '";
        sql += nomService + "')";
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<CompositionMateriel> all = new ArrayList<>();
        CompositionMateriel cm = null;
        
        while(res.next()) {
            cm = new CompositionMateriel();
            cm.setIdMateriel(res.getInt("idmateriel"));
            cm.setNomMateriel(res.getString("nommateriel"));
            cm.setVolumeConsommation(res.getDouble("volumeconsommation"));
            cm.setPrixConsommation(res.getDouble("prixconsommation"));
            cm.setUnite(res.getString("unite"));
            cm.setIdService(res.getInt("idservice"));
            cm.setNomService(res.getString("nomservice"));
            all.add(cm);
        }
        
        if(isOpen == true) {
            connect.close();
        }
        return all;
    }
}
