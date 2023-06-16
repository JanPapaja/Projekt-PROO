package GameEngine;

import java.util.List;
public class MoveAnalizer
{
    private static String parseMove(Move move) {
        if (move.getInitCoordinates().equals(move.getFinalCoordinates())) {
            return move.getUnit().getType().toString();
        }
        return move.getInitCoordinates().getParsedCoordinates()
                + move.getFinalCoordinates().getParsedCoordinates();
    }
}
