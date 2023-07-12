import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Webpages {
    public static final int NULL = 255;
    
    private String url = ""; //Probably change to URL class from jsoup or standard java lib

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private ArrayList<Satellite> satellites = null;

    public abstract Elements getSatellites () throws IOException;

    public Webpages(String url) {
        this.url = url;
    }

    
}
