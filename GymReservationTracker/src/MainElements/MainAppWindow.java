package MainElements;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainAppWindow extends JFrame {
    public MainAppWindow(String title, MainScreen mainScreen, AppBar appBar){
        super.setTitle(title);
        super.setResizable(false);
        this.add(mainScreen, BorderLayout.CENTER);
        this.add(appBar, BorderLayout.NORTH);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
