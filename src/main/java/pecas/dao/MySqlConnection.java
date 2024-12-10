package pecas.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public Connection getConnection() {
        try {
            // Registra o driver JDBC
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pecas", "root", "123mudar");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dadeeos: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
