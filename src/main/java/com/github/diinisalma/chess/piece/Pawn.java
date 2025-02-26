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
            Point newPosition = new Point(currPosition.getX() + 1, currPosition.getY());
            if (isValidMove(newPosition)) {
                moves.add(newPosition);
            }

            if (null == prevPosition) {
                newPosition = new Point(currPosition.getX() + 2, currPosition.getY());
                if (isValidMove(newPosition)) {
                    moves.add(newPosition);
                }
            }
        } else {
            Point newPosition = new Point(currPosition.getX() - 1, currPosition.getY());
            if (isValidMove(newPosition)) {
                moves.add(newPosition);
            }

            if (null == prevPosition) {
                newPosition = new Point(currPosition.getX() - 2, currPosition.getY());
                if (isValidMove(newPosition)) {
                    moves.add(newPosition);
                }
            }
        }
        return moves;
    }

    @Override
    public String getPieceConstant() {
        return Board.PAWN;
    }

    @Override
    public Piece killingMove(Point nextPosition) {
        List<Point> validKillingMove = new ArrayList<>();
        if (PieceColor.W.equals(color)) {
            validKillingMove.add(new Point(currPosition.getX() + 1, currPosition.getY() + 1));
            validKillingMove.add(new Point(currPosition.getX() + 1, currPosition.getY() - 1));
        } else {
            validKillingMove.add(new Point(currPosition.getX() - 1, currPosition.getY() + 1));
            validKillingMove.add(new Point(currPosition.getX() - 1, currPosition.getY() - 1));
        }

        if (validKillingMove.contains(nextPosition)) {
            this.setPrevPosition(currPosition);
            this.setCurrPosition(nextPosition);
        } else {
            System.out.println("Invalid move");
        }
        return this;
    }

}
