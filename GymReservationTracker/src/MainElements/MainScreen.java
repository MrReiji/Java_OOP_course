package MainElements;

import AppBarElements.Title;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {

    public MainScreen(int defaultWidth, int defaultHeight, JScrollPane scrollPane,String dayTitle){
        this.setPreferredSize(new Dimension(defaultWidth, defaultHeight));
        this.setOpaque(false);
        Title subTitle = new Title(dayTitle, 25);
        this.add(subTitle,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

    }
        final ImageIcon backgroundImage = new ImageIcon("src/ICON/gym.jpg");
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth(), h = getHeight();
            g2d.drawImage(backgroundImage.getImage(), 0, 0, this);
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
            g2d.setColor(new Color(70,194,218,180));
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
        }
    };


