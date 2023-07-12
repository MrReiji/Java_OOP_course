import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
https://jsoup.org/download
jsoup-1.15.3.jar core library
jsoup-1.15.3-sources.jar optional sources jar
jsoup-1.15.3-javadoc.jar optional javadoc jar
*/


public class Lyngsat0 {

	private final static String url = "https://www.lyngsat.com";

	public static void main(String[] args) throws IOException {
        
        // Parse the web page
		Document doc = Jsoup.connect(url).get();
        
        System.out.println(doc);
	}        

}


