
import java.sql.SQLException;

public class InitUtente {

    private ConnectionDb db;

    public InitUtente() {
        db = ConnectionDb.getInstance();
    }

    public void createUtente() throws SQLException {
        db.doQuery("CREATE TABLE ResponsabileReparto( email VARCHAR(100) NOT NULL, nome VARCHAR(100) NOT NULL, cognome VARCHAR(100) NOT NULL, citta VARCHAR(100) NOT NULL, telefono INT(11) NOT NULL, matricola VARCHAR(100) NOT NULL, dataNascita DATE NOT NULL, via VARCHAR(100) NOT NULL, nCivico VARCHAR(100) NOT NULL, comune VARCHAR(100) NOT NULL, CAP INT(11) NOT NULL, PASSWORD VARCHAR(100) NOT NULL, pagamentoPreferito VARCHAR(100) NOT NULL, PRIMARY KEY email(email), CONSTRAINT fk_utente_pagamento FOREIGN KEY(pagamentoPreferito) REFERENCES Pagamento(tipologia) ) ENGINE = INNODB ");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
