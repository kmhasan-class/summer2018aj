import java.sql.Connection;

public class Hello {
    public static void main(String args[]) {
        System.out.println("Hello World");

        Connection connection = MySQLConnectionSingleton.getConnection();
        System.out.println("Connected");
    }
}
