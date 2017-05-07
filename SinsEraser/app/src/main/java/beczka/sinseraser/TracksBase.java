package beczka.sinseraser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TracksBase {

    public static Map<String, Track> tracksMap = new HashMap<String, Track>();

    public static void readFromFile(InputStream data) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(data, "UTF-8"));

            String line;
            String [] data2 = new String[6];
            int flaga = 0;
            int id=1;

            while ((line=br.readLine())!= null) {
                data2[flaga]=line;
                flaga++;
                if(flaga==6){
                    flaga=0;
                    tracksMap.put(data2[0], new Track(data2));
                    data2 = new String[6];
                    id++;
                }
            }

            br.close();
        } catch (Exception e) {

        }
    }


    public static String[] allTracks() {
        ArrayList<String> tmp = new ArrayList<String>();

        for (Map.Entry<String, Track> entry : tracksMap.entrySet()) {
            tmp.add(entry.getValue().getFirstLevel());
        }

        Collections.sort(tmp);

        return tmp.toArray(new String[tmp.size()]);
    }


    public static String[] proposeTracks(int distance) {
        ArrayList<String> tmp = new ArrayList<String>();
        int dis1 = (int) (distance * 0.9);
        int dis2 = (int) (distance * 1.1);
        for (Map.Entry<String, Track> entry : tracksMap.entrySet()) {
            if (entry.getValue().getDistance() >= dis1 && entry.getValue().getDistance() <= dis2)
                tmp.add(entry.getValue().getFirstLevel());
        }

        Collections.sort(tmp);

        return tmp.toArray(new String[tmp.size()]);
    }


}