
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `marca` text NOT NULL,\n"
                + "  `reparto` text NOT NULL FOREIGN KEY REFERENCES Reparto (nome),\n"
                + "  `inVendita` BOOLEAN NOT NULL DEFAULT TRUE,\n"
                + "   `peso` int(11) NOT NULL,\n" 
                + "   `nPezzi` int(11) NOT NULL,\n"
                + "  `prezzo` int(11) NOT NULL\n"
                + "  PRIMARY KEY `id` (`id`)\n"
                + ") ");
    }

    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '1', '500', '20', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '1', '200', '1', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '1', '500', '10', '2');");
    }
}
