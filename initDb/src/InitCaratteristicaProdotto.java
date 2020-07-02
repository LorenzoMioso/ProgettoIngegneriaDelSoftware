
import java.sql.SQLException;

public class InitCaratteristicaProdotto {

    private ConnectionDb db;

    public InitCaratteristicaProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createCaratteristicaProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `CaratteristicaProdotto` (\n"
                + " `idProdotto` int(11) NOT NULL ,\n"
                + " `nomeCaratteristica` varchar(100) NOT NULL ,\n"
                + " PRIMARY KEY (`nomeCaratteristica` ,`idProdotto`),\n"
                + " KEY `fk_CaratteristicaProdotto_prodotto` (`idProdotto`),\n"
                + " KEY `fk_CaratteristicaProdotto_caratteristica` (`nomeCaratteristica`),\n"
                + " CONSTRAINT `fk_CaratteristicaProdotto_caratteristica` FOREIGN KEY (`nomeCaratteristica`) REFERENCES `Caratteristica` (`nome`),\n"
                + " CONSTRAINT `fk_CaratteristicaProdotto_prodotto` FOREIGN KEY (`idProdotto`) REFERENCES `Prodotto` (`id`)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableCaratteristicaProdotto() throws SQLException {
        db.doQuery("INSERT INTO `CaratteristicaProdotto` (`idProdotto`, `nomeCaratteristica`) VALUES "
                + "('11', 'Senza Latte' ),"
                + "('45', 'Bio'),"
                + "('45', 'Vegan')");
        
    }
}
