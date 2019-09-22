package movies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/datosPersona")
public class DatosPersonaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String lastname = req.getParameter("lastname");
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");

		DatosCupon datosCupon = new DatosCupon(name, lastname, dni, email);
		HttpSession session = req.getSession();
		session.setAttribute("datosCupon", datosCupon);
		//getServletContext().setAttribute("datosCupon", datosCupon);

		resp.sendRedirect("formularioFechaSala.html");
	}

}
