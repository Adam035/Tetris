package blocks;

public class SBlock extends Block {

    public SBlock() {
        addUnit(new Unit(8, -3));
        addUnit(new Unit(8 , -2));
        addUnit(new Unit(9, -2));
        addUnit(new Unit(9 , -1));
    }

    @Override
    public void rotate() {
        super.rotate();
        int cos = (int) Math.signum((int) Math.cos(2 * getAngle()));
        getUnits().get(0).translate(0, -2 * cos);
        getUnits().get(3).translate(2 * cos, 0);
        fixPosition();
    }
}
