import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import java.awt.*;
import java.io.IOException;
import java.util.*;

import MainElements.*;
import AppBarElements.*;

import javax.swing.*;


public class GymReservationTracker {

    private static final Logger log = LogManager.getLogger(GymReservationTracker.class);

    private final static int defaultWidth = 990;
    private final static int defaultHeight = 650;


    private static void createAndShowGUI() throws IOException {

        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.TRACE);


        final Title title = new Title("Stokrotka Gym Reservation", 35);

        StatsButton statsButton = null;
        InfoButton infoButton = null;

        MyActionListener myActionListener = new MyActionListener(infoButton, statsButton);


        statsButton = new StatsButton(myActionListener);
        infoButton = new InfoButton(myActionListener);

        final AppBar appBar = new AppBar(infoButton, title, statsButton);

        FetchData stokrotkaDataProvider = new FetchData();
        ArrayList<String[]> gymSlotsInfo = stokrotkaDataProvider.getGymSlotsInfo();
        String[] dayRow = gymSlotsInfo.get(0);
        String dayTitle = (dayRow[0].substring(0,1).toUpperCase() + dayRow[0].substring(1)) + ", " + dayRow[1] + " " + dayRow[2] + " " + dayRow[3];
        ArrayList<SlotLabel> slotLabels = new ArrayList<SlotLabel>();

        for(String[] slotInfo : gymSlotsInfo){
            if (slotInfo == dayRow){
                continue;
            }
            if (slotInfo[2].equals("rezerwuj")){
                slotInfo[2] = "Rezerwuj";
                slotInfo[3] = "termin";
            }
            System.out.println(slotInfo[0] + " " + slotInfo[1] + " " + slotInfo[2] + " " + slotInfo[3]);
            //SlotLabel slotLabel = new SlotLabel(slotInfo[0] + " - " + slotInfo[1] + "\n" + slotInfo[2] + " " + slotInfo[3]);
            SlotLabel slotLabel = new SlotLabel("<html><center>"+slotInfo[0] + " - " + slotInfo[1]+"<br/>"+ slotInfo[2] + " " + slotInfo[3] + "</center></html>", slotInfo[2]);
            slotLabels.add(slotLabel);

        }

        ListPane listPane = new ListPane(slotLabels);
        JScrollPane scrollPane = new JScrollPane(listPane);
        scrollPane.setPreferredSize(new Dimension(defaultWidth-80,defaultHeight-60));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(listPane);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);


        final MainScreen mainScreen = new MainScreen(defaultWidth, defaultHeight, scrollPane, dayTitle);


        MainAppWindow mainAppWindow = new MainAppWindow("Gym Reservation Tracker", mainScreen, appBar);


    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}