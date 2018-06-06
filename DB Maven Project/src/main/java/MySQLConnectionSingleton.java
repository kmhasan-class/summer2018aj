import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionSingleton {
    private static MySQLConnectionSingleton ourInstance = new MySQLConnectionSingleton();
    private static Connection connection = null;

    public static MySQLConnectionSingleton getInstance() {
        return ourInstance;
    }


    private MySQLConnectionSingleton() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://172.17.10.2/productdb?useSSL=false",
                    "summer2018aj", "aj");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
