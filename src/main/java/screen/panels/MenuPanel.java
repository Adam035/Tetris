package screen.panels;

import difficulty.Difficulty;
import screen.Frame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    private static final int WIDTH = Frame.WIDTH, HEIGHT = Frame.HEIGHT;
    private final Frame frame;
    private final JComboBox<Difficulty> comboBox;

    public MenuPanel(Frame frame) {
        this.frame = frame;
        setFocusable(true);
        setLayout(null);
        setVisible(true);

        Difficulty[] options = {Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD};
        comboBox = new JComboBox<>(options);
        comboBox.setBounds((WIDTH / 2) + 20, (HEIGHT / 2) - 40, 80, 30);
        add(comboBox);

        JButton playButton = new JButton("Play");
        playButton.setBounds((WIDTH / 2) - 100, (HEIGHT / 2) - 40, 80, 30);
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        add(playButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Difficulty difficulty = (Difficulty) comboBox.getSelectedItem();
        assert difficulty != null;
        GamePanel gamePanel = new GamePanel(difficulty);
        frame.setContentPane(gamePanel);
        gamePanel.requestFocusInWindow();
        frame.revalidate();
    }

}
