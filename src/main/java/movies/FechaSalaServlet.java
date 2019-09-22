package movies;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fechasala")
public class FechaSalaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("date");
		String sala = req.getParameter("sala");
		LocalDate date = LocalDate.parse(fecha);
		// DatosCupon datosCupon = (DatosCupon) getServletContext().getAttribute("datosCupon");
		HttpSession session = req.getSession();
		DatosCupon datosCupon = (DatosCupon) session.getAttribute("datosCupon");
		datosCupon.setFecha(date);
		datosCupon.setSala(sala);
		// getServletContext().setAttribute("datosCupon", datosCupon);
		session.setAttribute("datosCupon", datosCupon);
		getServletContext().getRequestDispatcher("/cupondescuento2").forward(req, resp);
	}
}
