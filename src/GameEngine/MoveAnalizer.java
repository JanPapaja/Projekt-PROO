package GameEngine;

import java.util.List;
public class MoveAnalizer
{
    public static String parse(List<Move> moveList)
    {
        String parsedMoves = "";
        for(Move move : moveList)
        {
            if(parsedMove(move).lenght() != 1)
            {
                parsedMoves += " " + parseMove(move);
            }
            else
            {
                parsedMoves += parseMove(move);
            }
        }
        return ParsedMoves;
    }

    private static String parseMove(Move move) {
        if (move.getInitCoordinates().equals(move.getFinalCoordinates())) {
            return move.getUnit().getType().toString();
        }
        return move.getInitCoordinates().getParsedCoordinate()
                + move.getFinalCoordinates().getParsedCoordinate();
    }
}
