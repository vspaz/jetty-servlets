package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import servlets.IndexServlet;


public class Main {
    public static void main(String[] args) throws Exception {
        IndexServlet indexServlet = new IndexServlet();

        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ctx.addServlet(new ServletHolder(indexServlet), "/");
        ctx.addServlet(new ServletHolder(indexServlet), "/index");

        Server server = new Server(8080);
        server.setHandler(ctx);

        server.start();
        server.join();
    }
}
