package net.snortum.javafx.multiscenefxml.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDaoImpl implements ProdottoDao {

    private ConnectionDb db;

    public ProdottoDaoImpl() {
        db = ConnectionDb.getInstance();
    }

    @Override
    public List<Prodotto> getAllProdotto() throws SQLException {
        List<Prodotto> catalogo = new ArrayList<>();
        db.doQuery("select * from Prodotto where inVendita = 1");
        while (db.getResultSet().next()) {
            catalogo.add(new Prodotto(
                    db.getResultSet().getInt(1),
                    db.getResultSet().getString(2),
                    db.getResultSet().getString(3),
                    db.getResultSet().getString(4),
                    db.getResultSet().getString(5),
                    db.getResultSet().getBlob(6),
                    db.getResultSet().getBoolean(7),
                    db.getResultSet().getDouble(8),
                    db.getResultSet().getInt(9),
                    db.getResultSet().getDouble(10)));
        }
        return catalogo;
    }

    @Override
    public Prodotto getProdotto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//TODO modificare
    @Override
    public void updateProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("UPDATE `Prodotto` SET `nome`=[" + prodotto.getNome() + "],`marca`=[" + prodotto.getMarca() + "],"
                + "`inVendita`=[" + prodotto.isInVendita() + "],`peso`=[" + prodotto.getPeso() + "], `nPezzi`=[" + prodotto.getnPezzi() + "],`prezzo`=[" + prodotto.getPrezzo() + "] WHERE id ='" + prodotto.getId() + "'");
    }
//TODO modificare
    @Override
    public void insertProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`,`prezzo`) VALUES "
                + "(NULL, '" + prodotto.getNome() + "', '" + prodotto.getMarca() + "', '" + prodotto.getReparto() + "', '" + prodotto.isInVendita()
                + "', '" + prodotto.getPeso() + "', '" + prodotto.getnPezzi() + "', '" + prodotto.getPrezzo() + "'),");
    }

    @Override
    public void deleteProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("DELETE FROM `Prodotto` WHERE id = '" + prodotto.getId() + "'");
    }

}
