import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.ProdutoDao;
import modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Mesa","Mesa de jantar com 6 Lugares");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salvar(produto);
			List<Produto> listasDeProdutos = produtoDao.listar();
			listasDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}