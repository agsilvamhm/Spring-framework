package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Banco;
import modelo.Empresa;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Empresa> empresas = new Banco().getEmpresas();
			
			String valor = request.getHeader("Accept");
			
			if(valor.endsWith("xml")) {
				XStream xtream = new XStream();
				String xml = xtream.toXML(empresas);		
				response.setContentType("application/xml");
				response.getWriter().print(xml);		
			} else if(valor.endsWith("json")) {
				Gson gson = new Gson();
				String json = gson.toJson(empresas);		
				response.setContentType("application/json");
				response.getWriter().print(json);	
			} else {
				response.setContentType("application/json");
				response.getWriter().print("{'message':'no content'}");	
			}
	}
}