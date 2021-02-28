package main;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import servlets.*;
import servlets.servers.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = Log.getRootLogger();
        logger.info("starting server...");
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);

        Index indexServlet = new Index();

        ctx.addServlet(new ServletHolder(new Contact()), "/contacts");
        ctx.addServlet(new ServletHolder(indexServlet),  "/index");
        ctx.addServlet(new ServletHolder(new VM()),      "/servers");
        ctx.addServlet(new ServletHolder(indexServlet),  "/");

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        server.setHandler(ctx);

        server.start();
        server.join();
    }
}
