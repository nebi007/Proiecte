package domain;

import java.time.LocalDateTime;

public class Rent implements HasID<String> {
    private String rentId;
    private Book book;
    private Client client;
    private LocalDateTime rentDate;


    public Rent(Book book, Client client, LocalDateTime rentDate) {
        this.rentId=book.getID()+"-"+client.getID();
        this.book = book;
        this.client = client;
        this.rentDate = rentDate;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    @Override
    public String getID() {
        return rentId;
    }

    @Override
    public void setID(String s) {
        rentId=s;
    }
}
