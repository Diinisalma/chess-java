package com.github.diinisalma.chess;

import java.util.Arrays;

public class Board {
    public static final String PAWN = "P";
    public static final String ROOK = "R";
    public static final String KNIGHT = "N";
    public static final String BISHOP = "B";
    public static final String QUEEN = "Q";
    public static final String KING = "K";
    public static final String EMPTY = "--";
    static String[][] board = new String[8][8];
    static Player[] players = new Player[] { new Player(PieceColor.W), new Player(PieceColor.B) };
    public static final String[] cols = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };

    public static void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = EMPTY;
            }
        }

        for (var player : players) {
            for (var piece : player.getPieces()) {
                Point position = piece.getCurrPosition();
                board[position.getX()][position.getY()] = piece.getColor() + piece.getPieceConstant();
            }
        }

        displayBoard();
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
        players[0].inputPosition();
    }

    public static int getColIndex(String colName) {
        int index = Arrays.binarySearch(cols, colName.toUpperCase());
        return (index < 0) ? -1 : index;
    }
}
