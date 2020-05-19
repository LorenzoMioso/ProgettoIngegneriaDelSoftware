
import java.sql.SQLException;

public class InitMagazzino {

    private ConnectionDb db;

    public InitMagazzino() {
        db = ConnectionDb.getInstance();
    }

    public void createMagazzino() throws SQLException {
        db.doQuery("CREATE TABLE Magazzino (\n"
                + "  idProdotto int(11) NOT NULL,\n"
                + "  disponibilità int (11) NOT NULL,\n"
                + "  PRIMARY KEY idProdotto,\n"
                + "  CONSTRAINT fk_magazzino_prodotto FOREIGN KEY (idProdotto) REFERENCES Prodotto(id)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableMagazzino() throws SQLException {

    }
}
