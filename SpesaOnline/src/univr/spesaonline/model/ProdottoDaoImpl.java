package univr.spesaonline.model;

import java.sql.PreparedStatement;
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
            Prodotto p = new Prodotto(
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
            catalogo.add(p);

        }
        return catalogo;
    }

    public List<Caratteristica> getCaratteristicaByProdotto(int id) throws SQLException {
        List<Caratteristica> caratteristiche = new ArrayList<>();
        db.doQuery("select * from CaratteristicaProdotto where idProdotto = " + id);
        while (db.getResultSet().next()) {
            caratteristiche.add(new Caratteristica(
                    db.getResultSet().getString(2)));
        }
        return caratteristiche;
    }

    public List<Prodotto> getProdottoByCaratteristica(String caratterristica) throws SQLException {
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

    public int getDisponibilitàProdotto(int id) throws SQLException {
        db.doQuery("select disponibilita from Magazzino where idProdotto = " + id);
        db.getResultSet().next();
        return db.getResultSet().getInt(1);
    }

    public void updateDisponibilitàProdotto(int id, int disponobilità) throws SQLException {
        db.doQuery("UPDATE `Magazzino` SET "
                + "`disponibilita`='" + disponobilità + "'"
                + " WHERE idProdotto ='" + id + "'");
    }

    @Override
    public void updateProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("UPDATE `Prodotto` SET "
                + "`nome`='" + prodotto.getNome() + "',"
                + "`marca`='" + prodotto.getMarca() + "',"
                + "`tipo`='" + prodotto.getTipo() + "',"
                + "`reparto`='" + prodotto.getReparto() + "',"
                + "`inVendita`='" + (prodotto.isInVendita() ? 1 : 0) + "',"
                + "`peso`='" + prodotto.getPeso() + "',"
                + "`nPezzi`='" + prodotto.getnPezzi() + "',"
                + "`prezzo`='" + prodotto.getPrezzo() + "'"
                + " WHERE id ='" + prodotto.getId() + "'");

        String query = String.format("UPDATE Prodotto set immagine = ? WHERE id = %d", prodotto.getId());
        PreparedStatement pstmt = db.getPreparedStatement(query);
        pstmt.setBlob(1, prodotto.getImmagine());
        pstmt.executeUpdate();

        for (Caratteristica c : prodotto.getCarattristiche()) {
            db.doQuery("INSERT INTO CaratteristicaProdotto (idProdotto, nomeCaratteristica) "
                    + "VALUES('" + prodotto.getId() + "','" + c.getNome() + "') "
                    + "ON DUPLICATE KEY UPDATE    \n"
                    + "idProdotto='" + prodotto.getId() + "', nomeCaratteristica='" + c.getNome() + "'");
        }

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
