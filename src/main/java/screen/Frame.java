package screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static final int WIDTH = 606, HEIGHT = 594;
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
