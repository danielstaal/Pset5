package danielstaal.pset5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Daniël on 20-5-2016.
 */
public class MovieAdapter extends BaseAdapter {
    private Context context;
    private MovieData movie;
    private ArrayList<String> data = new ArrayList<>();

    public MovieAdapter(Context context, MovieData movie){
        this.context = context;
        this.movie = movie;
        data.add(movie.getTitle());
        data.add(movie.getRuntime());
        data.add(movie.getRating());
    }

    @Override
    public int getCount(){
        return this.data.size();
    }

    public Object getItem(int arg0){return null;}

    public long getItemId(int pos){return pos;}

    public View getView(int pos, View view, ViewGroup parent){
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_layout, parent, false);
        }
        String info = data.get(pos);
        TextView infoText = (TextView) view.findViewById(R.id.info);
        infoText.setText(info);
        return view;
    }
}
