package servlet;

import java.io.IOException;

import acao.Acao;
import acao.AlteraEmpresa;
import acao.CriarEmpresa;
import acao.ListarEmpresas;
import acao.MostrarEmpresa;
import acao.NovaEmpresaForm;
import acao.RemoverEmpresa;
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
		String nome;
		
		try {
			String nomeDaClasse = "acao." + paramAcao;
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	
		////
//		if (paramAcao.equals("ListarEmpresas")) {
//			ListaEmpresa acao = new ListaEmpresa();
//			nome = acao.executa(request, response);		
//		} else if (paramAcao.equals("RemoverEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("MostrarEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);			
//		}else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("CriarEmpresa")) {
//			CriaEmpresa acao = new CriaEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
	}		
}