
import java.sql.SQLException;

public class InitResponsabileReparto { //TODO riferimento a reparto

    private ConnectionDb db;

    public InitResponsabileReparto() {
        db = ConnectionDb.getInstance();
    }

    public void createResponsabileReparto() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  `matricola` varchar(100) NOT NULL,\n"
                + "  `dataNascita` date NOT NULL,\n"
                + "  `via` varchar(100) NOT NULL,\n"
                + "  `nome` varchar(100) NOT NULL,\n"
                + "  `citta` varchar(100) NOT NULL,\n"
                + "  `username` varchar(100) NOT NULL,\n"
                + "  `cognome` varchar(100) NOT NULL,\n"
                + "  `nCivico` varchar(100) NOT NULL,\n"
                + "  `comune` varchar(100) NOT NULL,\n"
                + "  `comuneDiNascita` varchar(100) NOT NULL,\n"
                + "  `ruolo` varchar(100) NOT NULL ,\n"
                + "  `password` varchar(100) NOT NULL,\n"
                + "  PRIMARY KEY `id` (`id`),\n"
                +"   CONSTRAINT `fk_responsabile_reparto` FOREIGN KEY(ruolo) REFERENCES Reparto(nome)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
