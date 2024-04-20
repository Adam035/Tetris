package grid;

import blocks.Unit;
import lombok.Getter;
import blocks.Block;
import screen.Frame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static blocks.Unit.SIZE;

@Getter
public class Grid {
    private Block active;
    private final List<Unit> units;

    public Grid() {
        units = new ArrayList<>();
    }

    public void add(Block block) {
        if (active != null)
            units.addAll(active.getUnits());
        active = block;
    }

    public boolean checkActive() {
        return active.getUnits().stream()
                .allMatch(unit -> unit.getY() < Frame.HEIGHT - 2 * SIZE)
                && active.getUnits().stream()
                    .noneMatch(this::checkCollision);
    }

    private boolean checkCollision(Unit unit) {
        return units.stream()
                .anyMatch(u -> u.getX() == unit.getX()
                        && u.getY() == unit.getY() + SIZE);
    }

    public void checkRows() {
        for (int y = Frame.HEIGHT; y >= 0; y -= SIZE) {
            int finalY = y;
            List<Unit> row = units.stream()
                    .filter(unit -> unit.getY() == finalY)
                    .toList();
            if (row.size() == 18) deleteRow(row, finalY);
        }
    }

    private void deleteRow(List<Unit> row, int y) {
        units.removeAll(row);
        units.stream()
                .filter(unit -> unit.getY() < y)
                .forEach(unit -> unit.translate(0, 1));
    }

    public void paint(Graphics g) {
        paintTrack(g);
        active.paint(g);
        units.forEach(unit -> unit.paint(g));
        paintLines(g);
    }

    private void paintTrack(Graphics g) {
        g.setColor(new Color(60, 60, 60));
        active.getUnits()
                .forEach(u -> g.fillRect(u.getX(), u.getY(),
                        SIZE, screen.Frame.HEIGHT - u.getY()));
    }

    private void paintLines(Graphics g) {
        g.setColor(new Color(50, 50, 50));
        for (int i = 0; i < screen.Frame.WIDTH; i += SIZE) {
            g.drawLine(i, 0, i, screen.Frame.HEIGHT);
            g.drawLine(0, i, Frame.WIDTH, i);
        }
    }
}
