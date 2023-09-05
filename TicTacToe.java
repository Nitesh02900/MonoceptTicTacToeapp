package com.techlabs.UpadatedTicTacToe.app;

public class TicTacToe implements Game {
	public static int sum(int a, int b, int c) {
        return a + b + c;
    }
	@Override
    public void printBoard(int[] xState, int[] oState) {
		    String zero = (xState[0] == 1) ? "X" : ((oState[0] == 1) ? "O" : "0");
	        String one = (xState[1] == 1) ? "X" : ((oState[1] == 1) ? "O" : "1");
	        String two = (xState[2] == 1) ? "X" : ((oState[2] == 1) ? "O" : "2");
	        String three = (xState[3] == 1) ? "X" : ((oState[3] == 1) ? "O" : "3");
	        String four = (xState[4] == 1) ? "X" : ((oState[4] == 1) ? "O" : "4");
	        String five = (xState[5] == 1) ? "X" : ((oState[5] == 1) ? "O" : "5");
	        String six = (xState[6] == 1) ? "X" : ((oState[6] == 1) ? "O" : "6");
	        String seven = (xState[7] == 1) ? "X" : ((oState[7] == 1) ? "O" : "7");
	        String eight = (xState[8] == 1) ? "X" : ((oState[8] == 1) ? "O" : "8");
	        System.out.println(zero + " | " + one + " | " + two);
	        System.out.println("--|---|---");
	        System.out.println(three + " | " + four + " | " + five);
	        System.out.println("--|---|---");
	        System.out.println(six + " | " + seven + " | " + eight);
    }

    @Override
    public int checkWin(int[] xState, int[] oState) {
    	int[][] wins = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int[] win : wins) {
            if (sum(xState[win[0]], xState[win[1]], xState[win[2]]) == 3) {
            	printBoard(xState,oState);
                System.out.println("X Won the match");
                return 1;
            }
            if (sum(oState[win[0]], oState[win[1]], oState[win[2]]) == 3) {
            	printBoard(xState,oState);
                System.out.println("O Won the match");
                return 0;
            }
        }
        return -1;
    }
}
