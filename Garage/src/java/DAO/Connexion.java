package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    Connection connexion;
    public Connexion(){
        try{
            Class.forName("org.postgresql.Driver");
            this.connexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/garage","antonio","antonio");
            this.connexion.setAutoCommit(false);
        }catch(Exception e){System.out.println("Connection: "+e.getMessage());}
    }

    /**
     * @return the connexion
     */
    public Connection getConnexion() {
        return connexion;
    }
}
