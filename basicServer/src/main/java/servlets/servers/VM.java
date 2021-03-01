package servlets.servers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VM extends HttpServlet {

    private final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Description serverDescription = Description.CreateDescription();
        serverDescription.setId(1);
        serverDescription.setName("vm");
        serverDescription.setDescription("small vm");
        serverDescription.setCpuCount(4);
        serverDescription.setHdd(1024 * 1024);
        serverDescription.setRam(4 * 1024);

        ArrayList<String> tags = new ArrayList<>();
        tags.add("amd");
        tags.add("amd64");
        serverDescription.setTags(tags);
        String encodedServerDescription = this.gson.toJson(serverDescription);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(encodedServerDescription);
        out.flush();
    }
}
