
import java.sql.SQLException;

public class InitCaratteristica {

    private ConnectionDb db;

    public InitCaratteristica() {
        db = ConnectionDb.getInstance();
    }

    public void createCaratteristica() throws SQLException {
        db.doQuery("CREATE TABLE `Caratteristica` (\n"
                + "  `nome` varchar(100) NOT NULL,\n"
                + "  PRIMARY KEY (`nome`)) ENGINE=InnoDB");
    }

    public void fillTableCaratteristica() throws SQLException {
        db.doQuery("INSERT INTO `Caratteristica` (`nome`) VALUES "
                + "('Bio'),"
                + "('Senza latte'),"
                + "('Senza glutine'),"
                + "('Senza olio di palma'),"
                + "('Senza uova'),"
                + "('Vegan'),"
                + "('Senza frutta a guscio');");
    }
}
