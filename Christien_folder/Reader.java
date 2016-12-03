import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Reader {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Reading File");
		//File file = new File ("schedule.txt");
		try{
		BufferedReader br = new BufferedReader(new FileReader("schedule.txt"));


		while(true){
		String line = br.readLine();
		if(line== null)
			break;
		System.out.println(line);
	
	}



	}catch(IOException exception){
		System.out.println(exception);
	}

}
}