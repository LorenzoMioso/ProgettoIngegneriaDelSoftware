
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        InitMagazzino im= new InitMagazzino();
        im.createMagazzino();
        
        InitPagamento ip = new InitPagamento();
        ip.createPagamento();
        
        
        
        InitProdotto iprod = new InitProdotto();
        iprod.createProdotto();
         
        InitProdottoComprato ipc = new InitProdottoComprato();
        ipc.createProdottoComprato();
        
        InitReparto irep = new InitReparto();
        irep.createReparto();

        InitResponsabileReparto iresp = new InitResponsabileReparto();
        iresp.createResponsabileReparto();

        InitSpesa ispe = new InitSpesa();
        ispe.createSpesa();
        InitTesseraFedelta ites = new InitTesseraFedelta();
        ites.createTesseraFedelta();

        InitUtente iut = new InitUtente();
        iut.createUtente();
        
    }
}
