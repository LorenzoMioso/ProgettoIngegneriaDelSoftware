
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `marca` text NOT NULL,\n"
                + "  `reparto` text NOT NULL,\n"
                + "  `quantità` int(11) NOT NULL,\n"
                + "  `prezzo` int(11) NOT NULL,\n"
                + "  UNIQUE KEY `id` (`id`)\n"
                + ") AUTO_INCREMENT=1 DEFAULT CHARSET=latin1	");
    }

    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '30', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '100', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '30', '2');");
    }
}
