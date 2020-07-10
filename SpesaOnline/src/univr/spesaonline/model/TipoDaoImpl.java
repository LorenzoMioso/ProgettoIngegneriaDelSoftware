package univr.spesaonline.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDaoImpl implements TipoDao {

    private ConnectionDb db;

    public TipoDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    @Override
    public List<Tipo> getAllTipo() throws SQLException {
        List<Tipo> tipi = new ArrayList<>();
        db.doQuery("select * from Tipo");
        while (db.getResultSet().next()) {
            tipi.add(new Tipo(db.getResultSet().getString(1)));
        }
        return tipi;
    }

}
