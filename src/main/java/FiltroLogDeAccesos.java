import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "FiltroLogDeAccesos",
		urlPatterns = {"/*"},
		initParams = @WebInitParam(name = "filename", value = "logs.txt"))
public class FiltroLogDeAccesos implements Filter {


	private static final Logger logger = Logger.getLogger(FiltroLogDeAccesos.class.getName());

	@Override
	public void init(FilterConfig filterConfig) {
		try {
			String filename = filterConfig.getInitParameter("filename");
			FileHandler fileHandler = new FileHandler("%h" + "/" + filename);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormatter);
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(false);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		String remoteHost = request.getRemoteHost();
		LocalDateTime localDateTime = LocalDateTime.now();
		String method = request.getMethod();
		String requestURI = request.getRequestURI();
		String protocol = request.getProtocol();
		String userAgent = request.getHeader("User-Agent");
		String commonLogFormat = String.format("%s %s %s %s %s %s", remoteHost, localDateTime, method, requestURI, protocol, userAgent);
		logger.log(Level.INFO, commonLogFormat);

		filterChain.doFilter(servletRequest, servletResponse);

	}

}
