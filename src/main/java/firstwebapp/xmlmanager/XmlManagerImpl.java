package firstwebapp.xmlmanager;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class XmlManagerImpl implements XmlManager<Pair<Integer, List<MobileApp>>>{

    private final String filePath;
    private final XmlReader<Pair<Integer, List<MobileApp>>> reader;

    public XmlManagerImpl(String filePath,XmlReader<Pair<Integer, List<MobileApp>>> reader) {
        this.filePath = filePath;
        this.reader = reader;
    }

    @Override
    public Pair<Integer, List<MobileApp>> readFromFile() {
        return reader.readFromFile(filePath);
    }
}
