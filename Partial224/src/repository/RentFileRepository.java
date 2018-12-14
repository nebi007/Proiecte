package repository;

import domain.Book;
import domain.Client;
import domain.Rent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class RentFileRepository extends AbstractFileRepository<String, Rent>{
    private Repository<String, Book> bookRepository;
    private Repository<String, Client> clientRepository;

    public RentFileRepository(String fileName, Repository<String, Book> e1, Repository<String, Client> e2) {
        super(fileName);
        bookRepository = e1;
        clientRepository = e2;
        super.loadData();
    }

    @Override
    protected Rent createEntity(String line) {
        List<String> attrs = Arrays.asList(line.split(","));
        Book e1 = bookRepository.findAll().stream()
                .filter(x->x.getID().equals(attrs.get(0)))
                .findFirst().get();
        Client e2 = clientRepository.findAll().stream()
                .filter(x->x.getID().equals(attrs.get(1)))
                .findFirst().get();
        LocalDateTime date = LocalDateTime.parse(attrs.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        return new Rent(e1,e2,date);
    }
}
