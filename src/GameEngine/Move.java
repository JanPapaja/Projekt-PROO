package GameEngine;

import Units.Unit;
public class Move
{
    private Coordinates initCoordinates;
    private Coordinates finalCoordinates;
    private Unit unit;
    private Unit capturedUnit = null;
    private Coordinates captureCoordinates = null;

    public Move(Coordinates initCoordinates, Coordinates finalCoordinates, Unit unit)
    {
        this(initCoordinates, finalCoordinates, unit, null);
    }

    public Move(Coordinates initCoordinates, Coordinates finalCoordinates, Unit unit,Square captureSquare) {
        this.initCoordinates = initCoordinates;
        this.finalCoordinates = finalCoordinates;
        this.unit = unit;
        if(captureSquare!=null){
            this.capturedUnit=captureSquare.getUnit();
            this.captureCoordinates=captureSquare.getCoordinates();
        }
    }

    public Coordinates getInitCoordinates()
    {
        return initCoordinates;
    }

    public Coordinates getFinalCoordinate()
    {
        return finalCoordinates;
    }

    public Unit getUnit()
    {
        return unit;
    }

    public boolean isCapture()
    {
        if (capturedUnit==null){return false;}
        return true;
    }

    public Unit getCapturedUnit()
    {
        return capturedUnit;
    }

    public Coordinates getCaptureCoordinates()
    {
        return captureCoordinates;
    }
}
