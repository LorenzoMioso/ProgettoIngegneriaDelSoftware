
import java.sql.SQLException;

public class InitUtente {

    private ConnectionDb db;

    public InitUtente() {
        db = ConnectionDb.getInstance();
    }

    public void createUtente() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `email` text NOT NULL ,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `cognome` text NOT NULL,\n"
                + "  `citta` text NOT NULL,\n"
                + "  `telefono` int(11) NOT NULL,\n"
                + "  `matricola` text NOT NULL,\n"
                + "  `dataNascita` date NOT NULL,\n"
                + "  `via` text NOT NULL,\n"
                + "  `nCivico` text NOT NULL,\n"
                + "  `comune` text NOT NULL,\n"
                + "  `CAP` int(11) NOT NULL,\n"
                + "  `password` text NOT NULL,\n"
                + "  `pagamentoPreferito` text NOT NULL FOREIGN KEY REFERENCES Pagamento (tipologia),\n"
                + "  PRIMARY KEY `email` (`email`)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
