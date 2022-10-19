package servlet;

import java.io.IOException;

import acao.ListaEmpresas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if (paramAcao.equals("ListarEmpresas")) {
			System.out.println("Listando empresas ");
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("RemoverEmpresas")) {
			System.out.println("Removendo empresa");
		} else if (paramAcao.equals("MostrarEmpresa")) {
			System.out.println("Mostrando dados da empresa");
		}
	}
}