package com.github.diinisalma.chess.piece;

import java.util.ArrayList;
import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public class Queen extends Piece {

    public Queen(Point currPosition, PieceColor color) {
        super(currPosition, color);
    }

    @Override
    List<Point> getAvailableMoves(Point currPosition) {
        List<Point> movements = new ArrayList<>();
        // Get the current position of the Rook
        int x = currPosition.getX();
        int y = currPosition.getY();

        // Check movements in the x-direction (left and right)
        for (int i = x - 1; i >= 0; i--) {
            Point newPosition = new Point(i, y);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            Point newPosition = new Point(i, y);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        // Check movements in the y-direction (up and down)
        for (int i = y - 1; i >= 0; i--) {
            Point newPosition = new Point(x, i);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            Point newPosition = new Point(x, i);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        // Diagonal moves
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            Point newPosition = new Point(i, j);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Up-right
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            Point newPosition = new Point(i, j);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Down-left
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            Point newPosition = new Point(i, j);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Down-right
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            Point newPosition = new Point(i, j);
            if (isValidMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        return movements;
    }

    @Override
    public String getPieceConstant() {
        return Board.QUEEN;
    }

    @Override
    public Piece killingMove(Point nextPosition) {
        List<Point> movements = new ArrayList<>();
        // Get the current position of the Bishop
        int x = currPosition.getX();
        int y = currPosition.getY();

        // Check movements in the x-direction (left and right)
        for (int i = x - 1; i >= 0; i--) {
            Point newPosition = new Point(i, y);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            Point newPosition = new Point(i, y);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        // Check movements in the y-direction (up and down)
        for (int i = y - 1; i >= 0; i--) {
            Point newPosition = new Point(x, i);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            Point newPosition = new Point(x, i);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        // Check movements in the diagonals
        // Up-left
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            Point newPosition = new Point(i, j);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Up-right
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            Point newPosition = new Point(i, j);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Down-left
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            Point newPosition = new Point(i, j);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }
        // Down-right
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            Point newPosition = new Point(i, j);
            if (isValidKillingMove(newPosition)) {
                movements.add(newPosition);
            } else {
                break;
            }
        }

        if (movements.contains(nextPosition)) {
            this.setPrevPosition(currPosition);
            this.setCurrPosition(nextPosition);
        } else {
            System.out.println("Invalid move");
        }

        return this;
    }

}
