package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;


public class Reader extends Application{

    //Interfaces
    Main page;
    public static String line;



    @Override
    public void start(Stage primaryStage) throws Exception{

        page = new Main(primaryStage);
        page.layout = new BorderPane();
        page.layout.setCenter(page.grid);
        page.layout.setStyle("-fx-background-color: #f2f2f2");


        Scene scene = new Scene (page.layout, 650, 300);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args){
        File file = new File ("schedule.txt");
        System.out.println("Starting");

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println("Reading text File");
            int counter = 1;
            line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
                System.out.println(counter);
                counter += 1;

            }
        }catch(Exception e){
            System.out.println("File not found");
        }

        System.out.println("Creating Stage");
        launch(args);
    }
}