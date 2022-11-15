package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoriaDao;
import factory.ConnectionFactory;
import modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDao  categoriaDao;
	
	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDao =  new CategoriaDao(connection);
	}
	
	public List<Categoria> listar() {
		return this.categoriaDao.listar();
	}
}
