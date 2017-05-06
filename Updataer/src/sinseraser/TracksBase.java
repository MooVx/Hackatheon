package sinseraser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TracksBase {
	
	public static Map<Integer,Track> tracksMap = new HashMap<Integer,Track>();
	static String page;
	
	public static void main(String [] args){
		//readFromFile();
		updateTracks();
	}
	public static  void saveToFile() throws IOException{
		FileOutputStream file = new FileOutputStream("data");
		
		OutputStreamWriter os = new OutputStreamWriter(file,"UTF-8");
		for(Map.Entry<Integer, Track> entry : tracksMap.entrySet()){
			os.write(entry.getValue().getFirstLevel()+"\n");
			os.write(entry.getValue().getName()+"\n");
			os.write(entry.getValue().getStartCity()+"\n");
			os.write(entry.getValue().getEndCity()+"\n");			
			os.write(entry.getValue().getLink()+"\n");
			os.write(entry.getValue().getDistance()+"\n");
			
		}
		
		System.out.println("zapisalem do pliku");
	}

	public static void readFromFile(){
		FileReader file;
		try {
			file = new FileReader("data");
		BufferedReader br = new BufferedReader(file);
		
		   
		    String line;
		    String [] data = new String[6];
		    int flaga = 0;
		    int id=1;
		    
		    while ((line=br.readLine())!= null) {
		    	data[flaga]=line;
		    	flaga++;
		    	if(flaga==6){
		    		flaga=0;		    		
		    		tracksMap.put(id, new Track(data));
		    		data = new String[6];
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
