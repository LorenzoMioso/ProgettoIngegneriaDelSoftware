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
public interface ResponsabileRepartoDao {
    

    public ResponsabileReparto getResponsabileReparto(int id) throws SQLException;

    public void updateResponsabileReparto(ResponsabileReparto responsabile) throws SQLException;

    public void createResponsabileReparto() throws SQLException;

    public void insertResponsabileReparto(ResponsabileReparto responsabile) throws SQLException;

    public void fillTableResponsabileReparto() throws SQLException;

}
