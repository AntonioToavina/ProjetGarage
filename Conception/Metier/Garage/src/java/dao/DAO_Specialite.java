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
import model.Specialite;

public class DAO_Specialite {
    public ArrayList<Specialite> getAll(Connection connect) throws Exception {
        
        boolean isOpen = false;
        
        if(connect == null) {
            Connexion con = new Connexion();
            connect = con.getConnexion("garage", "postgres", "pg");
            isOpen = true;
        } else {
            isOpen = true;
        }
        
        ArrayList<Specialite> allSpecialite = new ArrayList<>();
        String sql = "select * from specialite";
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        Specialite s = null;
        
        while(res.next()) {
            s = new Specialite();
            s.setIdSpecialite(res.getInt("idspecialite"));
            s.setLibelle(res.getString("libelle"));
            s.setSalaireHoraire(res.getDouble("salairehoraire"));
            allSpecialite.add(s);
        }
        if(isOpen == true) {
            connect.close();
        }
        return allSpecialite;
    }
    
    public void newSpecialite(Specialite s) throws Exception {
/// insérer une nouvelle spécialité dans la table spécialité
        Connexion con = new Connexion();
        Connection connect = con.getConnexion("garage", "postgres", "pg");
        
        String libelle = s.getLibelle();
        String sql = "insert into specialite(libelle) values('" + libelle + "'," + String.valueOf(s.getSalaireHoraire()) + ")";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
        connect.close();
    }
}
