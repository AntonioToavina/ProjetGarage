/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DAO_Employe;
import model.Employe;

public class M_Employe {
    public void newEmploye(Employe e) {
/// appel fonction newEmploye dans DAO_Employe
        DAO_Employe de = new DAO_Employe();
        try {
            de.newEmploye(e);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
