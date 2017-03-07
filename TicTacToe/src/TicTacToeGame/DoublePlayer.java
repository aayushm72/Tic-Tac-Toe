package TicTacToeGame;

public class DoublePlayer implements GameType {
	
		private int[] board = new int[9];
		private int counter = 0;
		private Player player1 = new Player("X",100);
		private Player player2 = new Player("O",-100);
		private Player currentPlayer = player1;
		
		public DoublePlayer(){
			counter = 0;
			for (int a=0; a <9 ; a++)
			{
				board[a] = 0;
			}
		}
	
		public void reset(){
			counter = 0;
			for (int a=0; a <9 ; a++)
			{
				board[a] = 0;
			}
			currentPlayer = player1;
		}
		
		public void enterValue(int pos, int val){
			board[pos] = val;
			counter++;
		}
		
		public void switchPlayer(){
			if (currentPlayer == player1)
				currentPlayer = player2;
			else
				currentPlayer = player1;
		}
		
		public boolean checkDraw(int[] a){
			for(int i=0; i<9; i++)  
	            if(a[i] == 0)  
	                 return false;  
	       return true; 
		}
		
		public boolean checkWin(int[] a){
			if (counter < 5)
				return false;
			else if(a[0] == a[1] && a[0] == a[2] && (a[0] == player1.getValue() || a[0] == player2.getValue()))
				return true;
			else if(a[3] == a[4] && a[3] == a[5] && (a[3] == player1.getValue() || a[3] == player2.getValue()))
				return true;
			else if(a[6] == a[7] && a[6] == a[8] && (a[6] == player1.getValue() || a[6] == player2.getValue()))
				return true;
			else if(a[0] == a[3] && a[0] == a[6] && (a[0] == player1.getValue() || a[0] == player2.getValue()))
				return true;
			else if(a[1] == a[4] && a[1] == a[7] && (a[1] == player1.getValue() || a[1] == player2.getValue()))
				return true;
			else if(a[2] == a[5] && a[2] == a[8] && (a[2] == player1.getValue() || a[2] == player2.getValue()))
				return true;
			else if(a[0] == a[4] && a[0] == a[8] && (a[0] == player1.getValue() || a[0] == player2.getValue()))
				return true;
			else if(a[2] == a[4] && a[2] == a[6] && (a[2] == player1.getValue() || a[2] == player2.getValue()))
				return true;
			else
				return false;
		}

		public Player getCurrentPlayer() {
			return currentPlayer;
		}

		@Override
		public int[] getBoard() {
			return board;
		}

		@Override
		public boolean isSinglePlayer() {
			return false;
		}

		@Override
		public int AITurn() {
			return 0;
		}
}
