
import java.sql.SQLException;

public class InitUtente {

    private ConnectionDb db;

    public InitUtente() {
        db = ConnectionDb.getInstance();
    }

    public void createUtente() throws SQLException {
        db.doQuery("CREATE TABLE Utente( "
                + "email varchar(100) NOT NULL,"
                + "nome varchar(100) NOT NULL,"
                + "cognome varchar(100) NOT NULL,"
                + "citta varchar(100) NOT NULL,"
                + "telefono INT(11) NOT NULL,"
                + "dataNascita DATE NOT NULL,"
                + "via varchar(100) NOT NULL,"
                + "nCivico varchar(100) NOT NULL,"
                + "comune varchar(100) NOT NULL,"
                + "CAP INT(11) NOT NULL,"
                + "password varchar(100) NOT NULL,"
                + "pagamentoPreferito varchar(100) NOT NULL,"
                + "PRIMARY KEY email(email),"
                + "CONSTRAINT fk_utente_pagamento FOREIGN KEY(pagamentoPreferito) REFERENCES Pagamento(tipologia)"
                + ") ENGINE = INNODB ");
    }

    public void fillTableUtente() throws SQLException {
        db.doQuery("INSERT INTO `Utente` (`email`, `nome`, `cognome`, `citta`, `telefono`, `dataNascita`,`via`, `nCivico`, `comune`, `CAP`, `password`, `pagamentoPreferito`) VALUES "
                + "('mrossi@gmail.com', 'mario', 'rossi', 'Verona', '045721106', STR_TO_DATE('10/05/1986', '%d/%m/%Y'), 'via Verdi', '2', 'Verona', '37030', '1234', 'paypal'),"
                + "('mstella@gmail.com', 'marina', 'stella', 'Bergamo', '034621812', STR_TO_DATE('30/05/1965', '%d/%m/%Y'), 'Via Enrico Albricci ', '5', 'Clusone', '37030', 'ciao', 'alla consegna');");
    }
}
