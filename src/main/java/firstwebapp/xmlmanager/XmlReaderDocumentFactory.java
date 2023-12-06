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

public class XmlReaderDocumentFactory implements XmlReader<Pair<Integer, List<MobileApp>>> {

  private final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    @Override
    public Pair<Integer, List<MobileApp>> readFromFile(String filePath) {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(filePath));

            Element root = doc.getDocumentElement();

            NodeList mobileAppNodes = root.getElementsByTagName("mobileApp");

            List<MobileApp> mobileApps = new ArrayList<>();

            for (int i = 0; i < mobileAppNodes.getLength(); i++) {
                Element mobileAppElement = (Element) mobileAppNodes.item(i);
                String name = mobileAppElement.getElementsByTagName("name").item(0).getTextContent();
                int size = Integer.parseInt(mobileAppElement.getElementsByTagName("size").item(0).getTextContent());

                MobileApp mobileApp = new MobileApp(name, size);
                mobileApps.add(mobileApp);
            }

            AtomicInteger totalSize = new AtomicInteger();

            mobileApps.forEach(mobileApp -> {
                totalSize.addAndGet(mobileApp.getSize());
            });
            return new MutablePair<>(totalSize.get(), mobileApps);
        }catch (Exception e){
            return new MutablePair<>(0, Collections.emptyList());
        }

    }
}
