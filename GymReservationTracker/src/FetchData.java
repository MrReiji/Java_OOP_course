import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FetchData {

    Properties loginProperties = new Properties();
    FileReader reader = new FileReader("src/login.properties");
    Connection.Response res;
    Document gymPage;
    Map<String, String> cookies;
    ArrayList<String[]> gymSlotsInfo = new ArrayList<String[]>();


    public FetchData() throws IOException {

        loginProperties.load(reader);


        res = Jsoup
                .connect("https://panel.dsnet.agh.edu.pl/login_check")
                .data("_username", loginProperties.getProperty("username"), "_password", loginProperties.getProperty("password"))
                .method(Connection.Method.POST)
                .execute();

        cookies = res.cookies();


        gymPage = Jsoup.connect("https://panel.dsnet.agh.edu.pl/reserv/rezerwuj/2889").cookies(cookies).get();

    }

    public ArrayList<String[]> getGymSlotsInfo() throws IOException {
        Elements rowContent = gymPage.getElementsByClass("table reservation general table-sm single ").first().getElementsByTag("tr");
        for (
                Element elem : rowContent) {
            String[] e = elem.text().split(" ");
            gymSlotsInfo.add(e);
        }
        return gymSlotsInfo;
    }
}
