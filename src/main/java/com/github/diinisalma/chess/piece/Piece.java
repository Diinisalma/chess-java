package com.github.diinisalma.chess.piece;

import java.util.List;

import com.github.diinisalma.chess.Player;
import com.github.diinisalma.chess.Point;

public abstract class Piece {
    Point currPosition, prevPosition;
    Player player;
    boolean alive;

    abstract List<Point> getAvailableMoves();

    abstract String getPieceConstant();

    public void move(Point position) {

    }

}
