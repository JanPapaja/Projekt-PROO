package GameEngine;

import Units.*;
import Players.PlayerType;
public class Board
{
    private Square[][] squares=new Square[8][8];

    public Board()
    {
        setSquares();
        setFrenchUnits();
        setRussianUnits();
    }

    public void resetBoard()
    {
        setSquares();
        setFrenchUnits();
        setRussianUnits();
    }

    private void setSquares()
    {
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                squares[x][y] = new Square(new Coordinates(x,y));
            }
        }
    }

    private void setFrenchUnits()
    {
        squares[7][0].setUnit(new Artyleria(PlayerType.France));
        squares[4][0].setUnit(new Kawaleria(PlayerType.France));
        squares[0][0].setUnit(new Piechota(PlayerType.France));
    }

    private void setRussianUnits()
    {
        squares[7][7].setUnit(new Artyleria(PlayerType.Russia));
        squares[4][7].setUnit(new Kawaleria(PlayerType.Russia));
        squares[0][7].setUnit(new Piechota(PlayerType.Russia));
    }

    public Square[][] getSquares()
    {
        return squares;
    }

    public Square getSquare(Coordinates coordinates)
    {
        Square result=null;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(squares[x][y].getCoordinates().equals(coordinates))
                {
                    result=squares[x][y];
                }
            }
        }
        return result;
    }

    public void makeMove(Coordinates initCoordinates, Coordinates finalCoordinates)
    {
        makeMove(getSquare(initCoordinates), getSquare(finalCoordinates));
    }

    public void setUnit(Coordinates coordinates, Unit unit)
    {
        getSquare(coordinates).setUnit(unit);
    }

    public void captureUnit(Square square)
    {
        if(square.isOccupied())
        {
            square.releaseUnit();
        }
    }

    public void makeMove(Square initSquare,Square finalSquare){
        //Has a piece been captured;
        if(finalSquare.isOccupied())
        {
            captureUnit(finalSquare);
        }
        //Make the move
        finalSquare.setUnit(initSquare.getUnit());
        initSquare.releaseUnit();
    }
}
