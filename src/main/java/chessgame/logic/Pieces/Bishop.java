package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Utils;
import chessgame.logic.Move;

public class Bishop extends Piece{
    
    public Bishop(Color pieceColor){
        super(pieceColor, "b");
    }

    @Override
    public List<Move> getValidMoves(Board board, int starRow, int starCol){
        List<Move> validMoves = new ArrayList<>();
        int[][] directions = {{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] direction : directions){
            int endRow = starRow + direction[0];
            int endCol = starCol + direction[1];
            while (Utils.isMoveAllowed(board, pieceColor, endRow, endCol)) {
                validMoves.add(new Move(starRow, starCol, endRow, endCol));
                if(!Utils.isEmpty(board, endRow, endCol)){
                    break;
                }
                endRow += direction[0];
                endCol += direction[1];
            }
        }
        return validMoves;
    }
}
