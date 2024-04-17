package blocks;

public class ZBlock extends Block {

    public ZBlock() {
        addUnit(new Unit(9, -3));
        addUnit(new Unit(9, -2));
        addUnit(new Unit(8, -2));
        addUnit(new Unit(8, -1));
    }

    @Override
    public void rotate() {
        super.rotate();
        int cos = (int) Math.signum((int) Math.cos(2 * getAngle()));
        getUnits().get(0).translate(0, -2 * cos);
        getUnits().get(1).translate(2 * cos, 0);
    }

}
