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
		
		public String getStartCity(){
			return startCity;
		}
		
		public String getEndCity(){
			return endCity;
		}
		
		public String getName(){
			return name;
		}	
		
		public int getDistance(){
			return distance;
		}
		public String getFirstLevel(){
			return firstLevel;
		}
		
		public String getSecondLevel(){
			return secondLevel;
		}
		
		public String getLink(){
			return link;
		}
			
		Track(String[] tab){
			this.firstLevel=tab[0];
			this.name=tab[1];
			this.startCity=tab[2];
			this.endCity=tab[3];
			this.link=tab[4];
			this.distance=Integer.parseInt(tab[5]);
		}
		Track(String name, String area, String startCity, String endCity, String distance,String link){
			this.startCity=startCity.replaceAll("\\s{2,}", "");
			this.endCity=endCity.replaceAll("\\s{2,}", "");
			this.name=name.replaceAll("\\s{2,}", "");
			this.area=area.replaceAll("\\s{2,}", "");
			this.link=link;
			
			this.distance=convertToInteger(distance.replaceAll("\\s{2,}", ""));
			this.firstLevel=this.startCity+" "+this.distance+" km";
			this.secondLevel=this.name+" "+this.startCity+" "+this.endCity;
		}
		
		private int convertToInteger(String distance){
			String[] tmp = distance.split("\\s");
			//System.out.println("ilosc kilometrów "+tmp[1]);
			return Integer.parseInt(tmp[0]);
		}
		
		
		
		
}
