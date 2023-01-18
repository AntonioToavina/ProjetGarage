/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import model.Employe;

public class DAO_Employe {
    public void newEmploye(Employe e) throws Exception {
/// insert nouveau employe
        Connexion con = new Connexion();
        Connection connect = con.getConnexion("garage", "postgres", "pg");
        String sql = "insert into employe(nom, prenom, datenaissance, idniveauetude) values(";
        sql += "'" + e.getNom() + "',";
        sql += "'" + e.getPrenom() + "',";
        sql += "'" + String.valueOf(e.getDateNaissance()) + "',";
        sql += String.valueOf(e.getNiveauEtude().getIdNiveauEtude()) + ")";
        
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
        connect.close();
    }
}
