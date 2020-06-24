
import java.sql.SQLException;

public class InitTipo {

    private ConnectionDb db;

    public InitTipo() {
        db = ConnectionDb.getInstance();
    }

    public void createTipo() throws SQLException {
        db.doQuery("CREATE TABLE `Tipo` (\n"
                + "  `nome` varchar(100) NOT NULL,\n"
                + "  PRIMARY KEY (`nome`)) ENGINE=InnoDB");
    }

    public void fillTableTipo() throws SQLException {
        db.doQuery("INSERT INTO `Tipo` (`nome`) VALUES "
                + "('Uova'),"
                + "('Pasta'),"
                + "('Latte'),"
                + "('Biscotti');");
    }
}
