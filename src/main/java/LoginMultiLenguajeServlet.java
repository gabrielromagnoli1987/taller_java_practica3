import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginMultiLenguajeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String textos = (String) req.getAttribute("textos");
		Locale locale = (Locale) req.getAttribute("locale");
		ResourceBundle labels = ResourceBundle.getBundle(textos, locale);
		String title = labels.getString("title");
		String labelUser = labels.getString("label_user");
		String labelPassword = labels.getString("label_password");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>"+title+" - Login</h1>");
		out.println("<div><form action=\"/hello\" method=\"post\">");
		out.println("<label for=\"username\">"+labelUser+"</label>");
		out.println("<input type=\"text\" name=\"username\" required>");
		out.println("<label for=\"pass\">"+labelPassword+"</label>");
		out.println("<input type=\"password\" name=\"pass\" required>");
		out.println("<button type=\"submit\">Login</button>");
		out.println("</form></div>");
		out.println("</body></html>");
		out.close();

	}

}
