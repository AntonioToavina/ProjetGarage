package DAO;

import Model.Service;
import java.sql.Connection;
import java.util.ArrayList;

public class DAO_Service extends DAO {

    public ArrayList<Service> getAll() throws Exception {
        ArrayList<Service> list = new ArrayList<>();
        Connection connect = new Connexion().getConnexion();
        try {
            String sql = "select * from service";
            this.stmt = connect.prepareStatement(sql);
            this.rs = stmt.executeQuery();
            Service ne = null;

            while (this.rs.next()) {
                ne = new Service();
                ne.setIdService(this.rs.getInt("idservice"));
                ne.setNomService(this.rs.getString("nomservice"));
                ne.setPrixHoraire(this.rs.getDouble("prixhoraire"));
                ne.setTaux(this.rs.getDouble("taux"));
                list.add(ne);
            }
        } catch (Throwable e) {
            throw e;
        } finally {
            connect.close();
        }

        return list;
    }
    
    public void modifTaux(Service service)throws Exception{
        Connection connect=null;
        try{
            connect=new Connexion().getConnexion();
            String sql="UPDATE service set taux=? where idservice=?";
            this.stmt = connect.prepareStatement(sql);
            this.stmt.setDouble(1, service.getTaux());
            this.stmt.setInt(2, service.getIdService());
            this.stmt.executeUpdate();
            
            connect.commit();
        }catch(Throwable e){
            connect.rollback();
            throw e;
        }
        finally{
            closeAll();
            if(connect!=null)
                connect.close();
        }
    }
}
