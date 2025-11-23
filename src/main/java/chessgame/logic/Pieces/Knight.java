package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public class Knight extends Piece{

    public Knight(Color piceColor){
        super(piceColor, "kn");
    }

    @Override
    public List<Move> getValidMoves(Board board, int startRow, int startCol){
        List<Move> move = new ArrayList<>();
        int[][] directions = {
            {-2,-1}, {-2, 1}, {-1, 2},
            {1, 2},           {2, 1},
            {2,-1}, {1, -2},  {-1,-2}
        };
        for(int[] direction : directions){
            int endRow = direction[0];
            int endCol = direction[1];
            if(Utils.isMoveAllowed(board, pieceColor, endRow, endCol)){
                move.add(new Move(startRow, startCol, endRow, endCol));
            }
        }
        return move;
    }
}
