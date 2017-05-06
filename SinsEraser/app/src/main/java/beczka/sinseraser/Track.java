package beczka.sinseraser;

import android.support.annotation.NonNull;

public class Track implements Comparable<Track> {

    private String firstLevel;
    private String secondLevel;
    private String link;

    private String area;
    private String startCity;
    private String endCity;
    private String name;
    private int distance;

    public String getFirstLevel(){
        return firstLevel;
    }

    public String getName(){
        return name;
    }

    public int getDistance()
    {
        return distance;
    }

    public String getSecondLevel(){
        return secondLevel;
    }

    public String getLink(){
        return link;
    }

    public int compareTo(@NonNull Track other)
    {
        return firstLevel.compareTo(other.firstLevel);
    }

    Track(String[] tab){
        this.firstLevel=tab[0];
        this.startCity=tab[2];
        this.endCity=tab[3];
        this.link=tab[4];
        this.distance=Integer.parseInt(tab[5]);

        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(tab[1]);
        nameBuilder.append(" ");
        nameBuilder.append(tab[5]);
        nameBuilder.append(" km");
        this.name = nameBuilder.toString();

        StringBuilder secondLevelBuilder = new StringBuilder();
        secondLevelBuilder.append(tab[2]);
        secondLevelBuilder.append(" --> ");
        secondLevelBuilder.append(tab[3]);
        secondLevel = secondLevelBuilder.toString();
    }


}