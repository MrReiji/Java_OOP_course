package AppBarElements;

import javax.swing.*;
import java.awt.*;

public class StatsButton extends JButton {
    final ImageIcon statsImage = new ImageIcon("src/ICON/stats.png");
    public StatsButton(MyActionListener myActionListener) {
        this.setIcon(statsImage);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        //this.addActionListener(myActionListener);
    }
}
