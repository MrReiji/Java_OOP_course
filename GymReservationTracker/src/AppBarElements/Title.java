package AppBarElements;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Title extends JLabel {
    public Title(String text, int size){
        super.setText(text);
        this.setFont(new Font("Arial Black", Font.BOLD, size));
        this.setForeground(new Color(0,0,0));
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.04);
        this.setFont(this.getFont().deriveFont(attributes));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}
