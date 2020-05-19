
import java.sql.SQLException;

public class InitTesseraFedelta { //TODO riferimento a utente

    private ConnectionDb db;

    public InitTesseraFedelta() {
        db = ConnectionDb.getInstance();
    }

    public void createTesseraFedelta() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  `dataEmissione` date NOT NULL,\n"
                + "  `punti` int(11) NOT NULL,\n"
                + "  `utente` text NOT NULL FOREIGN KEY REFERENCES Utente (email),"
                + "  PRIMARY KEY `id` (`id`)\n"
                + ")ENGINE=InnoDB ");
    }

    public void fillTableTesseraFedelta() throws SQLException {
    }
}
