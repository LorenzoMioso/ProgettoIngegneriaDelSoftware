package univr.spesaonline.model;

import java.sql.SQLException;
import java.util.List;

public interface CaratteristicaDao {
    
    public List<Caratteristica> getAllCaratteristica() throws SQLException;
}
