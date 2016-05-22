package danielstaal.pset5;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Daniël on 18-5-2016.
 */
public class HTTPRequestHelper {
    private static final String url1 = "http://www.omdbapi.com/?t=";

    protected static synchronized String downloadFromServer(String... params){

        String result = "";

        String chosenQuery = params[0];

        chosenQuery = chosenQuery.replaceAll("\\s","+");

        String complete_URL_string = url1 + chosenQuery;

        URL url = null;
        try {
            url = new URL(complete_URL_string);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection;
        if(url != null) {
            try {
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");

                Integer responseCode = connection.getResponseCode();

                if (responseCode >= 200 && responseCode <= 299) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
