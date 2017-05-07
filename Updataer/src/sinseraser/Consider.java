package sinseraser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Consider {
	
	public static String contenplation(int station) throws IOException{
		Random generate = new Random();
		int number = generate.nextInt(5)+1;
		String fileName = "content\\"+station+"-"+number+".txt";
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder data = new StringBuilder();
		String line;
		while((line=br.readLine())!=null){
			data.append(line+"\n");
		}
		return data.toString();
	}
	
}
