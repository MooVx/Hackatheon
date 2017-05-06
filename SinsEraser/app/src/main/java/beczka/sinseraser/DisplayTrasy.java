package beczka.sinseraser;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.AlertDialog;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Krasnal on 06.05.2017.
 */

public class DisplayTrasy extends Activity
{

    private ListView list;
    private ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trasy_layout);

        list = (ListView) findViewById(R.id.lista_all);

        try {
            TracksBase.readFromFile(getAssets().open("data"));
        } catch (Exception e) {
        }
        String cars[] = TracksBase.allTracks();

        ArrayList<String> carL = new ArrayList<String>();
        carL.addAll(Arrays.asList(cars));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, cars);


        // Assign adapter to ListView
        list.setAdapter(adapter);

        list.setTextFilterEnabled(true);

        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                final Track currentTrack = TracksBase.tracksMap.get(((TextView) view).getText());

                AlertDialog alertDialog = new AlertDialog.Builder(DisplayTrasy.this).create();
                alertDialog.setTitle(((TextView) view).getText());
                alertDialog.setMessage(currentTrack.getSecondLevel());

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "przejdź",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                web_edk_open_named(currentTrack.getLink());
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "przeglądaj dalej",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }
        });


    }

    public void web_edk_open_named(String link) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }


}

