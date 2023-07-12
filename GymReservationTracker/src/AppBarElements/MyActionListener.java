package AppBarElements;

import AppBarElements.InfoButton;
import AppBarElements.StatsButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyActionListener implements ActionListener {
    InfoButton infoButton;
    StatsButton statsButton;
    public MyActionListener(InfoButton infoButton, StatsButton statsButton){
        this.infoButton = infoButton;
        this.statsButton = statsButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(infoButton)) {
            System.out.println("TEEESESETST");
//            i++;
//            if (i == countries.length)
//                i = 0;
//            jlist.setSelectedIndex(i);
//            log.trace("[ActionListener]: NEXT Button");
//            return;
        }

    }
}
