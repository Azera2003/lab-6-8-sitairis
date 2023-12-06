package firstwebapp.xmlmanager;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ClientServlet", urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String filePath = "C:\\Users\\HP\\Desktop\\СИТАИРИС\\4_lab\\new_test.xml";

            XmlReader<Pair<Integer, List<Client>>> reader = new XmlReaderDocumentFactory();
            XmlManager<Pair<Integer, List<Client>>> manager = new XmlManagerImpl(filePath,reader);



            request.setAttribute("apps", manager.readFromFile());


            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", "An error occurred while processing the XML file.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
