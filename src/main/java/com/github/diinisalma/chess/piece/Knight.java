package com.github.diinisalma.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class Knight extends Piece {
    int[][] movementRules = {
            { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 },
            { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }
    };

    public Knight(Point currPosition, PieceColor color) {
        super(currPosition, color);
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        List<Point> moves = new ArrayList<>();
        // Get current position
        int x = currPosition.getX();
        int y = currPosition.getY();

        for (int[] movement : movementRules) {
            Point newPosition = new Point(x + movement[0], y + movement[1]);
            if (isValidMove(newPosition)) {
                moves.add(newPosition);
            }
        }
        return moves;
    }

    @Override
    public String getPieceConstant() {
        return Board.KNIGHT;
    }

    @Override
    public Piece killingMove(Point nextPosition) {
        List<Point> moves = new ArrayList<>();
        // Get current position
        int x = currPosition.getX();
        int y = currPosition.getY();

        for (int[] movement : movementRules) {
            Point newPosition = new Point(x + movement[0], y + movement[1]);
            if (isValidKillingMove(newPosition)) {
                moves.add(newPosition);
            }
        }

        if (moves.contains(nextPosition)) {
            this.setPrevPosition(currPosition);
            this.setCurrPosition(nextPosition);
        } else {
            System.out.println("Invalid move");
        }

        return this;
    }

}
