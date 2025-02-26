package com.github.diinisalma.chess.piece;

import java.util.List;

import com.github.diinisalma.chess.Board;
import com.github.diinisalma.chess.PieceColor;
import com.github.diinisalma.chess.Point;

public abstract class Piece {
    Point currPosition, prevPosition;
    PieceColor color;
    boolean alive;

    public Piece(Point currPosition, PieceColor color) {
        this.currPosition = currPosition;
        this.color = color;
        this.alive = true;
    }

    abstract List<Point> getAvailableMoves(Point currPosition);

    public abstract String getPieceConstant();

    public Piece move(Point position, PieceColor color) {
        if (!alive) {
            System.out.println("Piece is dead");
        }

        if (getAvailableMoves(currPosition).contains(position)) {
            this.setPrevPosition(currPosition);
            this.setCurrPosition(position);
        } else {
            System.out.println("Invalid move");
        }
        return this;
    };

    public abstract Piece killingMove(Point nextPosition);

    public Point getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(Point currPosition) {
        this.currPosition = currPosition;
    }

    public Point getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(Point prevPosition) {
        this.prevPosition = prevPosition;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public boolean isValidMove(Point position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > 7 || position.getY() > 7) {
            return false;
        }
        String piece = Board.board[position.getX()][position.getY()];
        return Board.EMPTY.equals(piece);
    }

    public boolean isValidKillingMove(Point newPosition) {
        return !color.toString()
                .equals(Character.toString((Board.board[newPosition.getX()][newPosition.getY()]).charAt(0)));
    }

}
