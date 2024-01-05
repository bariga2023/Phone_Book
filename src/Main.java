import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application{


    Scene scene;
    Scene listScene;
    Scene searchScene;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Stage window = primaryStage;

        window.setTitle("Phone Book");

        HashTable contactTable = new HashTable();

        //contact list
        ListView<String> contactList = new ListView<String>();

        Label l3 = new Label("");

        //text input boxes
        TextField nameInput = new TextField();
        nameInput.setPromptText("type name");
        TextField numberInput = new TextField();
        numberInput.setPromptText("type number");
        TextField addressInput = new TextField();
        addressInput.setPromptText("type address");
        TextField searchInput = new TextField();
        searchInput.setPromptText("type name");


        Button addContactButton = new Button("Add Contact");
        Button searchButton = new Button("Search");
        Button listButton = new Button("View all Contacts");


        //Button Functions
        addContactButton.setOnAction(e -> {contactList.getItems().add(nameInput.getText()
                             + "   |   " + numberInput.getText() + "   |   " + addressInput.getText());
                contactTable.add(new Contact(nameInput.getText(), numberInput.getText(), addressInput.getText()));
                nameInput.clear(); numberInput.clear(); addressInput.clear();});

        searchButton.setOnAction(e -> {

            l3.setText(contactTable.search(searchInput.getText()));
            searchInput.clear(); window.setScene(searchScene);});

        listButton.setOnAction(e -> window.setScene(listScene));




        VBox addContact = new VBox(10);
        addContact.getChildren().addAll(new Label("Please type the name of the contact"), nameInput,
                new Label("Please type the number of the contact"), numberInput,
                new Label("Please type the address of the contact"), addressInput,
                addContactButton);

        HBox searchBar = new HBox(10);
        searchBar.getChildren().addAll(new Label("Search for Contact Information (type name)"),
                searchInput, searchButton);

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 30, 30));
        gp.setVgap(10);
        gp.setHgap(5);

        Label l1 = new Label("Search for Contact Information (type name)");
        Label l2 = new Label("Add Contact:");

        //search bar
        gp.setConstraints(l1, 0, 0);
        gp.setConstraints(searchInput, 1, 0);
        gp.setConstraints(searchButton, 2, 0);

        //add contact
        gp.setConstraints(l2, 0, 8);
        gp.setConstraints(addContact, 0, 10);

        //add list button
        gp.setConstraints(listButton, 0, 20);

        gp.getChildren().addAll(l1, searchInput, searchButton, l2, addContact, listButton);
        scene = new Scene(gp, 750, 550);

        Button returnButton = new Button("return");
        returnButton.setOnAction(e -> window.setScene(scene));
        Button returnButton2 = new Button("return");
        returnButton2.setOnAction(e -> window.setScene(scene));

        VBox listLayout = new VBox(10);
        listLayout.setPadding(new Insets(20, 20, 20, 20));
        listLayout.getChildren().addAll(contactList, returnButton);
        listScene = new Scene(listLayout, 500, 300);

        VBox searchLayout = new VBox(20);
        searchLayout.setPadding(new Insets(10, 10, 10, 10));
        searchLayout.getChildren().addAll(l3, returnButton2);
        searchScene = new Scene(searchLayout, 500, 100);

        window.setScene(scene);
        window.show();

        /**
        window = primaryStage;

        String x = "hi" + 1;
        Label label1 = new Label(x);
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));
        primaryStage.setTitle("Title of the Window");



        //layout1

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);


        Button button2 = new Button("go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 200);


        window.setScene(scene1);
        window.setTitle("new window");
        window.show();
         */

    }


}