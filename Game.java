package com.techlabs.UpadatedTicTacToe.app;

public interface Game {
	void printBoard(int[] xState, int[] oState);
    int checkWin(int[] xState, int[] oState);
}
