import screen.Frame;
import screen.panels.MenuPanel;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        MenuPanel menuPanel = new MenuPanel(frame);
        frame.add(menuPanel);
        frame.setVisible(true);
    }
}
