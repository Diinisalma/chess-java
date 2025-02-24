package com.github.diinisalma.chess;

public class Board {
    public static final String PAWN = "P";
    public static final String ROOK = "R";
    public static final String KNIGHT = "N";
    public static final String BISHOP = "B";
    public static final String QUEEN = "Q";
    public static final String KING = "K";
    public static final String EMPTY = "--";
    public static final PieceColor PLAYER_1 = PieceColor.W;
    public static final PieceColor PLAYER_2 = PieceColor.B;
    static String[][] board = new String[8][8];

    public static void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = EMPTY;
            }
        }

        for (int i = 0; i < 8; i++) {
            board[1][i] = PLAYER_2 + PAWN;
            board[6][i] = PLAYER_1 + PAWN;
            switch (i) {
                case 0 -> {
                    setPiece(i, ROOK);
                }
                case 1 -> {
                    setPiece(i, KNIGHT);
                }
                case 2 -> {
                    setPiece(i, BISHOP);
                }
            }
        }
        board[0][3] = PLAYER_2 + QUEEN;
        board[7][3] = PLAYER_1 + QUEEN;
        board[0][4] = PLAYER_2 + KING;
        board[7][4] = PLAYER_1 + KING;
    }

    static void setPiece(int index, String piece) {
        board[0][7 - index] = PLAYER_2 + piece;
        board[7][7 - index] = PLAYER_1 + piece;
        board[0][index] = PLAYER_2 + piece;
        board[7][index] = PLAYER_1 + piece;
    }

    public static void displayBoard() {
        System.out.println("");
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.err.println("\n");
        }
        System.out.println("\n\n");
    }
}
