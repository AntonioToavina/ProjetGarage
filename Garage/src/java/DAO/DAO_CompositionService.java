package DAO;

import DAO.DAO;
import Model.CompositionService;
import java.sql.Connection;
import java.util.ArrayList;

public class DAO_CompositionService extends DAO{
    public ArrayList<CompositionService> decompositionService(Connection connect, String nomService) throws Exception {
        ArrayList<CompositionService> compositionsServices = new ArrayList<>();
        try{
            String sql = "WITH RECURSIVE cte_query AS (";
            sql += " select idservice, nomservice, idspecialite, libelle, prixhoraire, duree from v_service vs where(nomservice =?)";
            sql += " UNION select vs.idservice, vs.nomservice, vs.idspecialite, vs.libelle, vs.prixhoraire, vs.duree";
            sql += " from v_service vs INNER JOIN cte_query cq ON cq.idservice = cq.idspecialite)";
            sql += " select * from cte_query";

            this.stmt = connect.prepareStatement(sql);
            this.stmt.setString(1,nomService);
            this.rs= stmt.executeQuery();

            CompositionService cs = null;

            while(this.rs.next()) {
                cs = new CompositionService();
                cs.setIdservice(this.rs.getInt("idservice"));
                cs.setNomService(this.rs.getString("nomservice"));
                cs.setIdSpecialite(this.rs.getInt("idspecialite"));
                cs.setLibelle(this.rs.getString("libelle"));
                cs.setSalaireHoraire(this.rs.getDouble("prixhoraire"));
                cs.setDuree(this.rs.getDouble("duree"));
                compositionsServices.add(cs);
            }
        }catch (Throwable e){
            throw e;
        }finally {
            closeAll();
        }


        return compositionsServices;
    }
}
