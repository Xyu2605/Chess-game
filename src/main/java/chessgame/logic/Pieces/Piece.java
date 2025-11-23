package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;
import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public abstract class Piece {
    public enum Color{
        WHITE,
        BLACk
    }

    protected Color pieceColor;
    protected String name;
    protected boolean hasMove = false;

    Piece(Color color, String name){
        this.pieceColor = color;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Color getColor(){
        return this.pieceColor;
    }

    @Override
    public String toString(){
        return this.name.toUpperCase() + " " + this.pieceColor;
    }

    public abstract List<Move> getValidMoves(Board board, int startRow, int startCol);

    public List<Move> getSafeMoves(Board board, int startRow, int startCol) {
        List<Move> safeMoves = new ArrayList<>(); 
        for(Move move : getValidMoves(board, startRow, startCol)){
            if(Utils.isSafeMove(board, pieceColor, move)){
                safeMoves.add(move);
            }
        }
        return safeMoves;
    }

    public boolean canAtack(Board board, int row, int col, int targetRow, int targetCol){
        for(Move move : getValidMoves(board, row, col)){
            if(move.getEndRow()==targetRow && move.getEndCol()==targetCol){
                return true;
            }
        }
        return false;
    }

}
