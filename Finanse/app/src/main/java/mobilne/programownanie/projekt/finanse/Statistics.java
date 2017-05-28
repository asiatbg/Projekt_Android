package mobilne.programownanie.projekt.finanse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Statistics extends AppCompatActivity {

    private static final String TAG_TABLE_NAME ="server_response";
    private static final String TAG_NICK = "nick";
    private static final String TAG_SCORES ="wyniki";
    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    ListView list;
    String myJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 11) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
        setContentView(R.layout.activity_statistics);
        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String,String>>();
        if(isNetworkAvailable())
        {
            getData();
        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Błąd!");
            alertDialogBuilder
                    .setMessage("Nie można uzyskać połączenia z internetem. Nie możesz zobaczyć statystyk.")
                    .setCancelable(false)
                    .setPositiveButton("Zrozumiałem",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON); //err
            peoples = jsonObj.getJSONArray(TAG_TABLE_NAME);

            for(int i=0;i<peoples.length();i++){
                JSONObject c = peoples.getJSONObject(i);

                String name = c.getString(TAG_NICK);
                String address = c.getString(TAG_SCORES);

                HashMap<String,String> persons = new HashMap<String,String>();


                persons.put(TAG_NICK,name);
                persons.put(TAG_SCORES,address);

                personList.add(persons);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Statistics.this, personList, R.layout.list_item,
                    new String[]{TAG_NICK, TAG_SCORES},
                    new int[]{ R.id.name, R.id.address}
            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://v-ie.uek.krakow.pl/~s186883/json_get_data.php");


                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                   e.printStackTrace();
                }
                finally {
                    try{
                        if(inputStream != null)
                            inputStream.close();
                    }catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
