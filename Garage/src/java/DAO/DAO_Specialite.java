package DAO;

import Model.Specialite;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Specialite extends DAO{
    public ArrayList<Specialite> getAll(Connection connect) throws Exception {
        ArrayList<Specialite> allSpecialite=new ArrayList<>();
           try{
                String sql = "select * from specialite";
                this.stmt= connect.prepareStatement(sql);
               this.rs = stmt.executeQuery();
                Specialite s = null;

                while(this.rs.next()) {
                    s = new Specialite();
                    s.setIdSpecialite(this.rs.getInt("idspecialite"));
                    s.setLibelle(this.rs.getString("libelle"));
                    allSpecialite.add(s);
                }
           }catch(Throwable e){
               throw e;
           } 
        return allSpecialite;
    }

    public void newSpecialite(Specialite s) throws Exception {
/// insérer une nouvelle spécialité dans la table spécialité
        Connexion con = new Connexion();
        Connection connect = con.getConnexion();

        String libelle = s.getLibelle();
        String sql = "insert into specialite(libelle) values('" + libelle +  ")";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
        connect.close();
    }
}
