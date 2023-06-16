package GameEngine;

import java.util.ArrayList;
import java.util.List;

import Units.*;
import Players.PlayerType;
public class Manager
{
    private static Board board;

    private static PlayerType currentPlayer = PlayerType.France;

    private List<Move> moveList = new ArrayList<Move>();

    public Manager()
    {
        this.board = new Board();
    }

    public void resetBoard()
    {
        moveList = new ArrayList<Move>();
        board.resetBoard();
        currentPlayer = PlayerType.France;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == PlayerType.France) {
            currentPlayer = PlayerType.Russia;
        } else {
            currentPlayer = PlayerType.France;
        }

    }

    public static PlayerType getCurrentPlayer()
    {
        return currentPlayer;
    }

    public List<Move> getMoveList()
    {
        return moveList;
    }

    public static Board getBoard()
    {
        return board;
    }

    public Square[] getValidMoves(Coordinates coordinates) {
        List<Square> moves = new ArrayList<Square>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isValidMove(board.getSquare(coordinates),
                        board.getSquares()[x][y])) {
                    moves.add(board.getSquares()[x][y]);
                }
            }
        }
        return moves.toArray(new Square[0]);
    }

    public Square[] getAttackingUnits(PlayerType player) {
        List<Square> squares = new ArrayList<Square>();
        Square[][] allSquares = board.getSquares();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square tmpSquare = allSquares[x][y];
                if (tmpSquare.isOccupied()) {
                    squares.add(tmpSquare);
                }

            }
        }
        return squares.toArray(new Square[0]);
    }

    public boolean move(Coordinates initCoordinate, Coordinates finalCoordinate) {
        if(initCoordinate==null || finalCoordinate==null){return false;}
        // Only valid coordinates are allowed.
        if (!(initCoordinate.isValid() && finalCoordinate.isValid())) {
            return false;
        }
        Square s1 = board.getSquare(initCoordinate);
        Square s2 = board.getSquare(finalCoordinate);
        //Checks for sane moves.
        if(!isSaneMove(s1,s2)){return false;}
        // Only the current player can move the piece.
        if (currentPlayer == s1.getUnit().getPlayer()) {
            if (isValidMove(s1, s2)) {
                switchCurrentPlayer();
                moveList.add(new Move(s1.getCoordinates(), s2.getCoordinates(),
                        s1.getUnit(), s1));
                board.makeMove(s1, s2);
                return true;
            }
        }
        return false;
    }

    private boolean hasPieceMoved(Square square) {
        for (Move move : moveList) {
            if (move.getInitCoordinates() == square.getCoordinates()
                    || move.getFinalCoordinates() == square.getCoordinates()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPathClear(Coordinates[] path, Coordinates initCoordinate, Coordinates finalCoordinate)
    {
        Square[][] squares = board.getSquares();
        for (Coordinates coordinate : path) {
            if ((squares[coordinate.getX()][coordinate.getY()].isOccupied())
                    && (!coordinate.equals(initCoordinate))
                    && (!coordinate.equals(finalCoordinate))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSaneMove(Square initSquare, Square finalSquare) {
        //Check if the coordinates are valid
        if(!initSquare.getCoordinates().isValid() || !initSquare.getCoordinates().isValid() )
        {
            return false;
        }
        // If the player tries to move a empty square.
        if (!initSquare.isOccupied()) {
            return false;
        }
        // If it is moving to the same square.
        // This is also checked by every piece but still for safety
        if (initSquare.equals(finalSquare)) {
            return false;
        }

        return true;
    }

    private boolean isValidMovement(Square initSquare, Square finalSquare) {
        if(!isSaneMove(initSquare,finalSquare)){
            return false;
        }
        // If the player tries to take his own piece.
        if (finalSquare.isOccupied()) {
            if (initSquare.getUnit().getPlayer() == finalSquare.getUnit()
                    .getPlayer())
                return false;
        }
        // Check all movements here. Normal Moves, Pawn Captures and Enpassant.
        // Castling are handled by the move function itself.
        // If the piece cannot move to the square. No such movement.
        if (!initSquare.getUnit().isValidMove(initSquare.getCoordinates(),
                finalSquare.getCoordinates())) {
            return false;
        }
        if (initSquare.getUnit().getType() == UnitType.Kawaleria
                && finalSquare.isOccupied()) {
            return false;
        }

        // If piece is blocked by other pieces
        Coordinates[] path = initSquare.getUnit().getPath(
                initSquare.getCoordinates(), finalSquare.getCoordinates());
        if (!isPathClear(path, initSquare.getCoordinates(),
                finalSquare.getCoordinates())) {
            return false;
        }
        return true;
    }

    public boolean isValidMove(Square initSquare, Square finalSquare)
    {
        if (!isValidMovement(initSquare, finalSquare)) {
            return false;
        }
        return true;
    }
}
