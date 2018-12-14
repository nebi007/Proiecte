package service;

import domain.Book;
import repository.Repository;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookService {
    private Repository<String, Book> bookrepo;

    public BookService(Repository<String, Book> bookrepo) {
        this.bookrepo = bookrepo;
    }


    public Collection<Book> findAll(){return bookrepo.findAll();}

    public Map<Enum,List<Book>> filter1(){
        Map<Enum,List<Book>> list= findAll().stream()
                .collect(Collectors.groupingBy(Book::getType));
        Map<Enum, List<Book>> sorted=list.entrySet().stream()
                .map(a -> new  AbstractMap.SimpleEntry<Enum, List<Book>>(a.getKey(), a.getValue().stream().sorted((o1,o2)->o1.getAuthor().compareTo(o2.getAuthor())).collect(Collectors.toList())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return sorted;
    }


}
