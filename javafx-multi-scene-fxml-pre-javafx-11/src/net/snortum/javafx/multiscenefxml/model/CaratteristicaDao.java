package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.List;

public interface CaratteristicaDao {

    /**
     *
     * @return @throws SQLException
     */
    public List<Caratteristica> getAllCaratteristica() throws SQLException;
}
