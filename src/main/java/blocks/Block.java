package blocks;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Block {
    @Getter
    private final List<Unit> units;
    @Getter
    private double angle;
    private final Color color;

    public Block() {
        units = new ArrayList<>();
        Random random = new Random();
        int red = random.nextInt(0, 256);
        int green = random.nextInt(0, 256);
        int blue = random.nextInt(0,256);
        color = new Color(red, green, blue);
        angle = 0;
    }

    public void addUnit(Unit unit) {
        unit.setColor(color);
        units.add(unit);
    }


    public void translate(int dx, int dy) {
        units.forEach(u -> u.translate(dx, dy));
    }

    public void rotate() {
        angle += Math.PI / 2;
        angle = angle % (2 * Math.PI);
    }

    public void paint(Graphics g) {
        units.forEach(unit -> unit.paint(g));
    }

}
