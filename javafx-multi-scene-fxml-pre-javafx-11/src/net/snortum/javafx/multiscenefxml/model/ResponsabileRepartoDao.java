
package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.List;


public interface ResponsabileRepartoDao {
    

    public ResponsabileReparto getResponsabileReparto(int id) throws SQLException;

    public void updateResponsabileReparto(ResponsabileReparto responsabile) throws SQLException;

    public void createResponsabileReparto() throws SQLException;

    public void insertResponsabileReparto(ResponsabileReparto responsabile) throws SQLException;

    public void fillTableResponsabileReparto() throws SQLException;

}
