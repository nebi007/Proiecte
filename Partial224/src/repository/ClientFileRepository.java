package repository;

import domain.Client;

import java.util.Arrays;
import java.util.List;

public class ClientFileRepository extends AbstractFileRepository<String, Client> {
    public ClientFileRepository(String fileName) {
        super(fileName);
        super.loadData();
    }

    @Override
    protected Client createEntity(String line) {
        List<String> attrs = Arrays.asList(line.split(","));
        String clientId=attrs.get(0);
        String name=attrs.get(1);
        return new Client(clientId,name);
    }
}
