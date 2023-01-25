package Metier;

import DAO.DAO_Specialite;
import Model.Specialite;
import java.sql.Connection;
import java.util.ArrayList;

public class M_Specialite {
    public ArrayList<Specialite> getAll(Connection connect)throws Exception {

        DAO_Specialite ds = new DAO_Specialite();
        ArrayList<Specialite> allSpecialites = null;
        try {
            allSpecialites = ds.getAll(connect); // appel fonction getAll dans DAO_Specialite
        } catch(Exception e) {
            throw e;
        }
        return allSpecialites;
    }

    public void newSpecialite(Specialite s) {
        DAO_Specialite ds = new DAO_Specialite();
        try {
            ds.newSpecialite(s);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
