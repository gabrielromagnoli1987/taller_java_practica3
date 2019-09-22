import java.io.IOException;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "FiltroLenguajeCliente", urlPatterns = {"/*"})
public class FiltroLenguajeCliente implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String header = request.getHeader("accept-language"); //en-US,en;q=0.9,es;q=0.8
		Locale locale = Locale.forLanguageTag(header.split(",")[0]);

		servletRequest.setAttribute("textos", "textos");
		servletRequest.setAttribute("locale", locale);

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Content-Language", locale.toString());

		filterChain.doFilter(servletRequest, response);
	}

	@Override
	public void destroy() {

	}
}
