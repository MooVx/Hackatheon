package beczka.sinseraser;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by MooVx on 07.05.2017.
 */

public class DisplayTextRoz extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_layout);
        ((TextView)findViewById(R.id.editText)).setText(confession(DisplayRoz.indeks));
    }

    private String confession (int station)
    {
        Random generate = new Random();
        int number = generate.nextInt(5)+1;
        String fileName = station+"-"+number;
        StringBuilder data = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));
            data = new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                data.append(line+"\n");
            }
        } catch (Exception e) {
        }
        return data.toString();

    }
}
