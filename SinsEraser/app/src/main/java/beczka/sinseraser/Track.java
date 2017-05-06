package beczka.sinseraser;

public class Track {

    private String firstLevel;
    private String secondLevel;
    private String link;

    private String area;
    private String startCity;
    private String endCity;
    private String name;
    private int distance;

    Track(String firstLevel, String secondLevel, String link, String distance) {
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
        this.link = link;
        this.distance = Integer.parseInt(distance);

    }

    public int getDistance() {
        return distance;
    }

    public String getFirstLevel() {
        return firstLevel;
    }

    public String getSecondLevel() {
        return secondLevel;
    }

    public String getLink() {
        return link;
    }

    private int convertToInteger(String distance) {
        String[] tmp = distance.split("\\s");
        //System.out.println("ilosc kilometrów "+tmp[1]);
        return Integer.parseInt(tmp[0]);
    }


}