package chessgame.logic.Pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.logic.Board;
import chessgame.logic.Move;
import chessgame.logic.Utils;

public class Pawn extends Piece {
    public Pawn(Color pieceColor) {
        super(pieceColor, "p");
    }

    @Override
    public List<Move> getValidMoves(Board board, int startRow, int startCol) {
        List<Move> validMoves = new ArrayList<>();
        int direction = (pieceColor.equals(Color.WHITE)) ? -1 : 1;

        if (Utils.isEmpty(board, startRow + direction, startCol)) {
            validMoves.add(new Move(startRow, startCol, startRow + direction, startCol));
            int initialRow = (pieceColor.equals("w")) ? 6 : 1;
            if (startRow == initialRow && Utils.isEmpty(board, startRow + 2 * direction, startCol)) {
                validMoves.add(new Move(startRow, startCol, startRow + 2 * direction, startCol));
            }
        }
        
        // Bắt chéo
        for (int offset : new int[]{-1, 1}) {
            int endCol = startCol + offset;
            if (Utils.isMoveAllowed(board, pieceColor, startRow + direction, endCol) 
                && !Utils.isEmpty(board, startRow + direction, endCol)) {
                validMoves.add(new Move(startRow, startCol, startRow + direction, endCol));
            }
        }

        // logic tốt qua đường
        Move enPassantMove = Utils.canEnPassant(board, pieceColor, startRow, startCol);
        if(enPassantMove != null){
            validMoves.add(enPassantMove);
        }

        return validMoves; 
    }
}
