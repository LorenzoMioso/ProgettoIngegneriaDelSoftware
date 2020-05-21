
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DropCreateDb {

    private String url = "jdbc:mysql://localhost:3306/";
    private String username = "root";
    private String password = "astuci0";
    //private String password = "lore";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    DropCreateDb() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        this.statement = connection.createStatement();
        String query = "DROP DATABASE Spesa";
        this.resultSet = statement.executeQuery(query);
        query = "CREATE DATABASE Spesa";
        this.resultSet = statement.executeQuery(query);
        connection.close();
    }
}
