package com.github.diinisalma.chess.piece;

import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class King extends Piece {

    public King(Point currPosition, PieceColor color) {
        super(currPosition, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getPieceConstant() {
        return Board.KING;
    }

    @Override
    public boolean move(Point position, PieceColor color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
