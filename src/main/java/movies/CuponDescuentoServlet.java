package movies;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cupondescuento")
public class CuponDescuentoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String lastname = req.getParameter("lastname");
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");

		String relativeWebPath = "/images/interstellar.jpg";
		InputStream input = getServletContext().getResourceAsStream(relativeWebPath);

		BufferedImage image = ImageIO.read(input);
		Graphics2D graphics = image.createGraphics();
		int width = image.getWidth();
		int height = image.getHeight();
		int xPosition = (int)(width * 0.2);
		int titleYPosition = (int) (height * 0.1);
		graphics.setFont(graphics.getFont().deriveFont(70f));
		graphics.drawString("Cupon de descuento", xPosition, titleYPosition);
		graphics.drawString(name +" "+ lastname, xPosition, (int)(height * 0.6));
		graphics.drawString(dni, xPosition, (int)(height * 0.65));
		graphics.drawString(email, xPosition, (int)(height * 0.7));
		resp.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", resp.getOutputStream());

	}
}
