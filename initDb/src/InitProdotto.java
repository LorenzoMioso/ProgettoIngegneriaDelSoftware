
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitProdotto {

    private ConnectionDb db;

    public InitProdotto() {
        db = ConnectionDb.getInstance();
    }

    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto` ( "
                + " `id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + " `nome` varchar(100),\n"
                + " `marca` varchar(100),\n"
                + " `immagine` longblob,\n"
                + " `tipo` varchar(100),\n"
                + " `reparto` varchar(100),\n"
                + " `inVendita` BOOLEAN DEFAULT TRUE,\n"
                + " `peso` DOUBLE,\n"
                + " `nPezzi` INT(11),\n"
                + " `prezzo` DOUBLE,\n"
                + " PRIMARY KEY `id`(`id`),\n"
                + " CONSTRAINT `fk_prodotto_reparto` FOREIGN KEY (`reparto`) REFERENCES Reparto(`nome`),\n"
                + " CONSTRAINT `fk_prodotto_tipo` FOREIGN KEY (`tipo`) REFERENCES Tipo(`nome`)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableProdotto() throws SQLException, FileNotFoundException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`,`immagine`, `tipo`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'Pane', 'marca', NULL, 'Uova', 'Panetteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Focaccia', 'marca', NULL, 'Uova', 'Panetteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Schiacciatine', 'marca', NULL, 'Uova', 'Panetteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Baguette', 'marca', NULL, 'Uova', 'Panetteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Salatini', 'marca', NULL, 'Uova', 'Panetteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Amaretti', 'marca', NULL, 'Uova', 'Pasticceria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Confetti', 'marca', NULL, 'Uova', 'Pasticceria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Cioccolatini', 'marca', NULL, 'Uova', 'Pasticceria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Cioccolato fondente', 'marca', NULL, 'Uova', 'Pasticceria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Torta', 'marca', NULL, 'Uova', 'Pasticceria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Spaghetti', 'marca', NULL, 'Uova', 'Pastificio', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Fusilli', 'marca', NULL, 'Uova', 'Pastificio', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Gnocchi', 'marca', NULL, 'Uova', 'Pastificio', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Linguine', 'marca', NULL, 'Uova', 'Pastificio', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Penne', 'marca', NULL, 'Uova', 'Pastificio', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Ketchup', 'marca', NULL, 'Uova', 'Sughi e Salse', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Maionese', 'marca', NULL, 'Uova', 'Sughi e Salse', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Salsa barbecue', 'marca', NULL, 'Uova', 'Sughi e Salse', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Passata pomodoro', 'marca', NULL, 'Uova', 'Sughi e Salse', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Salsa di soia', 'marca', NULL, 'Uova', 'Sughi e Salse', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Latte Fresco', 'marca', NULL, 'Uova', 'Latteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Grana', 'marca', NULL, 'Uova', 'Latteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Latte scremato', 'marca', NULL, 'Uova', 'Latteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Caciotta', 'marca', NULL, 'Uova', 'Latteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Stracchino', 'marca', NULL, 'Uova', 'Latteria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Macinato Maiale', 'marca', NULL, 'Uova', 'Macelleria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Petto di pollo', 'marca', NULL, 'Uova', 'Macelleria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Prosciutto cotto', 'marca', NULL, 'Uova', 'Macelleria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Strutto', 'marca', NULL, 'Uova', 'Macelleria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Wurstel', 'marca', NULL, 'Uova', 'Macelleria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Acciughe', 'marca', NULL, 'Uova', 'Pescheria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', NULL, 'Uova', 'Pescheria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Salmone', 'marca', NULL, 'Uova', 'Pescheria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Gamberi', 'marca', NULL, 'Uova', 'Pescheria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Sgombro', 'marca', NULL, 'Uova', 'Pescheria', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Lasagne', 'marca', NULL, 'Uova', 'Gastronomia', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Polenta', 'marca', NULL, 'Uova', 'Gastronomia', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Insalata russa', 'marca', NULL, 'Uova', 'Gastronomia', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Fritto misto', 'marca', NULL, 'Uova', 'Gastronomia', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Mozzarelline panate', 'marca', NULL, 'Uova', 'Gastronomia', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Gelati', 'marca', NULL, 'Uova', 'Surgelati', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Ghiaccioli', 'marca', NULL, 'Uova', 'Surgelati', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Albicocche', 'marca', NULL, 'Uova', 'Frutta', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Cocco', 'marca', NULL, 'Uova', 'Frutta', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Mele', 'marca', NULL, 'Uova', 'Frutta', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Prugne', 'marca', NULL, 'Uova', 'Frutta', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Pesche', 'marca', NULL, 'Uova', 'Frutta', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Carote', 'marca', NULL, 'Uova', 'Verdura', '1', '1000.0', '5', '2'),"
                + "(NULL, 'The', 'marca', NULL, 'Uova', 'Bevande', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Coca Cola', 'marca', NULL, 'Uova', 'Bevande', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Birra', 'marca', NULL, 'Uova', 'Bevande', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Aranciata', 'marca', NULL, 'Uova', 'Bevande', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Red Bull', 'marca', NULL, 'Uova', 'Bevande', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Grappa', 'marca', NULL, 'Uova', 'Vini e Liquori', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Spumante', 'marca', NULL, 'Uova', 'Vini e Liquori', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Gin', 'marca', NULL, 'Uova', 'Vini e Liquori', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Aperol', 'marca', NULL, 'Uova', 'Vini e Liquori', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Vodka', 'marca', NULL, 'Uova', 'Vini e Liquori', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Aceto di mele', 'marca', NULL, 'Uova', 'Oli e aceti', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Olio di palma', 'marca', NULL, 'Uova', 'Oli e aceti', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Aceto di vino', 'marca', NULL, 'Uova', 'Oli e aceti', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Olio extravergine', 'marca', NULL, 'Uova', 'Oli e aceti', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Olio di soia', 'marca', NULL, 'Uova', 'Oli e aceti', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', NULL, 'Uova', 'Scatolame', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Sottaceti', 'marca', NULL, 'Uova', 'Scatolame', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Mais', 'marca', NULL, 'Uova', 'Scatolame', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Olive nere', 'marca', NULL, 'Uova', 'Scatolame', '1', '1000.0', '5', '2'),"
                + "(NULL, 'Dado minestra', 'marca', NULL, 'Uova', 'Scatolame', '1', '1000.0', '5', '2')");
        fillImage();
    }

    public void fillImage() throws SQLException, FileNotFoundException {
        String query;
        File image;
        int size;
        PreparedStatement pstmt;
        FileInputStream fis;
        //conto quanti sono i prodotti in Prodotto
        db.doQuery("SELECT COUNT(*) AS rowcount from Prodotto");
        ResultSet rset = db.getResultSet();
        rset.next();
        int numeroProdotti = rset.getInt("rowcount");
        rset.close();
        //System.out.println("Numero di prodotti = "+ numeroProdotti);
        //per ogni prodotto aggiungo la sua immagine
        for (int id = 1; id <= numeroProdotti; id++) {
            query = String.format("UPDATE Prodotto set immagine = ? WHERE id = %d", id);
            image = new File(String.format("../images/%d.jpg", id));
            if (image.exists()) {
                size = (int) image.length();
                fis = new FileInputStream(image);
                pstmt = db.getPreparedStatement(query);
                pstmt.setBinaryStream(1, fis, size);
                pstmt.executeUpdate();

            }

        }

    }
}
