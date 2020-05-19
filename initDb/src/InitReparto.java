
import java.sql.SQLException;

public class InitReparto {

    private ConnectionDb db;

    public InitReparto() {
        db = ConnectionDb.getInstance();
    }

    public void createReparto() throws SQLException {
        db.doQuery("CREATE TABLE `Reparto` (\n"
                + "  `nome` varchar(100) NOT NULL,\n"
                + "  PRIMARY KEY (`nome`)) ENGINE=InnoDB");
    }

    public void fillTableReparto() throws SQLException {
        db.doQuery("INSERT INTO `Reparto` (`nome`) VALUES "
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
