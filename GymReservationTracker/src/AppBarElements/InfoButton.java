package AppBarElements;

import javax.swing.*;
import java.awt.*;

public class InfoButton extends JButton {
    final ImageIcon infoImage = new ImageIcon("src/ICON/information.png");
    public InfoButton(MyActionListener myActionListener){
        this.setIcon(infoImage);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.addActionListener(myActionListener);
    }
}
