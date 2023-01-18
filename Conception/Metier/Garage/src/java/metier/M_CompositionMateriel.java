/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DAO_CompositionMateriel;
import java.sql.Connection;
import java.util.ArrayList;
import model.CompositionMateriel;

public class M_CompositionMateriel {
    public ArrayList<CompositionMateriel> decompositionMaterielService(Connection connect, String nomService) {
        DAO_CompositionMateriel dcm = new DAO_CompositionMateriel();
        ArrayList<CompositionMateriel> cm = null;
        try {
            cm = dcm.decompositionMaterielService(connect, nomService);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return cm;
    }
}
