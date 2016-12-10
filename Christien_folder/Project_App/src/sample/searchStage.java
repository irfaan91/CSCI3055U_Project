package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class searchStage{

    Stage window;
    public BorderPane layout;
    public  GridPane grid;
    public Button send = new Button("Send");


    searchStage(Stage primaryStage){



        window = primaryStage;
        window.setTitle("Free Rooms App");
        window.setMinHeight(300);
        window.setMinWidth(650);
        window.setMaxWidth(750);
        window.setMaxHeight(400);
        grid = new GridPane(); //change grid to searchArea
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setVgap(5);
        grid.setHgap(5);

        //It must print a list of rooms which are available during this time.
        //Namely, there is no class scheduled in the room after (and excluding)
        //10:00am and before (and excluding) 12:00pm on Monday.
        //Print one room per line.
        //text field format
        //day start-time end-time
        //M 10:00am 12:00pm

        //first field
        Label dayLabel = new Label("Day:");
        GridPane.setConstraints(dayLabel, 0, 0);


        final TextField day = new TextField();
        day.setPromptText("Day");
        //day.getText(); //gets day from field
        GridPane.setConstraints(day, 1, 0);


        //second field
        Label startLabel = new Label("Start Time:");
        GridPane.setConstraints(startLabel, 2, 0);


        final TextField startTime = new TextField();
        startTime.setPromptText("Start Time");
        startTime.getText(); //gets input from field
        GridPane.setConstraints(startTime, 3, 0);



        //third field
        Label endLabel = new Label("End time:");
        GridPane.setConstraints(endLabel, 4, 0);


        final TextField endTime = new TextField();
        endTime.setPromptText("End Time");
        //endTime.getText(); //gets input from field
        GridPane.setConstraints(endTime, 5, 0);


        //output
        TextArea output = new TextArea();


        //Search Button

        send.setMnemonicParsing(true);
        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    if(startTime.getText() != ""){
                        output.appendText(startTime.getText());

                    }

                    if(endTime.getText() != ""){
                        output.appendText((endTime.getText()));

                    }



                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        //Adding elements to grid
        grid.getChildren().add(dayLabel);
        grid.getChildren().add(day);
        grid.getChildren().add(startLabel);
        grid.getChildren().add(startTime);
        grid.getChildren().add(endLabel);
        grid.getChildren().add(endTime);
        grid.add(send, 5,5,5,5);
        grid.add(output, 1, 1, 5, 1);


    }


}
