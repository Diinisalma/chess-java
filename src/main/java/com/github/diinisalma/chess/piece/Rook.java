package com.github.diinisalma.chess.piece;

import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class Rook extends Piece {

    public Rook(Point currPosition, PieceColor color) {
        super(currPosition, color);
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableMoves'");
    }

    @Override
    public String getPieceConstant() {
        return Board.ROOK;
    }

    @Override
    public boolean move(Point position, PieceColor color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

}
