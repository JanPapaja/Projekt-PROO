package Units;

import Players.PlayerType;
import GameEngine.Coordinates;

public class Artyleria extends Unit
{
    public Artyleria(PlayerType player)
    {
        super(player,UnitType.Artyleria);
    }

    @Override
    public boolean isValidMove(Coordinates initPos,Coordinates finalPos) {
        if (initPos.equals(finalPos)){return false;}

        //You have not checked for castling
        if (   Math.abs(finalPos.getX()-initPos.getX())<=1
                && Math.abs(finalPos.getY()-initPos.getY())<=1 )
        {
            return true;
        }

        return false;
    }

    @Override
    public Coordinates[] getPath(Coordinates initPos,Coordinates finalPos) {
        return new Coordinates[]{initPos,finalPos};
    }
}
