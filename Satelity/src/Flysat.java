import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Flysat extends Webpages {
    public Flysat(String url) {
        super(url);
    }



    @Override
    public Elements getSatellites() throws IOException {
        Document doc = Jsoup.connect(this.getUrl()).get();
        Elements toReturn = doc.select("td a[href*=https://flysat.com/en/satellite/]");
        return toReturn;
    }
}
