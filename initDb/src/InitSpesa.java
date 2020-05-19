
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;


public class InitSpesa {

    private ConnectionDb db;

    public InitSpesa() {
        db = ConnectionDb.getInstance();
    }

    public void createSpesa() throws SQLException {
        db.doQuery("CREATE TABLE Spesa (\n"
                + "  id int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  dataOrdine TIMESTAMP NOT NULL DEFAULT current_timestamp(),\n"
                + "  dataConsegna DATE NOT NULL,\n"
                + "  oraInizio TIME NOT NULL,\n"
                + "  oraFine TIME NOT NULL,\n"
                + "  costoTot double NOT NULL,\n" 
                + "  saldoPunti int(11) NOT NULL,\n"
                + "  pagamento varchar(100) NOT NULL,\n"
                + "  utente varchar(100) NOT NULL,\n"
                + "  PRIMARY KEY id (id),\n"
                + "  KEY 1 (pagamento),\n"
                + "  KEY 2 (utente),\n"
                + "  CONSTRAINT 1 FOREIGN KEY(pagamento) REFERENCES Pagamento(tipologia),\n"
                + "  CONSTRAINT 2 FOREIGN KEY(utente) REFERENCES Utente(email)\n"
                + ")ENGINE=InnoDB ");
    }

    public void fillTableSpesa() throws SQLException {
        db.doQuery("INSERT INTO Spesa (id, nome, marca, reparto, stock, peso,nPezzi, prezzo) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '20', '500', '20', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '50', '200', '1', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '20', '500', '10',, '2');");
    }
}
