
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto`(\n"
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
                + ")ENGINE=InnoDB");
    }

    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'Pane', 'marca', 'Panetteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Focaccia', 'marca', 'Panetteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Schiacciatine', 'marca', 'Panetteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Baguette', 'marca', 'Panetteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Salatini', 'marca', 'Panetteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Amaretti', 'marca', 'Pasticceria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Confetti', 'marca', 'Pasticceria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Cioccolatini', 'marca', 'Pasticceria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Cioccolato fondente', 'marca', 'Pasticceria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Torta', 'marca', 'Pasticceria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Spaghetti', 'marca', 'Pastificio', 'true', '1000', '5', '2'),"
                + "(NULL, 'Fusilli', 'marca', 'Pastificio', 'true', '1000', '5', '2'),"
                + "(NULL, 'Gnocchi', 'marca', 'Pastificio', 'true', '1000', '5', '2'),"
                + "(NULL, 'Linguine', 'marca', 'Pastificio', 'true', '1000', '5', '2'),"
                + "(NULL, 'Penne', 'marca', 'Pastificio', 'true', '1000', '5', '2'),"
                + "(NULL, 'Ketchup', 'marca', 'Sughi e Salse', 'true', '1000', '5', '2'),"
                + "(NULL, 'Maionese', 'marca', 'Sughi e Salse', 'true', '1000', '5', '2'),"
                + "(NULL, 'Salsa barbecue', 'marca', 'Sughi e Salse', 'true', '1000', '5', '2'),"
                + "(NULL, 'Passata pomodoro', 'marca', 'Sughi e Salse', 'true', '1000', '5', '2'),"
                + "(NULL, 'Salsa di soia', 'marca', 'Sughi e Salse', 'true', '1000', '5', '2'),"
                + "(NULL, 'Latte Fresco', 'marca', 'Latteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Grana', 'marca', 'Latteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Latte scremato', 'marca', 'Latteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Caciotta', 'marca', 'Latteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Stracchino', 'marca', 'Latteria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Macinato Maiale', 'marca', 'Macelleria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Petto di pollo', 'marca', 'Macelleria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Prosciutto cotto', 'marca', 'Macelleria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Strutto', 'marca', 'Macelleria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Wurstel', 'marca', 'Macelleria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Acciughe', 'marca', 'Pescheria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', 'Pescheria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Salmone', 'marca', 'Pescheria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Gamberi', 'marca', 'Pescheria', 'true', '1000', '5', '2'),"
                + "(NULL, 'Sgombro', 'marca', 'Pescheria', 'true', '1000', '5', '2'),"
                
                
                + "(NULL, '', 'marca', '', 'true', '1000', '5', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '1', '500', '10', '2');");
    }
}
