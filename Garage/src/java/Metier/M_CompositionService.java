package Metier;

import DAO.DAO_CompositionService;
import Model.CompositionService;
import java.sql.Connection;
import java.util.ArrayList;

public class M_CompositionService {
    public ArrayList<CompositionService> decompositionService(Connection connect, String nomService)throws Exception {
        DAO_CompositionService dcs = new DAO_CompositionService();
        ArrayList<CompositionService> allCompos = null;
        try {
            allCompos = dcs.decompositionService(connect, nomService);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return allCompos;
    }
}
