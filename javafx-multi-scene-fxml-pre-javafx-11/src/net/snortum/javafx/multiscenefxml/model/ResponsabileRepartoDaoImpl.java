/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snortum.javafx.multiscenefxml.model;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author elisa
 */
public class ResponsabileRepartoDaoImpl implements ResponsabileRepartoDao{
    
    private ConnectionDb db;
    
    public ResponsabileRepartoDaoImpl() {
        db = ConnectionDb.getInstance();
    }
    
    @Override
    public ResponsabileReparto getResponsabileReparto(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void updateResponsabileReparto(ResponsabileReparto responsabileReparto) throws SQLException {
         db.doQuery("UPDATE `Prodotto` SET `matricola`=["+ responsabileReparto.getMatricola()+"],`nome`=["+ responsabileReparto.getNome() +"],`cognome`=["+ responsabileReparto.getCognome() 
                 +"],`città`=["+ responsabileReparto.getCitta()+"],`comune`=["+ responsabileReparto.getComune()
                 +"],`via`=["+ responsabileReparto.getVia()+"],`nCivico`=["+ responsabileReparto.getnCivico()+"],`comuneDiNascita`=["+ responsabileReparto.getComuneDiNascita()+"],`username`=["+ 
                 responsabileReparto.getUsername()+"] ,`ruolo`=["+ responsabileReparto.getRuolo()+"] ,`password`=["+ responsabileReparto.getPassword()
                 +"]WHERE matricola ='"+ responsabileReparto.getMatricola() +"'");
    
    }

    @Override
    public void createResponsabileReparto() throws SQLException {
       db.doQuery("CREATE TABLE `ResponsabileReparto` (\n"
                + "  `matricola` text NOT NULL ,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `marca` text NOT NULL,\n"
                + "  `reparto` text NOT NULL,\n"
                + "  `quantità` int(11) NOT NULL,\n"
                + "  `prezzo` int(11) NOT NULL,\n"
                + "  UNIQUE KEY `id` (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1	");
    }

    @Override
    public void insertResponsabileReparto(ResponsabileReparto responsabileReparto) throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`matricola`, `nome`, `cognome`, `città`, `comune`, `via`, `nCivico`, `comuneDiNascita`, `username`, `ruolo`, `password`) VALUES `"
                + "(NULL, '" + responsabileReparto.getMatricola() + "', '" + responsabileReparto.getNome() + "', '" + responsabileReparto.getCognome() + "', '" + responsabileReparto.getCitta() + "', '" + responsabileReparto.getComune() +"', '" + responsabileReparto.getVia()+ "', '" + 
                responsabileReparto.getnCivico()+ "', '" + responsabileReparto.getComuneDiNascita()+ "', '" + responsabileReparto.getUsername()+ "', '" + responsabileReparto.getRuolo()+ "', '" + responsabileReparto.getPassword() +"')");
    
    }

    @Override
    public void fillTableResponsabileReparto() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
