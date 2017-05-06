package sinseraser;

public class Track {
	
		private String firstLevel;
		private String secondLevel;
		private String link;
		
		private String area;
		private String startCity;
		private String endCity;
		private String name;		
		private int distance;
		
		public int getDistance(){
			return distance;
		}
		public String getFirstLevel(){
			return firstLevel;
		}
				
		Track(String name, String area, String startCity, String endCity, String distance){
			this.startCity=startCity.replaceAll("\\s{2,}", "");
			this.endCity=endCity.replaceAll("\\s{2,}", "");
			this.name=name.replaceAll("\\s{2,}", "");
			this.area=area.replaceAll("\\s{2,}", "");
			
			this.distance=convertToInteger(distance.replaceAll("\\s{2,}", ""));
			this.firstLevel=this.startCity+" "+this.distance+" km";
		}
		
		private int convertToInteger(String distance){
			String[] tmp = distance.split("\\s");
			//System.out.println("ilosc kilometrów "+tmp[1]);
			return Integer.parseInt(tmp[0]);
		}
		
		
		
		
}
