package Units;

import Players.PlayerType;
import GameEngine.Coordinates;
/** @author Papaja */
public abstract class Unit
{
    private UnitType type;
    private PlayerType player;

    public Unit(PlayerType player, UnitType type)
    {
        this.type = type;
        this.player = player;
    }

    public String toString()
    {
        return player.toString() + type.toString();
    }

    public PlayerType getPlayer()
    {
        return player;
    }

    public UnitType getType()
    {
        return type;
    }

    public abstract boolean isValidMove(Coordinates initPos, Coordinates finalPos);

    public abstract Coordinates[] getPath(Coordinates initPos,Coordinates finalPos);
}
