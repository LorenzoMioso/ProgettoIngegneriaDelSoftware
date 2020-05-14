package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDaoImpl implements ProdottoDao {

    private ConnectionDb db;
    
    public ProdottoDaoImpl(){
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
                    db.getResultSet().getString(4),
                    db.getResultSet().getInt(5),
                    db.getResultSet().getInt(6)));
        }
        return catalogo;
    }

    @Override
    public Prodotto getProdotto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProdotto(Prodotto prodotto) throws SQLException {
       db.doQuery("UPDATE `Prodotto` SET `nome`=["+ prodotto.getNome() +"],`marca`=["+ prodotto.getMarca() +"],`prezzo`=["+ prodotto.getPrezzo() +"] WHERE id ='"+ prodotto.getId() +"'");
    }

    @Override
    public void createProdotto() throws SQLException {
        db.doQuery("CREATE TABLE `Prodotto` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` text NOT NULL,\n"
                + "  `marca` text NOT NULL,\n"
                + "  `reparto` text NOT NULL,\n"
                + "  `quantità` int(11) NOT NULL,\n"
                + "  `prezzo` int(11) NOT NULL,\n"
                + "  UNIQUE KEY `id` (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1	");
    }
    

    @Override
    public void insertProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, '" + prodotto.getNome() + "', '" + prodotto.getMarca() + "', '" + prodotto.getReparto() + "', '" + prodotto.getQuantità() + "', '" + prodotto.getPrezzo() + "'),");
    }
    
    @Override
    public void fillTableProdotto() throws SQLException {
        db.doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '30', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '100', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '30', '2');");
    }


    @Override
    public void deleteProdotto(Prodotto prodotto) throws SQLException {
        db.doQuery("DELETE FROM `Prodotto` WHERE id = '" + prodotto.getId() +"'");
    }

}
