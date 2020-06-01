package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDaoImpl implements UtenteDao, AutenticabileDao {

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
        db.doQuery("UPDATE Utente SET nome=[" + utente.getNome()
                + "],cognome=[" + utente.getCognome()
                + "],città=[" + utente.getCitta()
                + "],comune=[" + utente.getComune()
                + "],via=[" + utente.getVia()
                + "],nCivico=[" + utente.getnCivico()
                + "],CAP=[" + utente.getCAP()
                + "],telefono=[" + utente.getTelefono()
                + "],pagamentoPreferito=[" + utente.getPagamentoPreferito()
                + "]WHERE email ='" + utente.getEmail() + "'");
    }

    @Override
    public void insertUtente(Utente utente) throws SQLException {
        db.doQuery("INSERT INTO `Utente` (`email`, `nome`, `cognome`, `città`, `comune`, `via`, `nCivico`, `CAP`, `telefono`, `pagamentoPreferito`, `password`) VALUES `"
                + "(NULL, '" + utente.getEmail() + "', '" + utente.getNome() + "', '" + utente.getCognome() + "', '" + utente.getCitta() + "', '" + utente.getComune() + "', '" + utente.getVia() + "', '"
                + utente.getnCivico() + "', '" + utente.getCAP() + "', '" + utente.getTelefono() + "', '" + utente.getPagamentoPreferito() + "', '" + utente.getPassword() + "')");

    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout(Autenticabile autenticabile) {
        autenticabile.setIsLogged(false);
    }

    @Override
    public Utente register(String username, String password) throws SQLException {
        Utente u = null;
        if (isRegistered(username) == false) {
            db.doQuery("INSERT INTO `Utente` (`email`,`password`) VALUES ('" + username + "', '" + password + "')");
            u = new Utente(username, password);
            u.setIsLogged(true);
        }
        return u;
    }

    @Override
    public boolean isRegistered(String username) throws SQLException {
        db.doQuery("SELECT CASE WHEN EXISTS ( SELECT * FROM `Utente` WHERE `email` = '" + username + "' ) THEN 1 ELSE 0 END as retVal");
        ResultSet resSet = db.getResultSet();
        resSet.next();
        return resSet.getBoolean("retVal");
    }

}
