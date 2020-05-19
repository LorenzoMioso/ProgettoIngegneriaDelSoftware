
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {

    private static ConnectionDb instance = new ConnectionDb();
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "Spesa";
    private String username = "root";
    //private String password = "astuci0";
    private String password = "lore";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    ConnectionDb() {
    }
        
    public static ConnectionDb getInstance() {
        return instance;
    }

    public void doQuery(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname, username, password);
        this.statement = connection.createStatement();
        this.resultSet = statement.executeQuery(query);
        connection.close();
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

}
