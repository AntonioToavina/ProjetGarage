/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DAO_CompositionService;
import java.sql.Connection;
import java.util.ArrayList;
import model.CompositionService;

public class M_CompositionService {
    public ArrayList<CompositionService> decompositionService(Connection connect, String nomService) {
        DAO_CompositionService dcs = new DAO_CompositionService();
        ArrayList<CompositionService> allCompos = null;
        try {
            allCompos = dcs.decompositionService(connect, nomService);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return allCompos;
    }
}
