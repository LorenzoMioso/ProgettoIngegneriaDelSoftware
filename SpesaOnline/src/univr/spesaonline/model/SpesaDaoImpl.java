/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.model;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elisa
 */
public class SpesaDaoImpl implements SpesaDao {

    private ConnectionDb db;

    public SpesaDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    @Override
    public List<Spesa> getAllSpesaByUtente(Utente u) throws SQLException {
        List<Spesa> spese = new ArrayList<>();
        db.doQuery("select * from Spesa where utente = '" + u.getEmail() + "'");

        int i = 0;
        while (db.getResultSet().next()) {
            Map<Prodotto, Integer> spesa = new HashMap<>();
            spese.add(new Spesa(
                    db.getResultSet().getInt(1),
                    db.getResultSet().getTimestamp(2),
                    db.getResultSet().getDate(3),
                    db.getResultSet().getTime(4),
                    db.getResultSet().getTime(5),
                    db.getResultSet().getDouble(6),
                    db.getResultSet().getInt(7),
                    db.getResultSet().getString(8),
                    u,
                    db.getResultSet().getString(10), spesa));
        }
        for (Spesa s : spese) {
            Map<Prodotto, Integer> spesa = new HashMap<>();
            //devo avere l'id della spesa per fare la query all'interno di prodottoComprato
            db.doQuery("select * from ProdottoComprato PC JOIN Prodotto P ON PC.idProdotto = P.id where PC.idSpesa = '" + s.getId() + "'");
            while (db.getResultSet().next()) {
                spesa.put(new Prodotto(db.getResultSet().getInt(4),
                        db.getResultSet().getString(5),
                        db.getResultSet().getString(6),
                        db.getResultSet().getBlob(7),
                        db.getResultSet().getString(8),
                        db.getResultSet().getString(9),
                        db.getResultSet().getBoolean(10),
                        db.getResultSet().getDouble(11),
                        db.getResultSet().getInt(12),
                        db.getResultSet().getDouble(13)), db.getResultSet().getInt(3));
            }
            s.setProdotti(spesa);
            for (Map.Entry<Prodotto, Integer> entry : spesa.entrySet()) {
                System.out.println("Prodotto " + entry.getKey() + " Quantità: " + entry.getValue());
            }
        }
        return spese;
    }

    @Override
    public Spesa getSpesa(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSpesa(Spesa spesa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertSpesa(Spesa spesa) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dataConsegna = formatter.format(addDays(java.util.Calendar.getInstance().getTime(), 1));
        System.out.println("" + dataConsegna);
        int id = db.doSpecificQuery("INSERT INTO `Spesa` (`id`, `dataOrdine`, `dataConsegna`,`oraInizio`, `oraFine`, `costoTot`, `saldoPunti`, `pagamento`,`utente`, `stato`) VALUES "
                + "(NULL, NULL ,'" + dataConsegna + "', '9:00:00', '18:00:00', '" + spesa.getCostoTot() + "', '" + spesa.getSaldoPunti() + "', '" + spesa.getUtente().getPagamentoPreferito() + "', '" + spesa.getUtente().getEmail() + "', 'In preparazione')");

        System.out.println("Id :" + id);
        spesa.setId(id);

        for (Map.Entry<Prodotto, Integer> entry : spesa.getProdotti().entrySet()) {
            db.doQuery("INSERT INTO `ProdottoComprato` (`idSpesa`, `idProdotto`, `quantitàProdotto`) VALUES "
                    + "('" + spesa.getId() + "', '" + entry.getKey().getId() + "' , '" + entry.getValue() + "')");
        }
        
        db.doQuery("UPDATE `TesseraFedelta` SET punti = punti + '" + spesa.getSaldoPunti() + "' WHERE utente = '" + spesa.getUtente().getEmail() + "'");

    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return (Date) cal.getTime();
    }

}
