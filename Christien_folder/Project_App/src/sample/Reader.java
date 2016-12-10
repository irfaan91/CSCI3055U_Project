package sample;

import java.io.*;


public class Reader{

    public static void main(String[] args){
        System.out.println("Reading File");
        File file = new File ("schedule.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));


            while(true){
                String line = br.readLine();
                while(line != null){
                    System.out.println(line);
                }

            }

        }catch(Exception e){
            System.out.println("File not found");
        }



    }
}