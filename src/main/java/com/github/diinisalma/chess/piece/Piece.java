package com.github.diinisalma.chess.piece;

import java.util.List;

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

    public abstract boolean move(Point position, PieceColor color);

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

}
