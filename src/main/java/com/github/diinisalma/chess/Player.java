package com.github.diinisalma.chess;

import java.util.Scanner;

import com.github.diinisalma.chess.piece.Bishop;
import com.github.diinisalma.chess.piece.King;
import com.github.diinisalma.chess.piece.Knight;
import com.github.diinisalma.chess.piece.Pawn;
import com.github.diinisalma.chess.piece.Piece;
import com.github.diinisalma.chess.piece.Queen;
import com.github.diinisalma.chess.piece.Rook;

public class Player {
    private Piece[] pieces = new Piece[16];
    private PieceColor color;

    public Player(PieceColor color) {
        this.color = color;
        initPieces();
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    private void initPieces() {
        if (PieceColor.W.equals(color)) {
            for (int i = 0; i < 8; i++) {
                pieces[i] = new Pawn(new Point(1, i), PieceColor.W);
            }
            pieces[8] = new Rook(new Point(0, 0), PieceColor.W);
            pieces[9] = new Knight(new Point(0, 1), PieceColor.W);
            pieces[10] = new Bishop(new Point(0, 2), PieceColor.W);
            pieces[11] = new Queen(new Point(0, 3), PieceColor.W);
            pieces[12] = new King(new Point(0, 4), PieceColor.W);
            pieces[13] = new Rook(new Point(0, 5), PieceColor.W);
            pieces[14] = new Knight(new Point(0, 6), PieceColor.W);
            pieces[15] = new Bishop(new Point(0, 7), PieceColor.W);
        } else {
            for (int i = 0; i < 8; i++) {
                pieces[i] = new Pawn(new Point(6, i), PieceColor.B);
            }
            pieces[8] = new Rook(new Point(7, 0), PieceColor.W);
            pieces[9] = new Knight(new Point(7, 1), PieceColor.W);
            pieces[10] = new Bishop(new Point(7, 2), PieceColor.W);
            pieces[11] = new Queen(new Point(7, 3), PieceColor.W);
            pieces[12] = new King(new Point(7, 4), PieceColor.W);
            pieces[13] = new Rook(new Point(7, 5), PieceColor.W);
            pieces[14] = new Knight(new Point(7, 6), PieceColor.W);
            pieces[15] = new Bishop(new Point(7, 7), PieceColor.W);
        }
    }

    public void inputPosition() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Enter current position and new position
            String currPosition = scanner.next();
            String newPosition = scanner.next();
            int currX = getX(currPosition);
            int currY = getY(currPosition);
            int newX = getX(newPosition);
            int newY = getY(newPosition);
            Point currPos = new Point(currX, currY);
            Point newPos = new Point(newX, newY);
            movePiece(currPos, newPos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getX(String position) {
        if (null == position || position.length() < 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        return Integer.parseInt(position.split("")[1]) - 1;
    }

    private int getY(String position) {
        return Board.getColIndex(Character.toString(position.charAt(0)));
    }

    public void movePiece(Point currPosition, Point nextPosition) {
        for (Piece piece : pieces) {
            if (piece.getCurrPosition().getX() == currPosition.getX()
                    && piece.getCurrPosition().getY() == currPosition.getY()) {
                String enemyPiece = Board.board[nextPosition.getX()][nextPosition.getY()];
                if (!Board.EMPTY.equals(enemyPiece) && !enemyPiece.contains(color.toString())) {
                    piece.killingMove(nextPosition);
                    Board.updatePiecePlayer(nextPosition);
                } else {
                    piece.move(nextPosition, color);
                }

                if (nextPosition.equals(piece.getCurrPosition())) {
                    Board.currentPlayer = PieceColor.B.equals(color) ? PieceColor.W : PieceColor.B;
                    Board.initBoard();
                } else {
                    this.inputPosition();
                }
                break;
            }
        }
        System.out.println("Invalid move");
        this.inputPosition();
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

}
