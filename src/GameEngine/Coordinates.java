package GameEngine;

public class Coordinates
{
    int positionX;
    int positionY;

    public Coordinates(int x, int y)
    {
        positionX = x;
        positionY = y;
    }

    public Coordinates(String coordinates)
    {
        positionX = (char)coordinates.toCharArray()[0]-97;
        positionY = Integer.parseInt(coordinates.substring(1,2))-1;
    }

    public boolean isValid()
    {
        if((positionX >= 0 && positionX <= 8) && (positionY >= 0 && positionY < 8))
        {
            return true;
        }
        return false;
    }

    public int getX()
    {
        return positionX;
    }

    public int getY()
    {
        return positionY;
    }

    public String toString()
    {
        return Integer.toString(positionX) + "," + Integer.toString(positionY);
    }

    public boolean equals(Coordinates coordinates)
    {
        if ((positionX == coordinates.getX())
                && (positionY == coordinates.getY()))
        {
            return true;
        }
        return false;
    }

    public String getParsedCoordinates()
    {
        String parsedString = "";
        parsedString = (char) (positionX + 97) + Integer.toString(positionY + 1);
        return parsedString;
    }
}
