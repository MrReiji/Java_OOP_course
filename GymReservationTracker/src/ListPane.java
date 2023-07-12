import AppBarElements.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListPane extends JPanel {
    public ListPane(ArrayList<SlotLabel> slotLabels) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));




        for (SlotLabel label :slotLabels){
            this.add(label);
            this.add(Box.createVerticalStrut(10));
        }
    }
}
