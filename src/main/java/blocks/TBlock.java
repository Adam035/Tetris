package blocks;

public class TBlock extends Block{

    public TBlock() {
        addUnit(new Unit(8, -3));
        addUnit(new Unit(8, -2));
        addUnit(new Unit(8, -1));
        addUnit(new Unit(9, -2));
    }

    @Override
    public void rotate() {
        super.rotate();
        int dx = (int) Math.signum(Math.sin(getAngle() + Math.PI / 4));
        int dy = (int) Math.signum(Math.cos(getAngle() + Math.PI / 4));

        getUnits().get(0).translate(dx, -dy);
        getUnits().get(2).translate(-dx, dy);

        dx = (int) Math.signum(Math.cos(getAngle() + Math.PI / 4));
        dy = (int) Math.signum(Math.sin(getAngle() + Math.PI / 4));

        getUnits().get(3).translate(dx, -dy);
    }
}
