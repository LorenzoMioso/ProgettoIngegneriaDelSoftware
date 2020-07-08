package univr.spesaonline.model;

import java.sql.SQLException;

public interface ResponsabileRepartoDao {

    public ResponsabileReparto getResponsabileReparto(String matricola) throws SQLException;

    public void updateResponsabileReparto(ResponsabileReparto responsabile) throws SQLException;

}
