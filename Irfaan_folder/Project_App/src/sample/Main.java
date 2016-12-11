package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    private BorderPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Free Rooms App");
        window.setMinHeight(300);
        window.setMinWidth(650);
        window.setMaxWidth(750);
        window.setMaxHeight(400);
        GridPane grid = new GridPane(); //change grid to searchArea
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
        grid.getChildren().add(dayLabel);

        final TextField day = new TextField();
        day.setPromptText("Day");
        //day.getText(); //gets day from field
        GridPane.setConstraints(day, 1, 0);
        grid.getChildren().add(day);

        //second field
        Label startLabel = new Label("Start Time:");
        GridPane.setConstraints(startLabel, 2, 0);
        grid.getChildren().add(startLabel);

        final TextField startTime = new TextField();
        startTime.setPromptText("Start Time");
        startTime.getText(); //gets input from field
        GridPane.setConstraints(startTime, 3, 0);
        grid.getChildren().add(startTime);


        //third field
        Label endLabel = new Label("End time:");
        GridPane.setConstraints(endLabel, 4, 0);
        grid.getChildren().add(endLabel);

        final TextField endTime = new TextField();
        endTime.setPromptText("End Time");
        //endTime.getText(); //gets input from field
        GridPane.setConstraints(endTime, 5, 0);
        grid.getChildren().add(endTime);

        //output
        TextArea output = new TextArea();
        output.setText("EXAMPLE OUTPUT!!"); //put output from file
        grid.add(output, 1, 1, 5, 1);

        layout = new BorderPane();
        //criteria fields
        layout.setTop(grid);
        //setting layout to display
        Scene scene = new Scene(layout, 650, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {launch(args);}
}
