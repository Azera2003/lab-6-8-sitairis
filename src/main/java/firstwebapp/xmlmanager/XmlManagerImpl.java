package firstwebapp.xmlmanager;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class XmlManagerImpl implements XmlManager<Pair<Integer, List<Client>>>{

    private final String filePath;
    private final XmlReader<Pair<Integer, List<Client>>> reader;

    public XmlManagerImpl(String filePath,XmlReader<Pair<Integer, List<Client>>> reader) {
        this.filePath = filePath;
        this.reader = reader;
    }

    @Override
    public Pair<Integer, List<Client>> readFromFile() {
        return reader.readFromFile(filePath);
    }
}
