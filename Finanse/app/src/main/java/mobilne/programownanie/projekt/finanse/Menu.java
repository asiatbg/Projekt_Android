package mobilne.programownanie.projekt.finanse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    public static final String KEY = "mobilne.programownanie.projekt.finanse.KEY";
    public static final String SCORE = "mobilne.programownanie.projekt.finanse.SCORE ";
    public static final String NICK = "mobilne.programownanie.projekt.finanse.NICK ";
    private  SharedPreferences prefNick;
    private String nick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >=11){
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
        setContentView(R.layout.menu);

        prefNick = getSharedPreferences(Menu.KEY, Context.MODE_PRIVATE);
        nick = prefNick.getString(NICK,"");
        if (nick.equals(""))
            setNick();

    }

    public void OpenLevelEasy(View view) {
        Intent intent = new Intent(this, Easy.class);
        startActivity(intent);
    }

    public void OpenLevelMedium(View view) {
        Intent intent = new Intent(this, Medium.class);
        startActivity(intent);
    }

    public void OpenLevelHard(View view) {
        Intent intent = new Intent(this, Hard.class);
        startActivity(intent);
    }

    public void OpenStatistics(View view) {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
    }


    public void setNick(){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        final EditText etNick = (EditText) alertLayout.findViewById(R.id.et_nick);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Podaj nick");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.setPositiveButton("Zapisz", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


                String nick = etNick.getText().toString();
                SharedPreferences.Editor editor = prefNick.edit();
                editor.putString(NICK, nick);
                editor.commit();

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }
}