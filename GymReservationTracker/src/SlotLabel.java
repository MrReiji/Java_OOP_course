import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SlotLabel extends JLabel {
    public SlotLabel(String text, String status){
        super.setText(text);
        this.setBorder(new EmptyBorder(5, 200, 5, 200));
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        if (status.equals("Termin")){
            this.setBackground(new Color(211,211,211,230));
        }
        else if (status.equals("Rezerwuj")){
            this.setBackground(new Color(0,255,0,230));
        }
        else{
            this.setBackground(new Color(255,13,26,230));
        }
    }
}
