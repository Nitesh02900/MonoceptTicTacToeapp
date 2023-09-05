package com.techlabs.UpadatedTicTacToe.app;

public class GridAlreadyFilledException extends Exception{
	 public GridAlreadyFilledException() {
	        super("Invalid move! The grid is already filled. Try again.");
	    }
}
