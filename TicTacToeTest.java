package com.techlabs.UpadatedTicTacToe.app;

public class TicTacToeTest {

	public static void main(String[] args) {
		Game tictactoe = new TicTacToe();
        GameManager gameManager = new GameManager(tictactoe);
        gameManager.play();
	}

}
