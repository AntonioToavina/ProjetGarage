package DAO;


import Model.CompositionMateriel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_CompositionMateriel extends DAO{
    public ArrayList<CompositionMateriel> decompositionMaterielService(Connection connect, String nomService) throws Exception {
        ArrayList<CompositionMateriel> all = new ArrayList<>();
        try{
            String sql = "select idmateriel, nommateriel, volumeconsommation, prixconsommation, unite, idservice, nomservice from v_depensemateriel dm where nomservice = ?";
            this.stmt= connect.prepareStatement(sql);
            this.stmt.setObject(1,nomService);
           this.rs= stmt.executeQuery();
            CompositionMateriel cm = null;

            while( this.rs.next()) {
                cm = new CompositionMateriel();
                cm.setIdMateriel( this.rs.getInt("idmateriel"));
                cm.setNomMateriel( this.rs.getString("nommateriel"));
                cm.setVolumeConsommation( this.rs.getDouble("volumeconsommation"));
                cm.setPrixConsommation( this.rs.getDouble("prixconsommation"));
                cm.setUnite( this.rs.getString("unite"));
                cm.setIdService( this.rs.getInt("idservice"));
                cm.setNomService( this.rs.getString("nomservice"));
                all.add(cm);
            }
        }catch (Throwable e){
            throw new Exception(e.getMessage());
        }finally{
            closeAll();
        }
        return all;
    }
}
