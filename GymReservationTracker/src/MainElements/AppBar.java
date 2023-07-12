package MainElements;

import javax.swing.*;
import java.awt.*;

public class AppBar extends JPanel {
    public AppBar(JButton infoButton, JLabel title, JButton statsButton){
        this.setBackground(new Color(34,96,137));
        this.add(infoButton);
        this.add(title);
        this.add(statsButton);
    }
}
