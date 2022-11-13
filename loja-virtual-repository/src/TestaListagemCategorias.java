import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDao;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
	    
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> listaDeCategorias = categoriaDao.listarComProdutos(); 	
			listaDeCategorias.stream().forEach(ct -> {
				
				System.out.println(ct.getNome());
		
				for(Produto produto: ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
		
			 	}
			});	
		}
	}
}