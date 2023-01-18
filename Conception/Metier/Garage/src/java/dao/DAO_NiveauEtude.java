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
import model.NiveauEtude;

public class DAO_NiveauEtude {
    public ArrayList<NiveauEtude> getAll(Connection connect) throws Exception {
        
        boolean isOpen = false;
        if(connect == null) {
            Connexion con = new Connexion();
            connect = con.getConnexion("garage", "postgres", "pg");
            isOpen = true;
        } else {
            isOpen = true;
        }
        
        ArrayList<NiveauEtude> allNiveauEtude = new ArrayList<>();
        String sql = "select * from niveauetude";
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        NiveauEtude ne = null;
        
        while(res.next()) {
            ne = new NiveauEtude();
            ne.setIdNiveauEtude(res.getInt("idniveauetude"));
            ne.setLibelle(res.getString("libelle"));
            allNiveauEtude.add(ne);
        }
        
        if(isOpen == true) {
            connect.close();
        }
        
        return allNiveauEtude;
    }
}
