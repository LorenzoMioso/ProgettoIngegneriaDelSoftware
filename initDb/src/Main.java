
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        DropCreateDb dcdb = new DropCreateDb();

        InitPagamento ip = new InitPagamento();
        ip.createPagamento();
        ip.fillTablePagamento();

        InitReparto irep = new InitReparto();
        irep.createReparto();
        irep.fillTableReparto();
        
        InitTipo itip = new InitTipo();
        itip.createTipo();
        itip.fillTableTipo();

        InitCaratteristica icar = new InitCaratteristica();
        icar.createCaratteristica();
        icar.fillTableCaratteristica();

        InitProdotto iprod = new InitProdotto();
        iprod.createProdotto();
        iprod.fillTableProdotto();

        InitUtente iut = new InitUtente();
        iut.createUtente();
        iut.fillTableUtente();

        InitMagazzino im = new InitMagazzino();
        im.createMagazzino();
        im.fillTableMagazzino();

        InitResponsabileReparto iresp = new InitResponsabileReparto();
        iresp.createResponsabileReparto();
        iresp.fillTableResponsabileReparto();

        InitTesseraFedelta ites = new InitTesseraFedelta();
        ites.createTesseraFedelta();
        ites.fillTableTesseraFedelta();

        InitSpesa ispe = new InitSpesa();
        ispe.createSpesa();

        InitProdottoComprato ipc = new InitProdottoComprato();
        ipc.createProdottoComprato();
        
        InitCaratteristicaProdotto icp = new InitCaratteristicaProdotto();
        icp.createCaratteristicaProdotto();

    }
}
