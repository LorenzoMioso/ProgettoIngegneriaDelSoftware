
import java.sql.SQLException;

public class InitResponsabileReparto { //TODO riferimento a reparto

    private ConnectionDb db;

    public InitResponsabileReparto() {
        db = ConnectionDb.getInstance();
    }

    public void createResponsabileReparto() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  `matricola` text NOT NULL,\n"
                + "  `dataNascita` date NOT NULL,\n"
                + "  `via` text NOT NULL,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `citta` text NOT NULL,\n"
                + "  `username` text NOT NULL,\n"
                + "  `cognome` text NOT NULL,\n"
                + "  `nCivico` text NOT NULL,\n"
                + "  `comune` text NOT NULL,\n"
                + "  `comuneDiNascita` text NOT NULL,\n"
                + "  `ruolo` text NOT NULL,\n"
                + "  `password` text NOT NULL,\n"
                + "  PRIMARY KEY `id` (`id`)\n"
                + ") ");
    }

    public void fillTableResponsabileReparto() throws SQLException {
    }
}
