package GameEngine;

import Units.Unit;
public class Square
{
    private Coordinates coordinates;

    private Unit unit = null;
/** Tworzymy nowe pole  */
    public Square(Coordinates coordinates, Unit unit) {
        this.coordinates = coordinates;
        this.unit = unit;
    }

    public Square(Coordinates coordinates)
    {
        this(coordinates, null);
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }
    public Unit getUnit()
    {
        return unit;
    }

    public boolean equals(Square square)
    {
        if(square.getCoordinates().equals(coordinates))
            return true;
        return false;
    }

    public boolean isOccupied()
    {
        if(unit == null)
        {
            return false;
        }
        return true;
    }

    public String getUnitString() {
        if (unit == null) {
            return "  ";
        }
        return unit.toString();
    }

    public void releaseUnit()
    {
        unit = null;
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }
}
