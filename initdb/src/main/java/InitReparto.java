
import java.sql.SQLException;

public class InitReparto {

    private ConnectionDb db;

    public InitReparto() {
        db = ConnectionDb.getInstance();
    }

    public void createReparto() throws SQLException {
        db.doQuery("CREATE TABLE `Reparto` (\n"
                + "  `nome` text NOT NULL,\n"
                + "  PRIMARY KEY `nome`\n) ");
    }

    public void fillTableReparto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`nome`) VALUES "
                + "('Frutta e Verdura'),"
                + "('Pasta e Pane'),"
                + "('Dolci e Biscotti'),"
                + "('Uova e Latticini'),"
                + "('Salumeria'),"
                + "('Acqua e Bibite'),"
                + "('Pescheria'),"
                + "('Scatolame');");
    }
}
