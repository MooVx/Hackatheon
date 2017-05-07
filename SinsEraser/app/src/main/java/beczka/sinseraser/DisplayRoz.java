package beczka.sinseraser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MooVx on 07.05.2017.
 */

public class DisplayRoz extends Activity {

    public static int indeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stacje_layout);

    }

    public void OnB1(View view){
        if(view.getId()== R.id.b1)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 1;
            startActivity(i);
        }
    }

    public void OnB2(View view){
        if(view.getId()== R.id.b2)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 2;
            startActivity(i);
        }
    }

    public void OnB3(View view){
        if(view.getId()== R.id.b3)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 3;
            startActivity(i);
        }
    }

    public void OnB4(View view){
        if(view.getId()== R.id.b4)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 4;
            startActivity(i);
        }
    }

    public void OnB5(View view){
        if(view.getId()== R.id.b5)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 5;
            startActivity(i);
        }
    }
    public void OnB6(View view){
        if(view.getId()== R.id.b6)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 6;
            startActivity(i);
        }
    }
    public void OnB7(View view){
        if(view.getId()== R.id.b7)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 7;
            startActivity(i);
        }
    }
    public void OnB8(View view){
        if(view.getId()== R.id.b8)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 8;
            startActivity(i);
        }
    }
    public void OnB9(View view){
        if(view.getId()== R.id.b9)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 9;
            startActivity(i);
        }
    }
    public void OnB10(View view){
        if(view.getId()== R.id.b10)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 10;
            startActivity(i);
        }
    }
    public void OnB11(View view){
        if(view.getId()== R.id.b11)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 11;
            startActivity(i);
        }
    }
    public void OnB12(View view){
        if(view.getId()== R.id.b12)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 12;
            startActivity(i);
        }
    }
    public void OnB13(View view){
        if(view.getId()== R.id.b13)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 13;
            startActivity(i);
        }
    }
    public void OnB14(View view){
        if(view.getId()== R.id.b14)
        {
            Intent i = new Intent(DisplayRoz.this, DisplayTextRoz.class);
            indeks = 14;
            startActivity(i);
        }
    }
}