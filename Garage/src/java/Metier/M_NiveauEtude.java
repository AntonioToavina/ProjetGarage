package Metier;

import DAO.DAO_NiveauEtude;
import Model.NiveauEtude;
import java.sql.Connection;
import java.util.ArrayList;

public class M_NiveauEtude {
    public ArrayList<NiveauEtude> getAll(Connection connect)throws Exception {

        DAO_NiveauEtude dn = new DAO_NiveauEtude();
        ArrayList<NiveauEtude> allNiveauEtude = null;
        try {
            allNiveauEtude = dn.getAll(connect);
        } catch(Exception e) {
           throw e;
        }
        return allNiveauEtude;
    }
}
