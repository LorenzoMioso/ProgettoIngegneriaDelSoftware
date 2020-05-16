
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        InitProdotto iprod = new InitProdotto();
        iprod.createProdotto();

        InitReparto irep = new InitReparto();
        irep.createReparto();

        InitResponsabileReparto iresp = new InitResponsabileReparto();
        iresp.createResponsabileReparto();

        //InitSpesa ispe = new InitSpesa();
        InitTesseraFedelta ites = new InitTesseraFedelta();
        ites.createTesseraFedelta();

        InitUtente iut = new InitUtente();
        iut.createUtente();
    }
}
