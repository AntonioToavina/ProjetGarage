package Metier;


import DAO.DAO_CompositionMateriel;
import Model.CompositionMateriel;
import java.sql.Connection;
import java.util.ArrayList;

public class M_CompositionMateriel {
    public ArrayList<CompositionMateriel> decompositionMaterielService(Connection connect, String nomService)throws Exception {
        DAO_CompositionMateriel dcm = new DAO_CompositionMateriel();
        ArrayList<CompositionMateriel> cm = null;
        try {
            cm = dcm.decompositionMaterielService(connect, nomService);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return cm;
    }
}
