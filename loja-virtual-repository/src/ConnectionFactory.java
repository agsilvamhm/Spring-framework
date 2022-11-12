import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		String url = "jdbc:postgresql://localhost:5432/loja_virtual";
		String user = "postgres";
		String password = "Ana926";
		ComboPooledDataSource comboPolleDataSource = new ComboPooledDataSource();
		comboPolleDataSource.setJdbcUrl(url);
		comboPolleDataSource.setUser(user);
		comboPolleDataSource.setPassword(password);
		
		comboPolleDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPolleDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		//String url = "jdbc:postgresql://localhost:5432/loja_virtual";
		//String user = "postgres";
	    //String password = "Ana926";
		
	    return dataSource.getConnection(); //DriverManager.getConnection(url, user, password);     
	}
}