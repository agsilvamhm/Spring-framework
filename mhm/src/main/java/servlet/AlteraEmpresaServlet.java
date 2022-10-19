package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	}

}
