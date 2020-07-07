/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author elisa
 */
public interface SpesaDao {
    
    public List<Spesa> getAllSpesaByUtente(Utente u) throws SQLException;

    public Spesa getSpesa(int id) throws SQLException;

    public void updateSpesa(Spesa spesa) throws SQLException;
    
    public void insertSpesa(Spesa spesa) throws SQLException;

   
}
