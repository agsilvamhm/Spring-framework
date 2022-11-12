import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
	     PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
	     stm.setInt(1, 5);
	     stm.execute();
	     
	     Integer linhaModificadas = stm.getUpdateCount();
	     
	     System.out.println("Quntidade de linhas que foram modificadas: " +  linhaModificadas);
	}
}