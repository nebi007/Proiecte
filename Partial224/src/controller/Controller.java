package controller;

import domain.Book;
import domain.Rent;
import domain.RentDto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.BookService;
import service.ClientService;
import service.RentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Controller {
    private BookService bookService;
    private ClientService clientService;
    private RentService rentService;


    @FXML
    Label titleLabel;
    @FXML
    DatePicker fromDatePicker;
    @FXML
    DatePicker toDatePicker;
    @FXML
    TableView<RentDto> tableView;
    @FXML
    Button filterButton;
    @FXML
    TableColumn<RentDto,Enum> typeColumn;
    @FXML
    TableColumn<RentDto,Long> nrColumn;

    private ObservableList<RentDto> model=FXCollections.observableArrayList();


    private List<RentDto> getDto(){

        Predicate<Rent> pPeriod = n ->
                this.fromDatePicker.getValue()==null ||
                        this.toDatePicker.getValue()==null ||
                        n.getRentDate().isAfter(this.fromDatePicker.getValue().atStartOfDay()) && n.getRentDate().isBefore(this.toDatePicker.getValue().atStartOfDay());

        List<Rent> listaR=rentService.findAll().stream()
                .filter(pPeriod).collect(Collectors.toList());

        List<Enum>  l=  bookService.findAll().stream().map(Book::getType).distinct().collect(Collectors.toList());


        List<RentDto> resturi=listaR.stream()
                .map(x->new RentDto(x.getBook().getType(),listaR
                        .stream()
                        .filter(a->a.getBook().getID().equals(x.getBook().getID()))
                        .count())).sorted((o1,o2)->o1.getType().compareTo(o2.getType()))
                        .collect(Collectors.toList());
        l.forEach(System.out::println);
        resturi.forEach(System.out::println);

        return resturi.stream().distinct().collect(Collectors.toList());

    }

    public void initialize(){

        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        nrColumn.setCellValueFactory(new PropertyValueFactory<>("nrcarti"));

        tableView.setItems(model);
    }

    String parameter;

    public void setServices(BookService bookService, ClientService clientService, RentService rentService){
        this.bookService = bookService;
        this.clientService = clientService;
        this.rentService = rentService;
        initModel();;
        afis();
    }

    void initModel(){
        model.setAll(getDto());
    }

    public void afis(){
        bookService.filter1().entrySet().forEach(x-> {System.out.println(x.getKey()+" ");x.getValue().forEach(a-> System.out.println(a));});
        Scanner in=new Scanner(System.in);
        parameter=in.nextLine();
        System.out.println(rentService.filtrare2(parameter));

        rentService.filtrare3().forEach(x-> System.out.println(x));
    }

}
