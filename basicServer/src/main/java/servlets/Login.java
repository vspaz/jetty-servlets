package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("  <head>\r\n")
                .append("    <title>Login</title>\r\n")
                .append("  <head>\r\n")
                .append("  <body>\r\n")
                .append("    <form action=\"login\" method=\"POST\">\r\n")
                .append("      Please enter your name: <br />\r\n")
                .append("      <input type=\"text\" name=\"user\" ><br />\r\n")
                .append("      Please enter your password: <br />\r\n")
                .append("      <input type=\"text\" name=\"password\"/><br />\r\n")
                .append("      <input type=\"submit\" value=\"Submit\"/>\r\n")
                .append("    </form>\r\n")
                .append("  </body>\r\n")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        if (user.equals("") || password.equals("")) {
            this.doGet(request, response);
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("  <head>\r\n")
                    .append("    <title>Login</title>\r\n")
                    .append("  <head>\r\n")
                    .append("  <body>\r\n")
                    .append("    Hi, \r\n").append(user).append("<br></br>\r\n")
                    .append("  </body")
                    .append("</html>");
        }
    }
}
