
import java.sql.SQLException;

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
                + "  PRIMARY KEY `id`(`id`),\n"
                + "  CONSTRAINT `fk_spesa_pagamento` FOREIGN KEY(pagamento) REFERENCES Pagamento(tipologia),\n"
                + "  CONSTRAINT `fk_spesa_utente` FOREIGN KEY(utente) REFERENCES Utente(email)\n"
                + ")ENGINE=InnoDB ");
    }

    public void fillTableSpesa() throws SQLException {
        db.doQuery("");
    }
}
