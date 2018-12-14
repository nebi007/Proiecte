package service;

import domain.Book;
import domain.Rent;
import repository.Repository;

import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RentService {
    private Repository<String, Rent> rentService;
    private BookService bookService;
    private ClientService clientService;

    public RentService(Repository<String, Rent> rentService, BookService bookService, ClientService clientService) {
        this.rentService = rentService;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    public Collection<Rent> findAll(){return rentService.findAll();}



    public Long filtrare2(String parameter){
        Long numar=rentService.findAll().stream()
                .filter(x->x.getClient().getName().equals(parameter)).count();
        return numar;
    }

    public List<Book> filtrare3(){
        List<Book> l=bookService.findAll().stream()
                .filter(x->rentService.findAll().stream().filter(a->x.getID().equals(a.getBook().getID())).count()<3)
                .collect(Collectors.toList());

        return l;
    }
}
