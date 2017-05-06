package beczka.sinseraser;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void web_beczka_open(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.beczka.krakow.dominikanie.pl/"));
        startActivity(browserIntent);
    }

    public void OnRachunekClick (View v)
    {
        if(v.getId()== R.id.rachunek_button)
        {
            Intent i = new Intent(MainActivity.this, DisplayRachunek.class);
            startActivity(i);
        }
    }


    public void OnWyszukajClick (View v)
    {
        if(v.getId()== R.id.trasa_button)
        {
            Intent i = new Intent(MainActivity.this, DisplayWyszukaj.class);
            startActivity(i);
        }
    }


    public void OnTrasyClick (View v)
    {
        if(v.getId()== R.id.lista_button)
        {
            Intent i = new Intent(MainActivity.this, DisplayTrasy.class);
            startActivity(i);
        }
    }


    public void web_edk_open(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.edk.org.pl/"));
        startActivity(browserIntent);
    }



}