package beczka.sinseraser;

import android.app.Activity;
import android.os.Bundle;

import static beczka.sinseraser.R.layout.rachunek_layout;

/**
 * Created by Krasnal on 06.05.2017.
 */

public class DisplayRachunek extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(rachunek_layout);
    }
}
