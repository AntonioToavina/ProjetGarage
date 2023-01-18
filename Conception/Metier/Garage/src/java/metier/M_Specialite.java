/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DAO_Specialite;
import java.sql.Connection;
import java.util.ArrayList;
import model.Specialite;

public class M_Specialite {
    
    public ArrayList<Specialite> getAll(Connection connect) {
        
        DAO_Specialite ds = new DAO_Specialite();
        ArrayList<Specialite> allSpecialites = null;
        try {
            allSpecialites = ds.getAll(connect); // appel fonction getAll dans DAO_Specialite
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return allSpecialites;
    }
    
    public void newSpecialite(Specialite s) {
/// appel fonction newSpecialite() dans DAO_Specialite()
        DAO_Specialite ds = new DAO_Specialite();
        try {
            ds.newSpecialite(s);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
