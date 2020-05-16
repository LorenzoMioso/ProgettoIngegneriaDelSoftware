
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;


public class InitSpesa {
     private int id;
    private Date dataConsegna;
    private Time oraInizio;
    private Time oraFine;
    private int costoTot;
    private int saldoPunti;
    private String pagamento;
    
    
    private String stato;    
    
    private ConnectionDb db;

    public InitSpesa() {
        db = ConnectionDb.getInstance();
    }

    public void createSpesa() throws SQLException {
        db.doQuery("CREATE TABLE `Spesa` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT ,\n"
                + "  `dataOrdine` TIMESTAMP NOT NULL DEFAULT current_timestamp(),\n"
                + "  `dataConsegna` DATE NOT NULL,\n"
                + "  `oraInizio` TIME NOT NULL,\n"
                + "  `oraFine` TIME NOT NULL,\n"
                + "  `costoTot` double NOT NULL,\n" 
                + "  `saldoPunti` int(11) NOT NULL,\n"
                + "  `pagamento` text NOT NULL FOREIGN KEY REFERENCES Pagamento(tipologia),\n"
                + "  `utente` text NOT NULL FOREIGN KEY REFERENCES Utente(email)\n"
                + "  PRIMARY KEY `id` (`id`)\n"
                + ") ");
    }

    public void fillTableSpesa() throws SQLException {
        db.doQuery("INSERT INTO `Spesa` (`id`, `nome`, `marca`, `reparto`, `stock`, `peso`,`nPezzi`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '20', '500', '20', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '50', '200', '1', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '20', '500', '10',, '2');");
    }
}
