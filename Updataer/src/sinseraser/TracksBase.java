package sinseraser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TracksBase {
	
	public static Map<Integer,Track> tracksMap = new HashMap<Integer,Track>();
	static String page;
	
	public static void main(String [] args){
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
		
		for(String s: allTracks()){
			System.out.println(s);
		}
		
		
	}
	
	
		
		public void updateTracks(){

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
