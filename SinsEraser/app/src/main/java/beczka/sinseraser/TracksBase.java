package beczka.sinseraser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TracksBase {

    public static Map<String,Track> tracksMap = new HashMap<String,Track>();
    static String page;

    public static void readFromFile(InputStream data){

        FileReader file;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(data, "UTF-8"));
            String line;
            String [] data2 = new String[4];
            int flaga = 0;
            int id=1;

            while ((line=br.readLine())!= null) {
                data2[flaga]=line;
                flaga++;
                if(flaga==4){
                    flaga=0;
                    tracksMap.put(data2[0], new Track(data2[0],data2[1],data2[2],data2[3]));
                    data2 = new String[4];
                    id++;

                }
            }

            br.close();
        }catch(Exception e) {
            tracksMap.put("Err", new Track(e.getMessage(), "20", "20", "20"));
            e.printStackTrace();
        }
    }




    public static String[] allTracks(){
        ArrayList<String> tmp = new ArrayList<String>();
        for(Map.Entry<String, Track> entry : tracksMap.entrySet()){
            tmp.add(entry.getValue().getFirstLevel());
        }
        return tmp.toArray(new String[tmp.size()]);
    }


    public static String[] proposeTracks(int distance){
        ArrayList<String> tmp = new ArrayList<String>();
        int dis1=(int) (distance*0.9);
        int dis2=(int) (distance*1.1);
        for(Map.Entry<String, Track> entry : tracksMap.entrySet()){
            if(entry.getValue().getDistance()>=dis1 && entry.getValue().getDistance()<=dis2)
                tmp.add(entry.getValue().getFirstLevel());
        }

        return tmp.toArray(new String[tmp.size()]);
    }


}