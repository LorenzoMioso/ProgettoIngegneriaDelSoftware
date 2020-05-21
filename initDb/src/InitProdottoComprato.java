
import java.sql.SQLException;

public class InitProdottoComprato {

    private ConnectionDb db;

    public InitProdottoComprato() {
        db = ConnectionDb.getInstance();
    }

    public void createProdottoComprato() throws SQLException {
        db.doQuery("CREATE TABLE `ProdottoComprato` (\n"
                + " `idSpesa` int(11) NOT NULL,\n"
                + " `idProdotto` int(11) NOT NULL,\n"
                + " `quantitàProdotto` int (11) NOT NULL,\n"
                + " PRIMARY KEY (`idSpesa` ,`idProdotto`),\n"
                + " CONSTRAINT `fk_prodottoComprato_spesa` FOREIGN KEY (idSpesa) REFERENCES Spesa(id),\n"
                + " CONSTRAINT `fk_prodottoComprato_prodotto` FOREIGN KEY (idProdotto) REFERENCES Prodotto(id)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableProdottoComprato() throws SQLException {
        db.doQuery("");
    }
}
