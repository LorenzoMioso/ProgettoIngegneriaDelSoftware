package model;

import java.sql.SQLException;
import java.util.List;

public interface ProdottoDao {

    public List<Prodotto> getAllProdotto() throws SQLException;

    public Prodotto getProdotto(int id) throws SQLException;

    public void updateProdotto(Prodotto prodotto) throws SQLException;

    public void createProdotto() throws SQLException;

    public void insertProdotto(Prodotto prodotto) throws SQLException;

    public void fillTableProdotto() throws SQLException;

}
