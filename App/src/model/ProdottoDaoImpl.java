package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDaoImpl extends ConnectionDb implements ProdottoDao {

    @Override
    public List<Prodotto> getAllProdotto() throws SQLException {
        List<Prodotto> catalogo = new ArrayList<Prodotto>();
        super.doQuery("select * from Prodotto");
        while (resultSet.next()) {
            catalogo.add(new Prodotto(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)));
        }
        return catalogo;
    }

    @Override
    public Prodotto getProdotto(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProdotto(Prodotto prodotto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createProdotto() throws SQLException {
        doQuery("CREATE TABLE `Prodotto` (\n"
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
        doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, '" + prodotto.getNome() + "', '" + prodotto.getMarca() + "', '" + prodotto.getReparto() + "', '" + prodotto.getQuantità() + "', '" + prodotto.getPrezzo() + "'),");
    }

    @Override
    public void fillTableProdotto() throws SQLException {
        doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '30', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '100', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '30', '2');");
    }

}
