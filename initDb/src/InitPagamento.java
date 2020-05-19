
import java.sql.SQLException;

public class InitPagamento {

    private ConnectionDb db;

    public InitPagamento() {
        db = ConnectionDb.getInstance();
    }

    public void createPagamento() throws SQLException {
        db.doQuery("CREATE TABLE `Pagamento` ( `tipologia` varchar(100) NOT NULL , PRIMARY KEY (`tipologia`)) ENGINE=InnoDB");
    }

    public void fillTablePagamento() throws SQLException {
        db.doQuery("INSERT INTO `Pagamento` (`tipologia`) VALUES "
                + "('carta di credito'),"
                + "('paypal'),"
                + "('alla consegna');");
    }
}
