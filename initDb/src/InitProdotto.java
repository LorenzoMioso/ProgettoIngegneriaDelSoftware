
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto`(\n"
                + "    `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "    `nome` varchar(100) NOT NULL,\n"
                + "    `marca` varchar(100) NOT NULL,\n"
                + "    `reparto` varchar(100) NOT NULL ,\n"
                + "    `inVendita` BOOLEAN NOT NULL DEFAULT TRUE,\n"
                + "    `peso` INT(11) NOT NULL,\n"
                + "    `nPezzi` INT(11) NOT NULL,\n"
                + "    `prezzo` INT(11) NOT NULL,\n"
                + "    PRIMARY KEY `id`(`id`),\n"
                + "    CONSTRAINT `fk_prodotto_reparto` FOREIGN KEY (`reparto`) REFERENCES Reparto(`nome`)\n"
                + ")ENGINE=InnoDB");
    }

    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '1', '500', '20', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '1', '200', '1', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '1', '500', '10', '2');");
    }
}
