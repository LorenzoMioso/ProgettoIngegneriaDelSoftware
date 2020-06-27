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
                    db.getResultSet().getBlob(4),
                    db.getResultSet().getString(5),
                    db.getResultSet().getString(6),
                    db.getResultSet().getBoolean(7),
                    db.getResultSet().getDouble(8),
                    db.getResultSet().getInt(9),
                    db.getResultSet().getDouble(10)));
        }
        return catalogo;
    }

    public List<Caratteristica> getCaratteristicaProdotto(int id) throws SQLException {
        List<Caratteristica> caratteristiche = new ArrayList<>();
        db.doQuery("select * from CaratteristicaProdotto where idProdotto = " + id);
        while (db.getResultSet().next()) {
            caratteristiche.add(new Caratteristica(
                    db.getResultSet().getString(2)));
        }
        return caratteristiche;
    }

    public List<Prodotto> getCaratteristicaProdotto(String caratterristica) throws SQLException {
        List<Prodotto> catalogo = new ArrayList<>();
        db.doQuery("SELECT *"
                + " FROM Prodotto P JOIN CaratteristicaProdotto CP"
                + " ON P.id = CP.idProdotto"
                + " WHERE P.inVendita = 1 AND CP.nomeCaratteristica = '" + caratterristica + "'");
        while (db.getResultSet().next()) {
            catalogo.add(new Prodotto(
                    db.getResultSet().getInt(1),
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
        return catalogo;
    }

    @Override
    public Prodotto getProdotto(int id) throws SQLException {
        Prodotto p;
        db.doQuery("select * from Prodotto where inVendita = 1 and id = " + id);
        db.getResultSet().next();
        p = new Prodotto(
                db.getResultSet().getInt(1),
                db.getResultSet().getString(2),
                db.getResultSet().getString(3),
                db.getResultSet().getBlob(4),
                db.getResultSet().getString(5),
                db.getResultSet().getString(6),
                db.getResultSet().getBoolean(7),
                db.getResultSet().getDouble(8),
                db.getResultSet().getInt(9),
                db.getResultSet().getDouble(10));
        return p;
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
