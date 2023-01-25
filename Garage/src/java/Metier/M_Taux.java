package Metier;

import DAO.DAO_Taux;
import Model.Taux;
import java.sql.Connection;

public class M_Taux {

    public Taux getTaux(Connection connection)throws Exception{
        try{
            return  new DAO_Taux().getTaux(connection);
        }catch (Throwable e){
            throw e;
        }
    }
}
