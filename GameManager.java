package com.techlabs.UpadatedTicTacToe.app;

import java.util.Scanner;

import com.techlabs.UpadatedTicTacToe.app1.InvalidMoveException;

public class GameManager {
	private int[] xState = new int[9];
    private int[] oState = new int[9];
    private int turn = 1; // 1 for X and 0 for O
    private Game game;
    private Scanner scanner;

    public GameManager(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("*********Welcome to Tic Tac Toe********");
        
        while (true) {
            game.printBoard(xState, oState);
            printCurrentPlayer();

            int value = getPlayerMove();

            try {
                makeMove(value);
            } catch (GridAlreadyFilledException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move! The grid is out of range. Try again.");
                continue;
            }

            int winner = checkForWinner();
            if (winner != -1) {
                System.out.println("Match over");
                break;
            }

            if (isBoardFull()) {
                System.out.println("Match Draw");
                System.out.println("Match over");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    private void printCurrentPlayer() {
        if (turn == 1) {
            System.out.println("X's Chance");
        } else {
            System.out.println("O's Chance");
        }
    }

    private int getPlayerMove() {
        System.out.println("Enter the grid value:");
        return scanner.nextInt();
    }

    private void makeMove(int position) throws GridAlreadyFilledException, InvalidMoveException {
        if (position < 0 || position > 8) {
            throw new InvalidMoveException();
        }

        if (xState[position] == 1 || oState[position] == 1) {
            throw new GridAlreadyFilledException();
        }

        if (turn == 1) {
            xState[position] = 1;
        } else {
            oState[position] = 1;
        }
    }

    private int checkForWinner() {
        return game.checkWin(xState, oState);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (xState[i] != 1 && oState[i] != 1) {
                return false;
            }
        }
        return true;
    }

    private void switchPlayer() {
        turn = 1 - turn;
    }
}
