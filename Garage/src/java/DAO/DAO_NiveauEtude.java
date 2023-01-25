package DAO;

import Model.NiveauEtude;
import java.sql.Connection;
import java.util.ArrayList;

public class DAO_NiveauEtude extends DAO{
    public ArrayList<NiveauEtude> getAll(Connection connect) throws Exception {
         ArrayList<NiveauEtude> allNiveauEtude = new ArrayList<>();
        try{
             String sql = "select * from niveauetude";
            this.stmt = connect.prepareStatement(sql);
            this.rs= stmt.executeQuery();
            NiveauEtude ne = null;

            while(this.rs.next()) {
                ne = new NiveauEtude();
                ne.setIdNiveauEtude(this.rs.getInt("idniveauetude"));
                ne.setLibelle(this.rs.getString("libelle"));
                allNiveauEtude.add(ne);
            }

        }catch(Throwable e){
            throw e;
        }

        return allNiveauEtude;
    }
}
