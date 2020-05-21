
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DropCreateDb dcdb = new DropCreateDb();
        
        InitPagamento ip = new InitPagamento();
        ip.createPagamento();
        ip.fillTablePagamento();

        InitReparto irep = new InitReparto();
        irep.createReparto();

        InitProdotto iprod = new InitProdotto();
        iprod.createProdotto();

        InitUtente iut = new InitUtente();
        iut.createUtente();
        iut.fillTableUtente();
        
        InitMagazzino im = new InitMagazzino();
        im.createMagazzino();

        InitResponsabileReparto iresp = new InitResponsabileReparto();
        iresp.createResponsabileReparto();

        InitSpesa ispe = new InitSpesa();
        ispe.createSpesa();

        InitTesseraFedelta ites = new InitTesseraFedelta();
        ites.createTesseraFedelta();
        ites.fillTableTesseraFedelta();

        InitProdottoComprato ipc = new InitProdottoComprato();
        ipc.createProdottoComprato();

    }
}
