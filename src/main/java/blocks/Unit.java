package blocks;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
public class Unit {
    public static final int SIZE = 33;
    private int x, y;
    @Setter
    private Color color;

    public Unit(int x, int y) {
        this.x = x * SIZE;
        this.y = y * SIZE;
    }

    public void translate(double dx, double dy) {
        x += dx * SIZE;
        y += dy * SIZE;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }
}
