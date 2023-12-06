package firstwebapp.xmlmanager;

public class Client {

    private final String name;
    private final int Age;


    public Client(String name, int age) {
        this.name = name;
        this.Age = age;
        //  this.ds
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }
}
