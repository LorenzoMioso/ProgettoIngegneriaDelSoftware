
package model;

import java.sql.SQLException;

public interface AutenticabileDao {

    public Autenticabile login(String username, String password) throws SQLException;

    public void logout(Autenticabile autenticabile);

    public Autenticabile register(String username, String password) throws SQLException;

    public boolean isRegistered(String username) throws SQLException;
}
