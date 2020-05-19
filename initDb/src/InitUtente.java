
import java.sql.SQLException;

public class InitUtente {

    private ConnectionDb db;

    public InitUtente() {
        db = ConnectionDb.getInstance();
    }

    public void createUtente() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `email` varchar(100) NOT NULL ,\n"
                + "  `nome` varchar(100) NOT NULL,\n"
                + "  `cognome` varchar(100) NOT NULL,\n"
                + "  `citta` varchar(100) NOT NULL,\n"
                + "  `telefono` int(11) NOT NULL,\n"
                + "  `matricola` varchar(100) NOT NULL,\n"
                + "  `dataNascita` date NOT NULL,\n"
                + "  `via` varchar(100) NOT NULL,\n"
                + "  `nCivico` varchar(100) NOT NULL,\n"
                + "  `comune` varchar(100) NOT NULL,\n"
                + "  `CAP` int(11) NOT NULL,\n"
                + "  `password` varchar(100) NOT NULL,\n"
                + "  `pagamentoPreferito` varchar(100) NOT NULL ,\n"
                + "  PRIMARY KEY `email` (`email`)\n"
                 + "  CONSTRAIN `fk_utente_pagamento` FOREIGN KEY(pagamentoPreferito) REFERENCES Pagamento(tipologia)),\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
