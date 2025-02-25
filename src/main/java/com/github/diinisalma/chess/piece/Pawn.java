package com.github.diinisalma.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class Pawn extends Piece {

    public Pawn(Point currPosition, PieceColor color) {
        super(currPosition, color);
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        List<Point> moves = new ArrayList<>();
        if (PieceColor.W.equals(color)) {
            moves.add(new Point(currPosition.getX() + 1, currPosition.getY()));

            if (null == prevPosition) {
                moves.add(new Point(currPosition.getX() + 2, currPosition.getY()));
            }
        } else {
            moves.add(new Point(currPosition.getX() - 1, currPosition.getY()));

            if (null == prevPosition) {
                moves.add(new Point(currPosition.getX() - 2, currPosition.getY()));
            }
        }
        return moves;
    }

    @Override
    public String getPieceConstant() {
        return Board.PAWN;
    }

    @Override
    public boolean move(Point position, PieceColor color) {
        if (!alive) {
            System.out.println("Piece is dead");
            return false;
        }

        if (getAvailableMoves(currPosition).contains(position)) {
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }

}
