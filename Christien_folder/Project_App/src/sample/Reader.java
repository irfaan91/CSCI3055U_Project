package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;


public class Reader extends Application{

    //Interfaces
    searchStage page;
    public static String line;



    public String getClasses(File file){

        return "";
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        page = new searchStage(primaryStage);
        page.layout = new BorderPane();
        page.layout.setCenter(page.grid);
        page.layout.setStyle("-fx-background-color: #7171E3");



        Scene scene = new Scene (page.layout, 650, 450);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args){
        File file = new File ("schedule.txt");
        System.out.println("Starting");



        System.out.println("Creating Stage");
        launch(args);
    }
}