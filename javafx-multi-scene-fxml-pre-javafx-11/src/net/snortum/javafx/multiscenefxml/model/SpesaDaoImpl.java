/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elisa
 */
public class SpesaDaoImpl implements SpesaDao{
     private ConnectionDb db;

    public SpesaDaoImpl() {
        db = ConnectionDb.getInstance();
    }
    
    @Override
    public List<Spesa> getAllSpesaByUtente(Utente u) throws SQLException {
        List<Spesa> spese = new ArrayList<>();
        db.doQuery("select * from Spesa where utente = '"+ u.getEmail() + "'");
       
        int i = 0 ;
        while (db.getResultSet().next()) {
            List <Prodotto> spesa = new ArrayList <>();
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
            //devo avere l'id della spesa per fare la query all'interno di prodottoComprato
            db.doQuery("select * from ProdottoComprato where idSpesa = '" + spese.get(i).getId() +"'");
            while(db.getResultSet().next()){
                spesa.add(new Prodotto(db.getResultSet().getInt(1),
                    db.getResultSet().getString(2),
                    db.getResultSet().getString(3),
                    db.getResultSet().getBlob(4),
                    db.getResultSet().getString(5),
                    db.getResultSet().getString(6),
                    db.getResultSet().getBoolean(7),
                    db.getResultSet().getDouble(8),
                    db.getResultSet().getInt(9),
                    db.getResultSet().getDouble(10)));
            
            
            }
            spese.get(i).setProdotti(spesa);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
