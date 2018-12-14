import controller.Controller;
import domain.Book;
import domain.Client;
import domain.Rent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.BookFileRepository;
import repository.ClientFileRepository;
import repository.RentFileRepository;
import repository.Repository;
import service.BookService;
import service.ClientService;
import service.RentService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("controller/view.fxml"));
        Parent root = loader.load();
        Controller ctrl = loader.getController();

        Repository<String, Book> repo1 = new BookFileRepository("entity1.txt");
        Repository<String, Client> repo2 = new ClientFileRepository("entity2.txt");
        Repository<String, Rent> repo3 = new RentFileRepository("entity3.txt", repo1, repo2);
        BookService bookService = new BookService(repo1);
        ClientService clientService = new ClientService(repo2);
        RentService rentService = new RentService(repo3, bookService, clientService);
        ctrl.setServices(bookService, clientService, rentService);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
