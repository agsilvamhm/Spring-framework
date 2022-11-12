import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
	     PreparedStatement stm = connection.prepareStatement("Select id, nome, descricao from public.produto order by id");
	     stm.execute();
	     ResultSet rst = stm.getResultSet();

	     while (rst.next()){
	    	 System.out.print(rst.getInt("ID"));
	    	 System.out.print(" - ");
	    	 System.out.print(rst.getString("NOME"));
	    	 System.out.print(" - ");
	    	 System.out.print(rst.getString("DESCRICAO"));
	    	 System.out.println("");
	     }
	     
	     connection.close();
	}

}
