package mobilne.programownanie.projekt.finanse;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >=11){
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        ( (TransitionDrawable) imageView.getDrawable()).startTransition(3000);

        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}
