package mobilne.programownanie.projekt.finanse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import static mobilne.programownanie.projekt.finanse.Menu.SCORE;


public class Result extends AppCompatActivity {
    private int score, percent, amountOfQuestions;
    private SharedPreferences preferences, prefNick;
    private  ProgressBar progressBar;
    private TextView nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 11) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
        setContentView(R.layout.result);

        preferences = getSharedPreferences(Menu.KEY, Context.MODE_PRIVATE);
        prefNick = getSharedPreferences(Menu.KEY, Context.MODE_PRIVATE);
        percent = 0;
        score = preferences.getInt(SCORE, 0);
        amountOfQuestions = getDataBaseSize();

        if (score != 0)
        {
            percent = (score * 100) / amountOfQuestions;

        }
        progressBar = (ProgressBar)findViewById (R.id.circularProgressBar);
        progressBar.setProgress( percent );
        ((TextView) findViewById(R.id.textView1)).setText(percent +  "%");

        nick = (TextView)findViewById(R.id.nick);
        nick.setText(prefNick.getString(Menu.NICK, ""));
        if(isNetworkAvailable())
        {
            saveResult();
        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Błąd!");
            alertDialogBuilder
                    .setMessage("Nie można uzyskać połączenia z internetem. Twój wynik nie zostanie dopisany do bazy.")
                    .setCancelable(false)
                    .setPositiveButton("Zrozumiałem",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public int getDataBaseSize(){
        QuestionBank qb = new QuestionBank();
        qb.initQuestions(getApplicationContext());
        return qb.getLength();
    }

    public void returnMenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void saveResult() {


        String userScore = String.valueOf(score);
        String userNick = prefNick.getString(Menu.NICK, "");
        String type = "save";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, userNick, userScore);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
