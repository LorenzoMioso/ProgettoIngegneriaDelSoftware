package net.snortum.javafx.multiscenefxml.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDaoImpl implements UtenteDao, AutenticabileDao {

    private ConnectionDb db;

    public UtenteDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    @Override
    public void updateUtente(Utente utente) throws SQLException {
        db.doQuery("UPDATE Utente SET nome = '" + utente.getNome()
                + "',cognome = '" + utente.getCognome()
                + "',dataNascita = '" + utente.getDataNascita()
                + "',via = '" + utente.getVia()
                + "',nCivico = '" + utente.getnCivico()
                + "',citta = '" + utente.getCitta()
                + "',comune = '" + utente.getComune()
                + "',CAP = '" + utente.getCAP()
                + "',telefono = '" + utente.getTelefono()
                + "',pagamentoPreferito = '" + utente.getPagamentoPreferito()
                + "'WHERE email = '" + utente.getEmail() + "'");
        System.out.println(utente.toString());
        utente.setIsLogged(true);
    }

    @Override
    public Utente login(String username, String password) throws SQLException {
        Utente u = null;
        if (isRegistered(username) == true) {
            //controllo password 
            db.doQuery("select password from Utente WHERE email ='" + username + "'");
            db.getResultSet().next();
            String psw = db.getResultSet().getString(1);
            if (psw.equals(password)) {
                // fatch utente se la password è corretta
                db.doQuery("select * from Utente WHERE email ='" + username + "'");
                db.getResultSet().next();
                u = new Utente(
                        db.getResultSet().getString(1),
                        db.getResultSet().getString(2),
                        db.getResultSet().getString(3),
                        db.getResultSet().getString(4),
                        db.getResultSet().getDate(5),
                        db.getResultSet().getString(6),
                        db.getResultSet().getString(7),
                        db.getResultSet().getString(8),
                        db.getResultSet().getString(9),
                        db.getResultSet().getInt(10),
                        db.getResultSet().getString(11),
                        db.getResultSet().getString(12));
                u.setIsLogged(true);
            }
        }
        return u;
    }
    
    @Override
    public Utente getUtente(String email) throws SQLException{
         Utente u = null;
        if (isRegistered(email) == true) {
            //controllo password 
            db.doQuery("select password from Utente WHERE email ='" + email + "'");
            db.getResultSet().next();
            u = new Utente(
                    db.getResultSet().getString(1),
                    db.getResultSet().getString(2),
                    db.getResultSet().getString(3),
                    db.getResultSet().getString(4),
                    db.getResultSet().getDate(5),
                    db.getResultSet().getString(6),
                    db.getResultSet().getString(7),
                    db.getResultSet().getString(8),
                    db.getResultSet().getString(9),
                    db.getResultSet().getInt(10),
                    db.getResultSet().getString(11),
                    db.getResultSet().getString(12));
            u.setIsLogged(true);

        }
        return u;
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
        }
        return u;
    }

    @Override
    public boolean isRegistered(String username) throws SQLException {
        db.doQuery("SELECT CASE WHEN EXISTS ( SELECT * FROM `Utente` WHERE `email` = '" + username + "' ) THEN 1 ELSE 0 END as retVal");
        ResultSet resSet = db.getResultSet();
        resSet.next();
        System.out.println("retval: " + resSet.getInt("retVal"));
        if (resSet.getInt("retVal") == 1) {
            return true;
        } else {
            return false;
        }
    }
}
