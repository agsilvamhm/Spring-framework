package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long Id) {
		return em.find(Produto.class, 1l);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "Select p from Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();	
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "Select p from Produto p where p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();	
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nome){
		String jpql = "Select p from Produto p where p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();	
	}
	
	public BigDecimal buscarPrecoDoProduto(String nome){
		String jpql = "Select p.preco from Produto p where p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();	
	}

}