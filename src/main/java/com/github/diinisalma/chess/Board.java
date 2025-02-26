package com.github.diinisalma.chess;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.github.diinisalma.chess.piece.Piece;

public class Board {
    public static final String PAWN = "P";
    public static final String ROOK = "R";
    public static final String KNIGHT = "N";
    public static final String BISHOP = "B";
    public static final String QUEEN = "Q";
    public static final String KING = "K";
    public static final String EMPTY = "--";
    public static String[][] board = new String[8][8];
    static Player[] players = new Player[] { new Player(PieceColor.W), new Player(PieceColor.B) };
    public static final String[] cols = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };
    static PieceColor currentPlayer = PieceColor.W;

    public static void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = EMPTY;
            }
        }

        for (var player : players) {
            for (var piece : player.getPieces()) {
                if (piece.isAlive()) {
                    Point position = piece.getCurrPosition();
                    board[position.getX()][position.getY()] = piece.getColor() + piece.getPieceConstant();
                }
            }
        }

        displayBoard();
        startGame();
    }

    public static void displayBoard() {
        System.out.println("");
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");
    }

    private static void startGame() {
        if (PieceColor.W.equals(currentPlayer)) {
            players[0].inputPosition();
        } else {
            players[1].inputPosition();
        }
    }

    public static int getColIndex(String colName) {
        int index = Arrays.binarySearch(cols, colName.toUpperCase());
        return (index < 0) ? -1 : index;
    }

    public static void updatePiecePlayer(Point position) {
        if (PieceColor.W.equals(currentPlayer)) {
            Piece[] pieces = players[1].getPieces();
            int index = findPieceIndex(position, pieces);
            if (index != -1) {
                pieces[index].setAlive(false);
            }
            players[1].setPieces(pieces);
        } else {
            Piece[] pieces = players[0].getPieces();
            int index = findPieceIndex(position, pieces);
            if (index != -1) {
                pieces[index].setAlive(false);
            }
            players[0].setPieces(pieces);
        }
    }

    private static int findPieceIndex(Point position, Piece[] pieces) {
        return IntStream.range(0, pieces.length)
                .filter(i -> pieces[i].getCurrPosition().equals(position))
                .findFirst()
                .orElse(-1);
    }
}
