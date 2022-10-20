package acao;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Banco;
import modelo.Empresa;

public class ListaEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();	
		request.setAttribute("empresas", lista);
		return "forward:listaEmpresas.jsp";
	}
}