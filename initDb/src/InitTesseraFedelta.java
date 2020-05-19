
import java.sql.SQLException;

public class InitTesseraFedelta { //TODO riferimento a utente

    private ConnectionDb db;

    public InitTesseraFedelta() {
        db = ConnectionDb.getInstance();
    }

    public void createTesseraFedelta() throws SQLException {
        db.doQuery("CREATE TABLE `TesseraFedelta` (\n"
                + " `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + " `dataEmissione` date NOT NULL,\n"
                + " `punti` int(11) NOT NULL,\n"
                + " `utente` varchar(100) NOT NULL,"
                + "  PRIMARY KEY `id`(`id`),\n"
                + "  CONSTRAINT `fk_tessera_utente` FOREIGN KEY(utente) REFERENCES Utente(email)\n"
                + ")ENGINE=InnoDB ");
    }

    public void fillTableTesseraFedelta() throws SQLException {
    }
}
