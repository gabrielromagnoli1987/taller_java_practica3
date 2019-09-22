package movies;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cupondescuento2")
public class CuponDescuentoServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DatosCupon datosCupon = (DatosCupon) getServletContext().getAttribute("datosCupon");
		HttpSession session = req.getSession();
		DatosCupon datosCupon = (DatosCupon) session.getAttribute("datosCupon");
		String name = datosCupon.getName();
		String lastname = datosCupon.getLastname();
		String dni = datosCupon.getDni();
		String email = datosCupon.getEmail();
		String sala = datosCupon.getSala();
		LocalDate fecha = datosCupon.getFecha();

		String relativeWebPath = "/images/interstellar.jpg";
		InputStream input = getServletContext().getResourceAsStream(relativeWebPath);

		BufferedImage image = ImageIO.read(input);
		Graphics2D graphics = image.createGraphics();
		int width = image.getWidth();
		int height = image.getHeight();
		int xPosition = (int)(width * 0.2);
		int titleYPosition = (int) (height * 0.1);
		graphics.setFont(graphics.getFont().deriveFont(70f));
		graphics.drawString("Cupon de descuento valido", xPosition, titleYPosition);
		graphics.drawString("para el dia " + fecha.toString(), xPosition, (int) (height * 0.2));
		graphics.drawString(sala, xPosition, (int)(height * 0.55));
		graphics.drawString(name +" "+ lastname, xPosition, (int)(height * 0.6));
		graphics.drawString(dni, xPosition, (int)(height * 0.65));
		graphics.drawString(email, xPosition, (int)(height * 0.7));
		resp.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", resp.getOutputStream());

	}
}
