package mobilne.programownanie.projekt.finanse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import static mobilne.programownanie.projekt.finanse.Menu.SCORE;

public class Hard extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private QuestionBank questionBank = new QuestionBank();
    private final int TIME = 60000;
    private final int DELAY = 1000;
    private Button a, b, c;
    private String dbAnswer;
    private TextView question, scoreT, time;
    private int score;
    private Counter timer;
    private int questionNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >=11){
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
        setContentView(R.layout.hard);

        question = (TextView) findViewById(R.id.question);
        scoreT = (TextView) findViewById(R.id.score);
        time = (TextView) findViewById(R.id.time);
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        timer = new Counter(TIME, DELAY); //czas, opóźnienie

        sharedPreferences = getSharedPreferences(Menu.KEY, Context.MODE_PRIVATE);
        score = 0;
        scoreT.setText("Wynik: 0");
        time.setText("00:01:00");

        timer.start();

        questionBank.initQuestions(getApplicationContext());
        updateQuestion();


    }

    public void saveInPreferences(String KEY, int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY, value);
        editor.commit();
    }

    public void updateQuestion() {
        if (questionBank.getLength() > questionNumber) {
            question.setText(questionBank.getQuestionList(questionNumber));
            a.setText(questionBank.getOption(questionNumber, 1));
            b.setText(questionBank.getOption(questionNumber, 2));
            c.setText(questionBank.getOption(questionNumber, 3));
            dbAnswer = questionBank.getCorrectAnswer(questionNumber);

            questionNumber++;
        } else {
            timer.cancel();
            timer = null;
            Intent intent = new Intent(this, Result.class);
            saveInPreferences(SCORE, score);
            startActivity(intent);
            finish();
        }
    }

    public void getAnswerA(View view) {
        if (a.getText().equals(dbAnswer)){
            score++;
            scoreT.setText("Wynik: " + score);
        }
        updateQuestion();

    }

    public void getAnswerB(View view) {
        if (b.getText().equals(dbAnswer)){
            score++;
            scoreT.setText("Wynik: " + score);
        }
        updateQuestion();

    }

    public void getAnswerC(View view) {
        if (c.getText().equals(dbAnswer)){
            score++;
            scoreT.setText("Wynik: " + score);
        }
        updateQuestion();

    }

    class Counter extends CountDownTimer {

        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {

            Intent intent = new Intent(Hard.this, Result.class);
            saveInPreferences(SCORE, score);
            startActivity(intent);
            finish();

        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            time.setText(hms);
        }

    }
}
