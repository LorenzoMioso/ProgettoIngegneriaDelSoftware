package model;

import java.sql.SQLException;

public interface UtenteDao{

    public Utente getUtente(int id) throws SQLException;

    public void updateUtente(Utente utente) throws SQLException;

    public void insertUtente(Utente utente) throws SQLException;

}
