package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetcher {

    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "Spesa";
    private String username = "root";
    private String password = "lore";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Fetcher() {
    }

    private void doQuery(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname, username, password);
        this.statement = connection.createStatement();
        this.resultSet = statement.executeQuery(query);
        connection.close();
    }

    public Catalogo fetchProdotti() throws SQLException {
        doQuery("select * from Prodotto");
        Catalogo catalogo = new Catalogo();
        while (resultSet.next()) {
            catalogo.addProdotto(new Prodotto(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)));
        }
        return catalogo;
    }

    public void createProdotti() throws SQLException {
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
    public void insertProdotti() throws SQLException {
        doQuery("INSERT INTO `Prodotto` (`id`, `nome`, `marca`, `reparto`, `quantità`, `prezzo`) VALUES "
                + "(NULL, 'carota', 'sela', 'verdura', '30', '2'),"
                + "(NULL, 'insalata', 'sela', 'verdura', '100', '2'),"
                + "(NULL, 'cipolla', 'sela', 'verdura', '30', '2');"); 
    }
    
}
