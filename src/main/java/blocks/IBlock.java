package blocks;

public class IBlock extends Block {

    public IBlock() {
        addUnit(new Unit(7, -1));
        addUnit(new Unit(8, -1));
        addUnit(new Unit(9, -1));
        addUnit(new Unit(10, -1));
    }

    @Override
    public void rotate() {
        super.rotate();
        getUnits().get(0).translate(-2 * Math.cos(2 * getAngle()),2 * Math.cos(2 * getAngle()));
        getUnits().get(1).translate(-Math.cos(2 * getAngle()), Math.cos(2 * getAngle()));
        getUnits().get(3).translate(Math.cos(2 * getAngle()), -Math.cos(2 * getAngle()));
        fixPosition();
        fixPosition();
    }
}
