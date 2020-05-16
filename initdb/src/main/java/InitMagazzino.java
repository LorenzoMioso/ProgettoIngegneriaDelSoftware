
import java.sql.SQLException;

public class InitMagazzino {

    private ConnectionDb db;

    public InitMagazzino() {
        db = ConnectionDb.getInstance();
    }

    public void createMagazzino() throws SQLException {
        db.doQuery("CREATE TABLE `Magazzino` (\n"
                + "  `idProdotto` int(11) NOT NULL FOREIGN KEY REFERENCES Prodotto (id),\n"
                + "  `disponibilità` int (11) NOT NULL\n"
                + "  PRIMARY KEY `idProdotto`\n) ");
    }

    public void fillTableMagazzino() throws SQLException {
        
    }
}
