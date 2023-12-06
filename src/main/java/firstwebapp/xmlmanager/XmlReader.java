package firstwebapp.xmlmanager;

public interface XmlReader<T> {

    T readFromFile(String filePath);
}
