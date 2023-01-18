/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.Connexion;
import dao.DAO_NiveauEtude;
import java.sql.Connection;
import java.util.ArrayList;
import model.NiveauEtude;

public class M_NiveauEtude {
    public ArrayList<NiveauEtude> getAll(Connection connect) {
        
        DAO_NiveauEtude dn = new DAO_NiveauEtude();
        ArrayList<NiveauEtude> allNiveauEtude = null;
        try {
            allNiveauEtude = dn.getAll(connect);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return allNiveauEtude;
    }     
}
