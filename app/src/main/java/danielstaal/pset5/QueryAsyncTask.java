package danielstaal.pset5;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Daniël on 18-5-2016.
 */
public class QueryAsyncTask extends AsyncTask<String, Integer, String>{

    Context context;
    MainActivity activity;

    public QueryAsyncTask(MainActivity activity){
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Getting data from server", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params){
        return HTTPRequestHelper.downloadFromServer(params);
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);

        if(result.length() == 0){
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }
        else{
            MovieData movie = null;
            try {
                // response object
                JSONObject movieObj = new JSONObject(result);
                String title = movieObj.getString("Title");
                String runtime = movieObj.getString("Runtime");
                String imdbRating = movieObj.getString("imdbRating");
                movie = new MovieData(title, runtime, imdbRating);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.activity.set_data(movie);
        }
    }
}
