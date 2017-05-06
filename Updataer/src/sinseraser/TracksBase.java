package sinseraser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TracksBase {
	
	public static Map<Integer,Track> tracksMap = new HashMap<Integer,Track>();
	static String page;
	
	public static void main(String [] args){
		readFromFile();
	}
	public static  void saveToFile() throws FileNotFoundException{
		File file = new File("data");
		PrintWriter pw = new PrintWriter(file);
		for(Map.Entry<Integer, Track> entry : tracksMap.entrySet()){
			pw.write(entry.getValue().getFirstLevel()+"\n");
			pw.write(entry.getValue().getSecondLevel()+"\n");
			pw.write(entry.getValue().getLink()+"\n");
			pw.write(entry.getValue().getDistance()+"\n");
			
		}
		pw.close();
		System.out.println("zapisalem do pliku");
	}

	public static void readFromFile(){
		FileReader file;
		try {
			file = new FileReader("data");
		BufferedReader br = new BufferedReader(file);
		
		   
		    String line;
		    String [] data = new String[4];
		    int flaga = 0;
		    int id=1;
		    
		    while ((line=br.readLine())!= null) {
		    	data[flaga]=line;
		    	flaga++;
		    	if(flaga==4){
		    		flaga=0;		    		
		    		tracksMap.put(id, new Track(data[0],data[1],data[2],data[3]));
		    		data = new String[4];
		    		id++;
		    		
		    	}
		    	
		    }

		 br.close();   
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
		
	public static  void updateTracks(){
		try {
			page=Downloader.downloadPage("http://www.edk.org.pl/trasy.html");			
			page = page.replaceAll( "&([^;]+(?!(?:\\w|;)))", "&amp;$1" );
			page = page.replaceAll("<head>.*</head>","" );
			page = page.replaceAll("nbsp","" );
			String page2 = Downloader.prepareXMLPage(page);
			Downloader.parseXml(page2);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
			
	}
		
		public static String[] allTracks(){
			ArrayList<String> tmp = new ArrayList<String>();
			for(Map.Entry<Integer, Track> entry : tracksMap.entrySet()){
							tmp.add(entry.getValue().getFirstLevel());
			}
			return tmp.toArray(new String[tmp.size()]);
		}
		
		
		public static String[] proposeTracks(int distance){
			ArrayList<String> tmp = new ArrayList<String>();
			int dis1=(int) (distance*0.9);
			int dis2=(int) (distance*1.1);
			for(Map.Entry<Integer, Track> entry : tracksMap.entrySet()){
				if(entry.getValue().getDistance()>=dis1 && entry.getValue().getDistance()<=dis2) 
							tmp.add(entry.getValue().getFirstLevel());
			}
			
			return tmp.toArray(new String[tmp.size()]);
		}
		

}
