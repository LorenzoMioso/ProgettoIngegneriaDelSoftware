package model;

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
        db.doQuery("select * from Prodotto");
        while (db.getResultSet().next()) {
            catalogo.add(new Prodotto(
                    db.getResultSet().getInt(1),
                    db.getResultSet().getString(2),
                    db.getResultSet().getString(3),
                    db.getResultSet().getBlob(4),
                    db.getResultSet().getString(5),
                    db.getResultSet().getBoolean(6),
                    db.getResultSet().getDouble(7),
                    db.getResultSet().getInt(8),
                    db.getResultSet().getDouble(9)));
        }
        return catalogo;
    }

    @Override
    public Prodotto getProdotto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("UPDATE `Prodotto` SET `nome`=[" + prodotto.getNome() + "],`marca`=[" + prodotto.getMarca() + "],"
                + "`inVendita`=[" + prodotto.getInVendita() + "],`peso`=[" + prodotto.getPeso() + "], `nPezzi`=[" + prodotto.getnPezzi() + "],`prezzo`=[" + prodotto.getPrezzo() + "] WHERE id ='" + prodotto.getId() + "'");
    }

    @Override
    public void insertProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `inVendita`, `peso`,`nPezzi`,`prezzo`) VALUES "
                + "(NULL, '" + prodotto.getNome() + "', '" + prodotto.getMarca() + "', '" + prodotto.getReparto() + "', '" + prodotto.getInVendita()
                + "', '" + prodotto.getPeso() + "', '" + prodotto.getnPezzi() + "', '" + prodotto.getPrezzo() + "'),");
    }

    @Override
    public void deleteProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("DELETE FROM `Prodotto` WHERE id = '" + prodotto.getId() + "'");
    }

}
