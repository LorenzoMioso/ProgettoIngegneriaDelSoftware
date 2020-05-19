
import java.sql.SQLException;

public class InitUtente {

    private ConnectionDb db;

    public InitUtente() {
        db = ConnectionDb.getInstance();
    }

    public void createUtente() throws SQLException {
        db.doQuery("CREATE TABLE ResponsabileReparto( "
                + "email varchar(100) NOT NULL,"
                + "nome varchar(100) NOT NULL,"
                + "cognome varchar(100) NOT NULL,"
                + "citta varchar(100) NOT NULL,"
                + "telefono INT(11) NOT NULL,"
                + "matricola varchar(100) NOT NULL,"
                + "dataNascita DATE NOT NULL,"
                + "via varchar(100) NOT NULL,"
                + "nCivico varchar(100) NOT NULL,"
                + "comune varchar(100) NOT NULL,"
                + "CAP INT(11) NOT NULL,"
                + "PASSWORD varchar(100) NOT NULL,"
                + "pagamentoPreferito varchar(100) NOT NULL,"
                + "PRIMARY KEY email(email),"
                + "CONSTRAINT fk_utente_pagamento FOREIGN KEY(pagamentoPreferito) REFERENCES Pagamento(tipologia)"
                + ") ENGINE = INNODB ");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
