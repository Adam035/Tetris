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

    private void translate(int dx, int dy) {
        units.forEach(u -> u.translate(dx, dy));
    }


    public void move(int dx, int dy) {
        if (canMove(dx)) translate(dx, dy);
    }

    private boolean canMove(int dx) {
        return units.stream()
                .allMatch(u -> {
                    boolean left = u.getX() + dx >= 0;
                    boolean right = u.getX() + dx <= 17 * Unit.SIZE;
                    return left && right;
                });
    }

    protected void fixPosition() {
        List<Integer> positions = units.stream()
                .map(Unit::getX)
                .toList();
        fixMin(positions);
        fixMax(positions);
    }

    private void fixMin(List<Integer> positions) {
        assert positions.size() > 0;
        int min = positions.stream()
                .min(Integer::compareTo).get();
        if (min < 0) translate(1, 0);
    }

    private void fixMax(List<Integer> positions) {
        assert positions.size() > 0;
        int max = positions.stream()
                .max(Integer::compareTo).get();
        if (max > 17 * Unit.SIZE) translate(-1, 0);
    }

    public void rotate() {
        angle += Math.PI / 2;
        angle = angle % (2 * Math.PI);
    }

    public void paint(Graphics g) {
        units.forEach(unit -> unit.paint(g));
    }

}
