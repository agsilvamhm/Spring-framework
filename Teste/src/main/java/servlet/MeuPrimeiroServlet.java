package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/oi")
public class MeuPrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
        out.println("<h1>Hello World!, meu primeiro servelet.</h1>"); 
		out.println("</body>");
		out.println("</html>");	
	}


}
