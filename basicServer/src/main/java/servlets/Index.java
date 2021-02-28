package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;


public class Index extends HttpServlet {
    public static final Logger logger = Log.getLogger(Index.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info(
                String.format(
                        "%s.%s called",
                        Index.class.getName(),
                        Thread.currentThread().getStackTrace()[1].getMethodName()
                )
        );
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("index");
    }
}
