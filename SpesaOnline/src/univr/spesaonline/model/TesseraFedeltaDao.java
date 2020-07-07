package univr.spesaonline.model;

import java.sql.SQLException;

public interface TesseraFedeltaDao {

    public TesseraFedelta getTesseraFedelta(int id) throws SQLException;

    public void deleteTesseraFedelta(TesseraFedelta tesseraFedelta) throws SQLException;

    public void insertTesseraFedelta(TesseraFedelta tesseraFedelta) throws SQLException;
}
