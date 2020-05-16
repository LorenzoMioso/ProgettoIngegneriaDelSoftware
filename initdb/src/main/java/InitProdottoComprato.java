
import java.sql.SQLException;

public class InitProdottoComprato {

    private ConnectionDb db;

    public InitProdottoComprato() {
        db = ConnectionDb.getInstance();
    }

    public void createProdottoComprato() throws SQLException {
        db.doQuery("CREATE TABLE `ProdottoComprato` (\n"
                + "  `idSpesa` int(11) NOT NULL FOREIGN KEY REFERENCES Spesa (id),\n"
                + "  `idProdotto` int(11) NOT NULL FOREIGN KEY REFERENCES Prodotto (id),\n"
                + "  `quantitàProdotto` int (11) NOT NULL\n"
                + "  PRIMARY KEY (`idSpesa` ,`idProdotto`)\n"
                + ") ");
    }

    public void fillTableProdottoComprato() throws SQLException {
        db.doQuery("INSERT INTO `ProdottoComprato` (`idSpesa`, `nome`, `marca`, `reparto`, `stock`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '20', '500', '20', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '50', '200', '1', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '20', '500', '10',, '2');");
    }
}
