package blocks;

public class LBlock extends Block {

    public LBlock() {
        addUnit(new Unit(8, -3));
        addUnit(new Unit(8, -2));
        addUnit(new Unit(8, -1));
        addUnit(new Unit(9, -1));
    }

    @Override
    public void rotate() {
        super.rotate();
        int dx = (int) Math.signum(Math.sin(getAngle() + Math.PI / 4));
        int dy = (int) Math.signum(Math.cos(getAngle() + Math.PI / 4));

        getUnits().get(0).translate(dx, -dy);
        getUnits().get(2).translate(-dx, dy);

        dx = (int) Math.signum((int) Math.sin(getAngle()));
        dy = (int) Math.signum((int) Math.cos(getAngle()));

        getUnits().get(3).translate(-2 * dx, 2 * dy);
        fixPosition();
    }
}
