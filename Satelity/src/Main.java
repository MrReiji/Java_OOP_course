import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Flysat flysat = new Flysat("https://flysat.com/en/satellitelist");
        System.out.println(flysat.getSatellites());
    }
}
