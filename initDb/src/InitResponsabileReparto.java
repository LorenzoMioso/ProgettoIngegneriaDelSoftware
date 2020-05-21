
import java.sql.SQLException;

public class InitResponsabileReparto { //TODO riferimento a reparto

    private ConnectionDb db;

    public InitResponsabileReparto() {
        db = ConnectionDb.getInstance();
    }

    public void createResponsabileReparto() throws SQLException {
        db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `matricola` varchar(100) NOT NULL,\n"
                + "  `nome` varchar(100) NOT NULL,"
                + "  `cognome` varchar(100) NOT NULL," 
                + "  `dataNascita` date NOT NULL,\n"
                + "  `via` varchar(100) NOT NULL,\n"
                + "  `nCivico` varchar(100) NOT NULL,\n"
                + "  `comune` varchar(100) NOT NULL,\n"
                + "  `citta` varchar(100) NOT NULL,\n"
                + "  `comuneDiNascita` varchar(100) NOT NULL,\n"
                + "  `username` varchar(100) NOT NULL,\n"
                + "  `password` varchar(100) NOT NULL,\n"
                + "  `ruolo` varchar(100) NOT NULL ,\n"
                + "  PRIMARY KEY `matricola` (`matricola`),\n"
                +"   CONSTRAINT `fk_responsabile_reparto` FOREIGN KEY(ruolo) REFERENCES Reparto(nome)\n"
                + ") ENGINE=InnoDB");
    }

    public void fillTableResponsabileReparto() throws SQLException {
        db.doQuery("INSERT INTO `ResponsabileReparto` (`matricola`,`nome`, `cognome`, `dataNascita`,`via`, `nCivico`, `comune`,`citta`, `comuneDiNascita`,  `username`, `password`, `ruolo`) VALUES "
                + "('4253', 'Fabio', 'Bianchi', STR_TO_DATE('10/05/1986', '%d/%m/%Y'), 'via Roveggia', '2', 'Verona','Verona','Verona', 'fbianchi', '1234', 'Frutta'),"
                + "('8659', 'Roberta', 'Guerra', STR_TO_DATE('30/05/1965', '%d/%m/%Y'), 'Via Guglielmo Marconi ', '5', 'Recoaro Terme','Vicenza','Vicenza', 'rguerra', 'ciao', 'Panetteria');");
    
    }
}
