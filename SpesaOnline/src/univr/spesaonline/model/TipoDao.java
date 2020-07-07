package univr.spesaonline.model;

import java.sql.SQLException;
import java.util.List;

public interface TipoDao {

    /**
     *
     * @return @throws SQLException
     */
    public List<Tipo> getAllTipo() throws SQLException;
}
