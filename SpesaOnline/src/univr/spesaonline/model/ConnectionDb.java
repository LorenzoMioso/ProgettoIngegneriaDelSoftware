package univr.spesaonline.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {   //ConnectionDb utilizza il pattern singleton

    private static ConnectionDb instance = new ConnectionDb();
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "Spesa";
    private String username = "spesa";
    private String password = "spesa";
    private String multipleQueries = "?allowMultiQueries=true";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private ConnectionDb() {
    }

    public static ConnectionDb getInstance() {
        return instance;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname, username, password);
        this.pstmt = connection.prepareStatement(query);
        return pstmt;
    }

    public void doQuery(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname + multipleQueries, username, password);
        this.statement = connection.createStatement();
        this.resultSet = statement.executeQuery(query);
        connection.close();
    }

    public int doSpecificQuery(String query) throws SQLException {
        this.connection = DriverManager.getConnection(url + dbname + multipleQueries, username, password);
        this.statement = connection.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,
                java.sql.ResultSet.CONCUR_UPDATABLE);
        this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        int id = -1;
        this.resultSet = this.statement.getGeneratedKeys();
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
