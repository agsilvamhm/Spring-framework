package acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Banco;
import modelo.Empresa;

public class AlteraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		Date dataAbertEmpresa = null;
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 dataAbertEmpresa = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresa(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertEmpresa);
		
		response.sendRedirect("entrada?acao=ListarEmpresas");
	}

}
