package com.github.diinisalma.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class King extends Piece {

    public King(Point currPosition, PieceColor color) {
        super(currPosition, color);
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        List<Point> moves = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Point newPosition = new Point(currPosition.getX() + i, currPosition.getY() + j);
                if (isValidMove(newPosition)) {
                    moves.add(newPosition);
                }
            }
        }
        return moves;
    }

    @Override
    public String getPieceConstant() {
        return Board.KING;
    }

    @Override
    public Piece killingMove(Point nextPosition) {
        List<Point> validKillingMove = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Point newPosition = new Point(currPosition.getX() + i, currPosition.getY() + j);
                validKillingMove.add(newPosition);
            }
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
