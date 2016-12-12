package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class searchStage{

    //Initiating Variables

    public String[] Days = {"Monday", "Tuesday", "Wenesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public List available_list = new ArrayList<String>();
    public ChoiceBox<String> dayDrop = new ChoiceBox<>();
    public ChoiceBox<String> startHour = new ChoiceBox<>();
    public ChoiceBox<String> startMin = new ChoiceBox<>();
    public ChoiceBox<String> endHour = new ChoiceBox<>();
    public ChoiceBox<String> endMin = new ChoiceBox<>();
    Stage window;
    public BorderPane layout;
    public  GridPane grid;
    public Button search = new Button("Search");
    String line;
    File file = new File("schedule.txt");



    public Set<String> getClasses(File file, int startTime, int endTime, String day){
        System.out.println(startTime);
        System.out.println(endTime);
        Set<String> holder = new HashSet<String>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println("Reading text File");
            line = br.readLine();

            String[] classes;



            while((line = br.readLine())!=null){

                classes = line.split("\\|");
                holder.add(classes[8]);
                int class_Start = Concatinate(Integer.parseInt(classes[3]), Integer.parseInt(classes[5]));
                //System.out.println(class_Start);
                int class_End = Concatinate(Integer.parseInt(classes[6]), Integer.parseInt(classes[7]));
                //System.out.println(class_End);
                System.out.println("Reach 1");
                if(classes[4] == day) {
                    if(class_Start <= endTime && class_End >= startTime){
                        System.out.println("Reach 1");
                        if((class_Start <= startTime || class_Start >= startTime) && (class_End >= endTime || class_End <= endTime)){
                            System.out.println("Reach 2");
                            holder.remove(classes[8]);
                        }
                    }
                }
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        //System.out.println("made it");
        return holder;
    }

    public int Concatinate(int num1, int num2){
        int Time;
        if(num2 == 0){
            Time = (Integer.parseInt(String.valueOf(num1) + "00"));
            return Time;
        }


        Time = Integer.parseInt(String.valueOf(num1) + String.valueOf(num2));
        return Time;

    }



    searchStage(Stage primaryStage){



        window = primaryStage;
        window.setTitle("Free Rooms App");
        window.setMinHeight(750);
        window.setMinWidth(650);
        window.setMaxWidth(750);
        window.setMaxHeight(750);
        grid = new GridPane(); //change grid to searchArea
        grid.setPadding(new Insets(20, 10, 10, 10));
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
        output.setScrollTop(1);
        output.setScrollLeft(1);

        //DropDown Menu
        for(int i = 0; i <= 24; i++){
            if(i < 10){
                startHour.getItems().add("0" + String.valueOf(i));
            }else{
                startHour.getItems().add(String.valueOf(i));
            }
        }

        for(int i = 0; i <= 59; i++){
            if(i < 10){
                startMin.getItems().add("0" + String.valueOf(i));
            }else{
                startMin.getItems().add(String.valueOf(i));
            }
        }

        for(int i = 0; i <= 24; i++){
            if(i < 10){
                endHour.getItems().add("0" + String.valueOf(i));
            }else{
                endHour.getItems().add(String.valueOf(i));
            }
        }

        for(int i = 0; i <= 59; i++){
            if(i < 10){
                endMin.getItems().add("0" + String.valueOf(i));
            }else{
                endMin.getItems().add(String.valueOf(i));
            }
        }

        for(int x = 0; x < Days.length; x++){
            dayDrop.getItems().add(Days[x]);
        }

        //Search Button

        search.setMnemonicParsing(true);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    output.clear();
                    Set<String> tempSet = new HashSet<String>();
                    String s_Time = (startHour.getValue() + startMin.getValue());
                    String e_Time = endHour.getValue() + endMin.getValue();
                    String selected_Day = dayDrop.getValue().substring(0,1);

                    tempSet = getClasses(file,Integer.parseInt(s_Time),Integer.parseInt(e_Time),selected_Day);
                    String[] free_rooms = tempSet.toArray(new String[tempSet.size()]);
                    output.appendText("-------------------------ROOMS AVAILABLE[" + String.valueOf(tempSet.size()) + "]-------------------------" + "\n");

                    for(int i = 0; i < free_rooms.length; i++){
                        output.appendText("\n");
                        output.appendText(String.valueOf(free_rooms[i]) + "\n");
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        //Adding elements to grid
        grid.add(dayLabel,1,1,1,1);
        grid.add(dayDrop,2,1,1,1);
        grid.add(startLabel,1,2,1,1);
        grid.add(startHour,2,2,1,1);
        grid.add(startMin,3,2,1,1);
        grid.add(endLabel,1,3,1,1);
        grid.add(endHour,2,3,1,1);
        grid.add(endMin,3,3,1,1);
        grid.add(search, 5,5,5,5);
        grid.add(output, 1, 4, 6, 1);


    }


}
