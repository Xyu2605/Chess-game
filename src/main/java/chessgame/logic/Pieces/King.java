package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public class King extends Piece{

    private boolean hasMove = false;
    
    public King(Color pieceColor){
        super(pieceColor, "k");
    }

    public boolean isMove(){
        return hasMove;
    }

    public void setHasMoved(boolean hasMove){
        this.hasMove = hasMove;
    }

    public boolean getHasMoved(){
        return
    }

    @Override
    public List<Move> getValidMoves(Board board, int startRow, int starCol){
        List<Move> move = new ArrayList<>();
        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0, 1},
            {1, 1},  {1, 0}, {1, 1}
        };

        for( int[] direction : directions){
            int endRow = startRow + direction[0];
            int endCol = starCol + direction[1];
            if(Utils.isMoveAllowed(board, pieceColor, endRow, endCol)){
                move.add(new Move(startRow, starCol, endRow, endCol));
            }
        }
        return move;
    }

    public List<Move> getSafeMoves(Board board, int startRow, int startCol){
        List<Move> safeMoves = super.getSafeMoves(board, startRow, startRow);
        if(Utils.canCastleLeft(board, startRow, startCol, hasMove, pieceColor)){
            safeMoves.add(new Move(startRow, startCol, startRow, 2));
        }
        if(Utils.canCastleRight(board, startRow, startCol, hasMove, pieceColor)){
            safeMoves.add(new Move(startRow, startCol, startRow, 6));
        }
        return safeMoves;
    }

}
