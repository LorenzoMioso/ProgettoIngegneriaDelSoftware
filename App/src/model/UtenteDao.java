/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author elisa
 */
public interface UtenteDao {
    

    public Utente getUtente(int id) throws SQLException;

    public void updateUtente(Utente utente) throws SQLException;

    public void createUtente() throws SQLException;

    public void insertUtente(Utente utente) throws SQLException;

    public void fillTableUtente() throws SQLException;

}
