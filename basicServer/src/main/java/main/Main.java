package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import servlets.*;


public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);

        Index indexServlet = new Index();
        ctx.addServlet(new ServletHolder(indexServlet), "/");
        ctx.addServlet(new ServletHolder(indexServlet), "/index");

        ctx.addServlet(new ServletHolder(new Contact()), "/contacts");

        Server server = new Server(8080);
        server.setHandler(ctx);

        server.start();
        server.join();
    }
}
