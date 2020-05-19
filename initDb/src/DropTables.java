
import java.sql.SQLException;

public class DropTables {

    private ConnectionDb db;

    public DropTables() throws SQLException {
        db = ConnectionDb.getInstance();
        //db.doQuery("DROP DATABASE Spesa;");
        db.doQuery("CREATE DATABASE Spesa;");
    }
}
