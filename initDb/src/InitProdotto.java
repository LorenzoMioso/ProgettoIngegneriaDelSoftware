
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
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
                + " `immagine` longblob,\n"
                + " `reparto` varchar(100) NOT NULL ,\n"
                + " `inVendita` BOOLEAN NOT NULL DEFAULT TRUE,\n"
                + " `peso` DOUBLE NOT NULL,\n"
                + " `nPezzi` INT(11) NOT NULL,\n"
                + " `prezzo` DOUBLE NOT NULL,\n"
                + " PRIMARY KEY `id`(`id`),\n"
                + " CONSTRAINT `fk_prodotto_reparto` FOREIGN KEY (`reparto`) REFERENCES Reparto(`nome`)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableProdotto() throws SQLException, FileNotFoundException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`,`immagine`, `reparto`, `inVendita`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'Pane', 'marca', NULL, 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Focaccia', 'marca', NULL, 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Schiacciatine', 'marca', NULL, 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Baguette', 'marca', NULL, 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Salatini', 'marca', NULL, 'Panetteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Amaretti', 'marca', NULL, 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Confetti', 'marca', NULL, 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Cioccolatini', 'marca', NULL, 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Cioccolato fondente', 'marca', NULL, 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Torta', 'marca', NULL, 'Pasticceria', '1', '1000', '5', '2'),"
                + "(NULL, 'Spaghetti', 'marca', NULL, 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Fusilli', 'marca', NULL, 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Gnocchi', 'marca', NULL, 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Linguine', 'marca', NULL, 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Penne', 'marca', NULL, 'Pastificio', '1', '1000', '5', '2'),"
                + "(NULL, 'Ketchup', 'marca', NULL, 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Maionese', 'marca', NULL, 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Salsa barbecue', 'marca', NULL, 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Passata pomodoro', 'marca', NULL, 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Salsa di soia', 'marca', NULL, 'Sughi e Salse', '1', '1000', '5', '2'),"
                + "(NULL, 'Latte Fresco', 'marca', NULL, 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Grana', 'marca', NULL, 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Latte scremato', 'marca', NULL, 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Caciotta', 'marca', NULL, 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Stracchino', 'marca', NULL, 'Latteria', '1', '1000', '5', '2'),"
                + "(NULL, 'Macinato Maiale', 'marca', NULL, 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Petto di pollo', 'marca', NULL, 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Prosciutto cotto', 'marca', NULL, 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Strutto', 'marca', NULL, 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Wurstel', 'marca', NULL, 'Macelleria', '1', '1000', '5', '2'),"
                + "(NULL, 'Acciughe', 'marca', NULL, 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', NULL, 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Salmone', 'marca', NULL, 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Gamberi', 'marca', NULL, 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Sgombro', 'marca', NULL, 'Pescheria', '1', '1000', '5', '2'),"
                + "(NULL, 'Lasagne', 'marca', NULL, 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Polenta', 'marca', NULL, 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Insalata russa', 'marca', NULL, 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Fritto misto', 'marca', NULL, 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Mozzarelline panate', 'marca', NULL, 'Gastronomia', '1', '1000', '5', '2'),"
                + "(NULL, 'Gelati', 'marca', NULL, 'Surgelati', '1', '1000', '5', '2'),"
                + "(NULL, 'Ghiaccioli', 'marca', NULL, 'Surgelati', '1', '1000', '5', '2'),"
                + "(NULL, 'Albicocche', 'marca', NULL, 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Cocco', 'marca', NULL, 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Mele', 'marca', NULL, 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Prugne', 'marca', NULL, 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Pesche', 'marca', NULL, 'Frutta', '1', '1000', '5', '2'),"
                + "(NULL, 'Carote', 'marca', NULL, 'Verdura', '1', '1000', '5', '2'),"
                + "(NULL, 'The', 'marca', NULL, 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Coca Cola', 'marca', NULL, 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Birra', 'marca', NULL, 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Aranciata', 'marca', NULL, 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Red Bull', 'marca', NULL, 'Bevande', '1', '1000', '5', '2'),"
                + "(NULL, 'Grappa', 'marca', NULL, 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Spumante', 'marca', NULL, 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Gin', 'marca', NULL, 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Aperol', 'marca', NULL, 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Vodka', 'marca', NULL, 'Vini e Liquori', '1', '1000', '5', '2'),"
                + "(NULL, 'Aceto di mele', 'marca', NULL, 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio di palma', 'marca', NULL, 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Aceto di vino', 'marca', NULL, 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio extravergine', 'marca', NULL, 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Olio di soia', 'marca', NULL, 'Oli e aceti', '1', '1000', '5', '2'),"
                + "(NULL, 'Tonno', 'marca', NULL, 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Sottaceti', 'marca', NULL, 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Mais', 'marca', NULL, 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Olive nere', 'marca', NULL, 'Scatolame', '1', '1000', '5', '2'),"
                + "(NULL, 'Dado minestra', 'marca', NULL, 'Scatolame', '1', '1000', '5', '2')");
            fillImage();
    }   
    public void fillImage() throws SQLException, FileNotFoundException{
        //int id = 48;
        String query;
        File image;
        int size;
        PreparedStatement pstmt;
        FileInputStream fis;
        for(int id = 1; id < 3; id++){ 
            query = String.format("UPDATE Prodotto set immagine = ? WHERE id = %d", id);
            image = new File(String.format("../images/%d.jpg", id));
            size = (int) image.length();

            fis=new FileInputStream(image);
           
            pstmt = db.getPreparedStatement(query);
            pstmt.setBinaryStream(1,fis,size);
            pstmt.executeUpdate();

        }
        
      
    
    }
}
