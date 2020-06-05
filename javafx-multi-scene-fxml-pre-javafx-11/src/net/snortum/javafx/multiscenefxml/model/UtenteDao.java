package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;

public interface UtenteDao {

    public void updateUtente(Utente utente) throws SQLException;

}
