package domain;

public class Book implements HasID<String> {

    private String bookId;
    private String name;
    private String author;

    public Book(String bookId, String name, String author, Enum type) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    private Enum type;
    @Override
    public String getID() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public void setID(String s) {
        bookId=s;
    }
}
