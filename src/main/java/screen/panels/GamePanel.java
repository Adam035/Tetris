package screen.panels;

import blocks.*;
import difficulty.Difficulty;
import grid.Grid;

import java.awt.event.KeyAdapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private final Grid grid;

    public GamePanel(Difficulty difficulty) {
        grid = new Grid();
        addBlock();
        setBackground(Color.darkGray);
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        requestFocusInWindow();
        startDropTimer(difficulty);
        start();
    }

    private void startDropTimer(Difficulty difficulty) {
        int delay = difficulty.getDelay();
        Timer dropTimer = new Timer(delay, e -> {
            grid.checkRows();
            if (grid.checkActive())
                grid.getActive().move(0, 1);
            else addBlock();
        });
        dropTimer.start();
    }

    private void start() {
        Timer timer = new Timer(0, this);
        timer.start();
    }

    private void addBlock() {
        Random random = new Random();
        switch (random.nextInt(0, 7)){
            case 0 -> grid.add(new OBlock());
            case 1 -> grid.add(new IBlock());
            case 2 -> grid.add(new LBlock());
            case 3 -> grid.add(new JBlock());
            case 4 -> grid.add(new TBlock());
            case 5 -> grid.add(new SBlock());
            case 6 -> grid.add(new ZBlock());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        grid.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE -> grid.getActive().rotate();
                case KeyEvent.VK_LEFT -> grid.getActive().move(-1, 0);
                case KeyEvent.VK_RIGHT -> grid.getActive().move(1, 0);
                case KeyEvent.VK_DOWN -> {
                    while (grid.checkActive())
                        grid.getActive().move(0, 1);
                }
            }
        }
    }

}
