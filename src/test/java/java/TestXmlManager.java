package java;

import firstwebapp.xmlmanager.Client;
import firstwebapp.xmlmanager.XmlManager;
import firstwebapp.xmlmanager.XmlManagerImpl;
import firstwebapp.xmlmanager.XmlReader;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestXmlManager {

    private XmlManager<Pair<Integer, List<Client>>> manager;
    private XmlReaderTest reader;

    @Before
    public void setup(){
        this.reader = new XmlReaderTest();
        this.manager = new XmlManagerImpl("",reader);


    }

    @Test()
    public void testReadFromFile(){
        Pair<Integer, List<Client>> expected = new MutablePair<>(0, Collections.emptyList());
        reader.setResult(expected);

        Pair<Integer, List<Client>> actual = manager.readFromFile();

        assertEquals(expected.getLeft(),actual.getLeft());
        assertEquals(expected.getRight(),actual.getRight());
    }

    private class XmlReaderTest implements XmlReader<Pair<Integer, List<Client>>>{

        private Pair<Integer, List<Client>> result;

        void setResult(Pair<Integer, List<Client>> result){
            this.result = result;
        }

        @Override
        public Pair<Integer, List<Client>> readFromFile(String filePath) {
            return result;
        }
    }
}
