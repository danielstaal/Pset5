package danielstaal.pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText query_input;
    ListView movie_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        query_input = (EditText) findViewById(R.id.query);
        movie_listview = (ListView) findViewById(R.id.movie_data);
    }

    public void get_data(View view){
        String input = query_input.getText().toString();

        QueryAsyncTask asyncTask = new QueryAsyncTask(this);
        asyncTask.execute(input);
    }

    public void set_data(MovieData movie){
        MovieAdapter adapter = new MovieAdapter(this, movie);
        movie_listview.setAdapter(adapter);
    }

}
