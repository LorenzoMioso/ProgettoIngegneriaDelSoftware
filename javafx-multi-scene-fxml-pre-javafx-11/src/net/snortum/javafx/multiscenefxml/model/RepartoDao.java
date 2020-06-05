package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.List;

public interface RepartoDao {

    public List<Reparto> getAllReparto() throws SQLException;
}
