/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author elisa
 */
public class UtenteDaoImpl implements UtenteDao{
    
    private ConnectionDb db;
    
    public UtenteDaoImpl() {
        db = ConnectionDb.getInstance();
    }
    
    @Override
    public Utente getUtente(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void updateUtente(Utente utente) throws SQLException {
         db.doQuery("UPDATE `Prodotto` SET `email`=["+ utente.getEmail()+"],`nome`=["+ utente.getNome() +"],`cognome`=["+ utente.getCognome() 
                 +"],`città`=["+ utente.getCitta()+"],`comune`=["+ utente.getComune()
                 +"],`via`=["+ utente.getVia()+"],`nCivico`=["+ utente.getnCivico()+"],`CAP`=["+ utente.getCAP()+"],`telefono`=["+ 
                 utente.getTelefono()+"] ,`pagamentoPreferito`=["+ utente.getPagamentoPreferito()+"] ,`password`=["+ utente.getPassword()
                 +"]WHERE email ='"+ utente.getEmail() +"'");
    
    }

    @Override
    public void createUtente() throws SQLException {
       db.doQuery("CREATE TABLE `Utente` (\n"
                + "  `email` text NOT NULL ,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `marca` text NOT NULL,\n"
                + "  `reparto` text NOT NULL,\n"
                + "  `quantità` int(11) NOT NULL,\n"
                + "  `prezzo` int(11) NOT NULL,\n"
                + "  UNIQUE KEY `id` (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1	");
    }

    @Override
    public void insertUtente(Utente utente) throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`email`, `nome`, `cognome`, `città`, `comune`, `via`, `nCivico`, `CAP`, `telefono`, `pagamentoPreferito`, `password`) VALUES `"
                + "(NULL, '" + utente.getEmail() + "', '" + utente.getNome() + "', '" + utente.getCognome() + "', '" + utente.getCitta() + "', '" + utente.getComune() +"', '" + utente.getVia()+ "', '" + 
                utente.getnCivico()+ "', '" + utente.getCAP()+ "', '" + utente.getTelefono()+ "', '" + utente.getPagamentoPreferito()+ "', '" + utente.getPassword() +"')");
    
    }

    @Override
    public void fillTableUtente() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
