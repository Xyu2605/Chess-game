package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public class Rook extends Piece{
    private boolean hasMove = false;

    public Rook(Color pieceColor){
        super(pieceColor, "r");
    }

    public boolean isMove(){
        return hasMove;
    }

    public void setHasMoved(boolean hasMove){
        this.hasMove = hasMove;
    }

    @Override
    public List<Move> getValidMoves(Board board, int startRow, int startCol){
        List<Move> validMoves = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] direction : directions){
            int endRow = startRow + direction[0];
            int endCol = startCol + direction[1];
            while(Utils.isMoveAllowed(board, pieceColor, endRow, endCol)){
                validMoves.add(new Move(startRow, startCol, endCol, endRow));
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
