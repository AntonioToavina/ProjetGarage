package DAO;

import Model.Employe;
import java.sql.Connection;
public class DAO_Employe extends DAO{
    public void newEmploye(Connection connect,Employe e) throws Exception {
        try{
            connect= new Connexion().getConnexion();
            String sql = "insert into employe(idemploye,nom, prenom, datenaissance, idniveauetude) values(?,?,?,?,?)";

           this.stmt= connect.prepareStatement(sql);
           this.stmt.setInt(1,e.getIdEmploye());
           this.stmt.setString(2,e.getNom());
           this.stmt.setString(3,e.getPrenom());
           this.stmt.setDate(4,e.getDateNaissance());
           this.stmt.setInt(5,e.getNiveauEtude().getIdNiveauEtude());
            this.stmt.executeUpdate();
            connect.commit();
            connect.close();
        }catch (Throwable ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            this.closeAll();
        }
    }

    public void setSpecialiteEmploye(Connection connect,Employe e)throws Exception{
        try{
            for(int i=0;i<e.getSpecialite().length;i++){
                String sql = "insert into employe_specialite values (?,?) ";
                this.stmt= connect.prepareStatement(sql);
                this.stmt.setInt(1,e.getSpecialite()[i].getIdSpecialite());
                this.stmt.setInt(2,e.getIdEmploye());
                stmt.executeUpdate();
                connect.commit();
            }
        }catch (Throwable ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            this.closeAll();
            if(connect!=null)
                connect.close();
        }
    }
}