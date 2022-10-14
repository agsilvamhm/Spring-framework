package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class NovaEmpresa
 * 
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		System.out.println("Cadastrando uma nova empresa");
		PrintWriter out = response.getWriter();
		out.println("<Html>");
		out.println("<body>");
		out.println("<h1>Empresa " + nomeEmpresa + " cadastrada com sucesso!</h1>" );
		out.println("</body>");
		out.println("</Html>");
	}
}