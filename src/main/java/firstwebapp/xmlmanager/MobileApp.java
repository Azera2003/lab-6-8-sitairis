package firstwebapp.xmlmanager;

public class MobileApp {

    private final String name;
    private final int Size;


    public MobileApp(String name, int size) {
        this.name = name;
        this.Size = size;
        //  this.ds
    }


    public String getName() {
        return name;
    }

    public int getSize() {
        return Size;
    }
}
