
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {

    private static  ConnectionDb instance = new ConnectionDb();
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "Spesa";
    private String username = "spesa";
    private String password = "spesa";
    
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    public ConnectionDb(){
        
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

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname, username, password);
        this.pstmt = connection.prepareStatement(query);
        return pstmt;
    }
    

}
