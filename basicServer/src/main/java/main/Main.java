package main;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import servlets.*;
import servlets.servers.*;


public class Main {
    private static final Logger logger = Log.getRootLogger();
    public static void main(String[] args) throws Exception {
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ServletContextHandler ctxWithHandlers = registerHandlers(ctx);
        startServer(ctxWithHandlers);
    }
    private static ServletContextHandler registerHandlers(ServletContextHandler ctx) {
        logger.info("registering handlers...");
        ctx.addServlet(new ServletHolder(new Contact()), "/contacts");
        ctx.addServlet(new ServletHolder(new Index()),   "/index");
        ctx.addServlet(new ServletHolder(new Login()),   "/login");
        ctx.addServlet(new ServletHolder(new VM()),      "/servers");
        return ctx;
    }
    private static void startServer(ServletContextHandler ctxWithHandlers) throws Exception {
        int port = 8080;
        logger.info(String.format("try to start server at port %s", port));
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(port);
        server.setHandler(ctxWithHandlers);
        server.start();
        server.join();
    }
}
