package univr.spesaonline.model;

import java.sql.SQLException;

public interface UtenteDao {

    public void updateUtente(Utente utente) throws SQLException;
    public Utente getUtente(String email) throws SQLException;
}
