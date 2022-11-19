package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Categoria celulares = new Categoria("Celulares");
		Produto celular = new Produto("Xiaomi","Muit legal",new BigDecimal("800"), celulares );
	
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);	
		System.out.println(produtoDao.buscarPorId(1l));
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p2.getNome()));
	
		List<Produto> todos2 = produtoDao.buscarPorNome("Xiaomi");
		todos2.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> todos3 = produtoDao.buscarPorNomeDaCategoria("Celulares");
		todos3.forEach(p2 -> System.out.println(p2.getNome()));
		
		em.getTransaction().commit();
		em.close();
	}

}
