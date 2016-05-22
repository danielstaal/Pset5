package danielstaal.pset5;

import java.util.ArrayList;

/**
 * Created by Daniël on 20-5-2016.
 */
public class MovieData {

    private String title;
    private String runtime;
    private String rating;

    public MovieData(String title, String runtime, String rating){
        super();
        this.title = "Title: " + title;
        this.runtime = "Runtime: " + runtime;
        this.rating = "Rating: " + rating;
    }

    public String getTitle(){
        return title;
    }

    public String getRuntime(){
        return runtime;
    }

    public String getRating(){
        return rating;
    }
}
