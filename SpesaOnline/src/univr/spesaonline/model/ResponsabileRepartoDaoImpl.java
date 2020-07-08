package univr.spesaonline.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsabileRepartoDaoImpl implements ResponsabileRepartoDao, AutenticabileDao {

    private ConnectionDb db;

    public ResponsabileRepartoDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    @Override
    public ResponsabileReparto getResponsabileReparto(String matricola) throws SQLException {
        ResponsabileReparto r = null;
        if (isRegistered(matricola) == true) {
            //controllo password 
            db.doQuery("select password from ResponsabileReparto WHERE matricola ='" + matricola + "'");
            db.getResultSet().next();
            r = new ResponsabileReparto(
                    db.getResultSet().getString(1),
                    db.getResultSet().getString(2),
                    db.getResultSet().getString(3),
                    db.getResultSet().getString(4),
                    db.getResultSet().getDate(5),
                    db.getResultSet().getString(6),
                    db.getResultSet().getString(7),
                    db.getResultSet().getString(8),
                    db.getResultSet().getString(9),
                    db.getResultSet().getString(10),
                    db.getResultSet().getString(11));
            r.setIsLogged(true);

        }
        return r;
    }

    @Override
    public Autenticabile login(String username, String password) throws SQLException {
        ResponsabileReparto r = null;
        if (isRegistered(username) == true) {
            //controllo password 
            db.doQuery("select password from ResponsabileReparto WHERE matricola ='" + username + "'");
            db.getResultSet().next();
            String psw = db.getResultSet().getString(1);
            if (psw.equals(password)) {
                // fatch utente se la password è corretta
                db.doQuery("select * from ResponsabileReparto WHERE matricola ='" + username + "'");
                db.getResultSet().next();
                r = new ResponsabileReparto(
                        db.getResultSet().getString(1),
                        db.getResultSet().getString(2),
                        db.getResultSet().getString(3),
                        db.getResultSet().getString(4),
                        db.getResultSet().getDate(5),
                        db.getResultSet().getString(6),
                        db.getResultSet().getString(7),
                        db.getResultSet().getString(8),
                        db.getResultSet().getString(9),
                        db.getResultSet().getString(10),
                        db.getResultSet().getString(11));
                r.setIsLogged(true);
            }
        }
        return r;
    }

    @Override
    public void logout(Autenticabile autenticabile) {
        autenticabile.setIsLogged(false);
    }

    @Override
    public boolean isRegistered(String username) throws SQLException {
        db.doQuery("SELECT CASE WHEN EXISTS ( SELECT * FROM `ResponsabileReparto` WHERE `matricola` = '" + username + "' ) THEN 1 ELSE 0 END as retVal");
        ResultSet resSet = db.getResultSet();
        resSet.next();
        System.out.println("retval: " + resSet.getInt("retVal"));
        if (resSet.getInt("retVal") == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateResponsabileReparto(ResponsabileReparto responsabile) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autenticabile register(String username, String password) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
