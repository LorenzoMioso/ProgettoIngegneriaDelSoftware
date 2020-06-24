package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaratteristicaDaoImpl implements CaratteristicaDao {

    private ConnectionDb db;

    public CaratteristicaDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public List<Caratteristica> getAllCaratteristica() throws SQLException {
        List<Caratteristica> caratteristiche = new ArrayList<Caratteristica>();
        db.doQuery("select * from Caratteristica");
        while (db.getResultSet().next()) {
            caratteristiche.add(new Caratteristica(db.getResultSet().getString(1)));
        }
        return caratteristiche;
    }

}
