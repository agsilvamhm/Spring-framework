import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		
		try(Connection connection = factory.recuperarConexao()){
			connection.setAutoCommit(false);
			
			try(PreparedStatement stm = connection.prepareStatement("INSERT INTO PUBLIC.PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
				) {
				adicionarVariavel("SmartTv", "TV Philips de 65 Polegadas", stm);
				adicionarVariavel("SmartPhone", "SmartPhone Moto G Plus", stm);
				connection.commit();

			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Rollback executado!");
				connection.rollback();
			}
		}
	}	
		
		private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.execute();
			ResultSet rst = stm.getGeneratedKeys();
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi o :" + id);
			}		
		}

}