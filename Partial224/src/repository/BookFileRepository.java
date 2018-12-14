package repository;

import domain.Book;
import domain.Enum;

import java.util.Arrays;
import java.util.List;

public class BookFileRepository extends AbstractFileRepository<String, Book> {
    public BookFileRepository(String fileName) {
        super(fileName);
        super.loadData();
    }

    @Override
    protected Book createEntity(String line) {
        List<String> attrs = Arrays.asList(line.split(","));
        String bookId=attrs.get(0);
        String name=attrs.get(1);
        String author=attrs.get(2);
        Enum type= Enum.valueOf(attrs.get(3));
        return new Book(bookId,name,author,type);
    }
}
