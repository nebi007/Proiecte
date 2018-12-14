package domain;

public class Client implements HasID<String> {


    private String clientId;
    private String name;


    @Override
    public String getID() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(String clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    @Override
    public void setID(String s) {
        clientId=s;
    }
}
