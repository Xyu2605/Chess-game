package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public class Queen extends Piece{
    
    public Queen(Color pieceColor){
        super(pieceColor, "q");
    }

    @Override
    public List<Move> getValidMoves(Board board, int startRow, int starCol){
        List<Move> validMoves = new ArrayList<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {-1, 1}, {1,1}, {1, -1}};
        for(int[] direction : directions){
            int endRow = starRow + direction[0];
            int endCol = starCol + direction[1];
            while (Utils.isMoveAllowed(board, pieceColor, endRow, endRow)) {
                validMoves.add(new Move(starRow, starCol, endRow, endCol));
                if(!Utils.isEmpty(board, endRow, endCol)){
                    break;
                }
                endRow += direction[0];
                endRow += direction[1];
            }
        }
        return validMoves;
    }
}
