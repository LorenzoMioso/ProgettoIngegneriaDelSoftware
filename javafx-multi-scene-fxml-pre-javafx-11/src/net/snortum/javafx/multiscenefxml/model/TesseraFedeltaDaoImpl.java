package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;

public class TesseraFedeltaDaoImpl {

    private ConnectionDb db;

    public TesseraFedeltaDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    public TesseraFedelta getTesseraFedelta(int id) throws SQLException {
        TesseraFedelta tesseraFedelta;
        db.doQuery("select * from TesseraFedelta WHERE id = '" + id + "'");

        UtenteDaoImpl utentedaoImpl = new UtenteDaoImpl();
        db.getResultSet().next();
        Utente utente = utentedaoImpl.getUtente(db.getResultSet().getString(4));
        tesseraFedelta = new TesseraFedelta(
                db.getResultSet().getInt(1),
                db.getResultSet().getDate(2),
                db.getResultSet().getInt(3),
                utente);
        return tesseraFedelta;
    }

    public TesseraFedelta getTesseraFromUser(Utente u) throws SQLException {
        db.doQuery("select * from TesseraFedelta where utente = '" + u.getEmail() + "'");
        db.getResultSet().next();
        TesseraFedelta tesseraFedelta = new TesseraFedelta(
                db.getResultSet().getInt(1),
                db.getResultSet().getDate(2),
                db.getResultSet().getInt(3),
                u);
        return tesseraFedelta;
    }

    public void deleteTesseraFedelta(TesseraFedelta tesseraFedelta) throws SQLException {
        db.doQuery("DELETE FROM `TesseraFedelta` WHERE id = '" + tesseraFedelta.getId() + "'");
    }

    public void insertTesseraFedelta(TesseraFedelta tesseraFedelta) throws SQLException {
        db.doQuery("INSERT INTO `TesseraFedelta` (`id`, `dataEmissione`, `punti`) VALUES "
                + "(NULL, '" + tesseraFedelta.getDataEmissione() + "', '" + tesseraFedelta.getPunti() + "'),");

    }
}
