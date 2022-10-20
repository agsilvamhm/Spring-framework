package servlet;

import java.io.IOException;

import acao.AlteraEmpresa;
import acao.CriaEmpresa;
import acao.ListaEmpresa;
import acao.MostraEmpresa;
import acao.RemoveEmpresa;
import jakarta.servlet.RequestDispatcher;
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
		String nome = null;
		
		if (paramAcao.equals("ListarEmpresas")) {
			ListaEmpresa acao = new ListaEmpresa();
			nome = acao.executa(request, response);		
		} else if (paramAcao.equals("RemoverEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("MostrarEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);			
		}else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			acao.executa(request, response);
		}else if (paramAcao.equals("CriarEmpresa")) {
			CriaEmpresa acao = new CriaEmpresa();
			acao.executa(request, response);
		}
		
		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}		
}