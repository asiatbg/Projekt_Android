package mobilne.programownanie.projekt.finanse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "QuestionAnswer.db";
    //table name
    private static final String TABLE_NAME = "question_answer_table";
    //columns name
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer"; //correct answer
    private static final String KEY_OPTION1 = "option1";
    private static final String KEY_OPTION2 = "option2";
    private static final String KEY_OPTION3 = "option3";

    private SQLiteDatabase dbase;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTION1 + " TEXT, "
                + KEY_OPTION2 + " TEXT, "+ KEY_OPTION3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    // Adding new question
    public long addQuestion(Question quest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTION1, quest.getOption(0));
        values.put(KEY_OPTION2, quest.getOption(1));
        values.put(KEY_OPTION3, quest.getOption(2));

        // Inserting Row
        long insert = db.insert(TABLE_NAME, null, values);
        return insert;
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        dbase = this.getReadableDatabase();

        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();

                String questText = cursor.getString(cursor.getColumnIndex(KEY_QUESTION));
                quest.setQUESTION(questText);

                String option1Text = cursor.getString(cursor.getColumnIndex(KEY_OPTION1));
                quest.setOption(0,option1Text);

                String option2Text = cursor.getString(cursor.getColumnIndex(KEY_OPTION2));
                quest.setOption(1,option2Text);

                String option3Text = cursor.getString(cursor.getColumnIndex(KEY_OPTION3));
                quest.setOption(2,option3Text);

                String answerText = cursor.getString(cursor.getColumnIndex(KEY_ANSWER));
                quest.setANSWER(answerText);

                quesList.add(quest);
            } while (cursor.moveToNext());

            //mixing list of question (no answer)
            Collections.shuffle(quesList);
        }
        // return quest list
        return quesList;
    }
}
