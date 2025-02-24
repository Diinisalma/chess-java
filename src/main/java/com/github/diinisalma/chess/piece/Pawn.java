package com.github.diinisalma.chess.piece;

import java.util.List;

import com.github.diinisalma.chess.Point;

public class Pawn extends Piece {

    @Override
    List<Point> getAvailableMoves() {
        return List.of();
    }

    @Override
    String getPieceConstant() {
        return "PAWN";
    }

}
