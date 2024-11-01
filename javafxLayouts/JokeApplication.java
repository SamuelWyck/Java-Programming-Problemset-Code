package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        //System.out.println("Hello world!");
        launch(JokeApplication.class);
    }
    
    public void start(Stage window) {
        BorderPane menu = new BorderPane();
        
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(10);
        
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explainButton = new Button("Explanation");
        
        buttonBar.getChildren().addAll(jokeButton, answerButton, explainButton);
        menu.setMargin(buttonBar, new Insets(50, 50, 50, 50));
        menu.setTop(buttonBar);
        
        Label jokeLabel = new Label("What do you call a bear with no teeth?");
        Label answerLabel = new Label("A gummy bear.");
        Label explainLabel = new Label("Gummy bears don't have teeth.");
        
        menu.setMargin(jokeLabel, new Insets(50, 50, 50, 50));
        menu.setCenter(jokeLabel);
        
        jokeButton.setOnAction((event) -> {
            menu.setCenter(jokeLabel);
        });
        answerButton.setOnAction((event) -> {
            menu.setCenter(answerLabel);
        });
        explainButton.setOnAction((event) -> {
            menu.setCenter(explainLabel);
        });
        
        Scene scene = new Scene(menu);
        window.setScene(scene);
        window.show();
    }
}
