package acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Banco;
import modelo.Empresa;

public class MostraEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		String paramId = request.getParameter("id");
		Integer id= Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.getEmpresa(id);
			
		request.setAttribute("empresa", empresa);
		
		return "forward:/formAlteraEmpresa.jsp";
	}
}