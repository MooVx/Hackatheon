package beczka.sinseraser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class DisplayRachunek extends Activity {
    private static SeekBar seek_bar;
    private static TextView text_view;
    ;
    private static Handler handler = new Handler();
    private static int result;
    private static String[] sins = {
            "1. Nie będziesz miał bogów cudzych przede Mną."
            , "2. Nie będziesz brał imienia Pana Boga swego na daremno."
            , "3. Pamiętaj , abyś dzień świety święcił."
            , "4. Czcij ojca swego i matke swoją."
            , "5. Nie zabijaj."
            , "6. Nie cudzołóż."
            , "7. Nie kradnij."
            , "8. Nie mów fałszywego świadectwa przeciw bliżniemu swemu."
            , "9. Nie pożądaj żony bliźniego swego."
            , "10. Ani żadnej rzeczy , która jego jest."
    };
    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            Log.d("Handlers", "Called on main thread");
            CalcPoints();
            PrintResult();
            handler.postDelayed(runnableCode, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rachunek_layout);
        handler.post(runnableCode);
        CalcPoints();
        PrintResult();
        PrintSins();
        ScrollView scroll = (ScrollView) findViewById(R.id.ScrollViev);
        scroll.setClickable(false);
        scroll.setMinimumHeight(10);
    }

    protected void OnConfessionClick(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(DisplayRachunek.this).create();
        alertDialog.setTitle("Zakończyłeś rachunek sumienia!");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Szukaj trase",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(DisplayRachunek.this, DisplayWyszukaj.class);
                            startActivity(i);

                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Dobierz rozważania",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(DisplayRachunek.this, DisplayRoz.class);
                        startActivity(i);
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public int CalcPoints() {
        result = (int)((((SeekBar) findViewById(R.id.seekBar1)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar2)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar3)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar4)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar5)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar6)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar7)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar8)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar9)).getProgress() +
                ((SeekBar) findViewById(R.id.seekBar10)).getProgress())*(((SeekBar)findViewById(R.id.Kondycja)).getProgress())/100);


        return result;
    }

    public static int calculateDistanceFromPoints()
    {
        return (int) (20 + ((double)DisplayRachunek.result / 9.1));
    }

    public void PrintResult() {

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Gratuluję, zdobyłeś łącznie : ");
        messageBuilder.append(result);
        messageBuilder.append(" punktów!");

        ((TextView) findViewById(R.id.Text)).setText(messageBuilder.toString());
    }

    public void PrintSins() {
        ((TextView) findViewById(R.id.Sin1)).setText(sins[0]);
        ((TextView) findViewById(R.id.Sin2)).setText(sins[1]);
        ((TextView) findViewById(R.id.Sin3)).setText(sins[2]);
        ((TextView) findViewById(R.id.Sin4)).setText(sins[3]);
        ((TextView) findViewById(R.id.Sin5)).setText(sins[4]);
        ((TextView) findViewById(R.id.Sin6)).setText(sins[5]);
        ((TextView) findViewById(R.id.Sin7)).setText(sins[6]);
        ((TextView) findViewById(R.id.Sin8)).setText(sins[7]);
        ((TextView) findViewById(R.id.Sin9)).setText(sins[8]);
        ((TextView) findViewById(R.id.Sin10)).setText(sins[9]);
    }


}