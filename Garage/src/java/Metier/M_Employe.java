package Metier;

import DAO.Connexion;
import DAO.DAO;
import DAO.DAO_Employe;
import Model.Employe;
import java.sql.Connection;

public class M_Employe {
    public void newEmploye(Employe e)throws Exception {
        DAO_Employe de = new DAO_Employe();
        Connection connection=null;
        try {
            connection=new Connexion().getConnexion();
            e.setIdEmploye(new DAO().getNextValue("s_employe",connection));
            de.newEmploye(connection,e);
            de.setSpecialiteEmploye(connection,e);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
