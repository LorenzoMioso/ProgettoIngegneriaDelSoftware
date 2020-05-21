
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto` ( "
                + " `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + " `nome` varchar(100) NOT NULL,\n"
                + " `marca` varchar(100) NOT NULL,\n"
                + " `reparto` varchar(100) NOT NULL ,\n"
                + " `inVendita` BOOLEAN NOT NULL DEFAULT TRUE,\n"
                + " `peso` DOUBLE NOT NULL,\n"
                + " `nPezzi` INT(11) NOT NULL,\n"
                + " `prezzo` DOUBLE NOT NULL,\n"
                + " PRIMARY KEY `id`(`id`),\n"
                + " CONSTRAINT `fk_prodotto_reparto` FOREIGN KEY (`reparto`) REFERENCES Reparto(`nome`)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'Pane', 'marca', 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Focaccia', 'marca', 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Schiacciatine', 'marca', 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Baguette', 'marca', 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Salatini', 'marca', 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Amaretti', 'marca', 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Confetti', 'marca', 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Cioccolatini', 'marca', 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Cioccolato fondente', 'marca', 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Torta', 'marca', 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Spaghetti', 'marca', 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Fusilli', 'marca', 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Gnocchi', 'marca', 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Linguine', 'marca', 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Penne', 'marca', 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Ketchup', 'marca', 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Maionese', 'marca', 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Salsa barbecue', 'marca', 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Passata pomodoro', 'marca', 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Salsa di soia', 'marca', 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Latte Fresco', 'marca', 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Grana', 'marca', 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Latte scremato', 'marca', 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Caciotta', 'marca', 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Stracchino', 'marca', 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Macinato Maiale', 'marca', 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Petto di pollo', 'marca', 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Prosciutto cotto', 'marca', 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Strutto', 'marca', 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Wurstel', 'marca', 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Acciughe', 'marca', 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Salmone', 'marca', 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Gamberi', 'marca', 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Sgombro', 'marca', 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Lasagne', 'marca', 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Polenta', 'marca', 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Insalata russa', 'marca', 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Fritto misto', 'marca', 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Mozzarelline panate', 'marca', 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Gelati', 'marca', 'Surgelati', '1', '1000', '5', '2'),"
                + "(NULL, 'Ghiaccioli', 'marca', 'Surgelati', '1', '1000', '5', '2'),"
                + "(NULL, 'Albicocche', 'marca', 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Cocco', 'marca', 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Mele', 'marca', 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Prugne', 'marca', 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Pesche', 'marca', 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Carote', 'marca', 'Verdura', '1', '1000', '5', '2'),"
                + "(NULL, 'The', 'marca', 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Coca Cola', 'marca', 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Birra', 'marca', 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Aranciata', 'marca', 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Red Bull', 'marca', 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Grappa', 'marca', 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Spumante', 'marca', 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Gin', 'marca', 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Aperol', 'marca', 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Vodka', 'marca', 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Aceto di mele', 'marca', 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio di palma', 'marca', 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Aceto di vino', 'marca', 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio extravergine', 'marca', 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio di soia', 'marca', 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Sottaceti', 'marca', 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Mais', 'marca', 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Olive nere', 'marca', 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Dado minestra', 'marca', 'Scatolame', '1', '1000', '5', '2')");
    }
}
