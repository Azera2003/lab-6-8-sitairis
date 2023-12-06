package firstwebapp.xmlmanager;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class XmlReaderDocumentFactory implements XmlReader<Pair<Integer, List<Client>>> {

  private final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    @Override
    public Pair<Integer, List<Client>> readFromFile(String filePath) {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(filePath));

            Element root = doc.getDocumentElement();

            NodeList clientNodes = root.getElementsByTagName("client");

            List<Client> clients = new ArrayList<>();

            for (int i = 0; i < clientNodes.getLength(); i++) {
                Element clientElement = (Element) clientNodes.item(i);
                String name = clientElement.getElementsByTagName("name").item(0).getTextContent();
                int size = Integer.parseInt(clientElement.getElementsByTagName("age").item(0).getTextContent());

                Client client = new Client(name, size);
                clients.add(client);
            }

            AtomicInteger totalSize = new AtomicInteger();

            clients.forEach(client -> {
                totalSize.addAndGet(client.getAge());
            });
            return new MutablePair<>(totalSize.get(), clients);
        }catch (Exception e){
            return new MutablePair<>(0, Collections.emptyList());
        }

    }
}
