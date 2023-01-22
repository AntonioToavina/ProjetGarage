/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.CompositionService;

/**
 *
 * @author ITU
 */
public class DAO_CompositionService {
    public ArrayList<CompositionService> decompositionService(Connection connect, String nomService) throws Exception {
        boolean isOpen = false;
        if(connect == null) {
            Connexion con = new Connexion();
            connect = con.getConnexion("garage", "postgres", "pg");
            isOpen = true;
        } else {
            isOpen = true;
        }
        String sql = "WITH RECURSIVE cte_query AS (";
        sql += " select idservice, nomservice, idspecialite, libelle, salairehoraire, duree from v_service vs where(nomservice ='" + nomService + "')";
        sql += " UNION select vs.idservice, vs.nomservice, vs.idspecialite, vs.libelle, vs.salairehoraire, vs.duree";
        sql += " from v_service vs INNER JOIN cte_query cq ON cq.idservice = cq.idspecialite)";
        sql += " select * from cte_query";
        
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<CompositionService> compositionsServices = new ArrayList<>();
        CompositionService cs = null;
        
        while(res.next()) {
            cs = new CompositionService();
            cs.setIdservice(res.getInt("idservice"));
            cs.setNomService(res.getString("nomservice"));
            cs.setIdSpecialite(res.getInt("idspecialite"));
            cs.setLibelle(res.getString("libelle"));
            cs.setSalaireHoraire(res.getDouble("salairehoraire"));
            cs.setDuree(res.getDouble("duree"));
            compositionsServices.add(cs);
        }
        
        if(isOpen == true) {
            connect.close();
        }
        return compositionsServices;
    } 
}
