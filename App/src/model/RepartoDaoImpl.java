package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartoDaoImpl implements RepartoDao {

    private ConnectionDb db;

    public RepartoDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    public List<Reparto> getAllReparto() throws SQLException {
        List<Reparto> reparti = new ArrayList<Reparto>();
        db.doQuery("select * from Reparto");
        while (db.getResultSet().next()) {
            reparti.add(new Reparto(db.getResultSet().getString(1)));
        }
        return reparti;
    }

}
