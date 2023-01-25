package DAO;

import Model.Taux;
import java.sql.Connection;

public class DAO_Taux extends DAO {

    public Taux getTaux(Connection connect) throws Exception {
        Taux taux = new Taux();
        try {
            this.stmt = connect.prepareStatement("SELECT * FROM taux");
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                taux.setTaux(this.rs.getDouble("taux"));
                taux.setIdtaux(this.rs.getInt("idtaux"));
            }
        } catch (Throwable e) {
            throw e;
        } finally {
            this.closeAll();
        }

        return taux;
    }
}
