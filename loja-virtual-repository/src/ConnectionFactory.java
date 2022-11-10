import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/loja_virtual";
		String user = "postgres";
		String password = "Ana926";
		
	    return DriverManager.getConnection(url, user, password);
	     
	}

}
