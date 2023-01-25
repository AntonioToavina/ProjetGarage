package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    ResultSet rs=null;
    PreparedStatement stmt=null;

    public void closeAll()throws Exception{
        try{
            if(this.rs!=null)
                this.rs.close();
            if(this.stmt!=null)
                this.stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int getNextValue(String seq, Connection connection) throws Exception{
        int id=0;
        try{
            String sql="SELECT nextval(?)";
            this.stmt=connection.prepareStatement(sql);
            this.stmt.setString(1, seq);
            this.rs=this.stmt.executeQuery();

            while(this.rs.next())
                id=Integer.parseInt(this.rs.getObject(1).toString());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeAll();
        }
        return id;
    }
}
