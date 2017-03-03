package TicTacToeGame;

public class SinglePlayer implements GameType {

	private int[] board = new int[9];
	private int counter = 0;
	private Player player1 = new Player("X",100);
	private Player player2 = new Player("O",-100);
	private Player currentPlayer = player1;
	
	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public void reset() {
		counter = 0;
		for (int a=0; a <9 ; a++)
		{
			board[a] = a;
		}
		currentPlayer = player1;
	}

	@Override
	public void enterValue(int pos, int val) {
		board[pos] = val;
		counter++;
	}

	@Override
	public void switchPlayer() {
		if (currentPlayer == player1)
			currentPlayer = player2;
		else
			currentPlayer = player1;
	}

	@Override
	public boolean checkDraw() {
		if(counter >= 9)
			return true;
		else
			return false;
	}

	@Override
	public boolean checkWin() {
		if (counter < 5)
			return false;
		else if(board[0] == board[1] && board[0] == board[2])
			return true;
		else if(board[3] == board[4] && board[3] == board[5])
			return true;
		else if(board[6] == board[7] && board[6] == board[8])
			return true;
		else if(board[0] == board[3] && board[0] == board[6])
			return true;
		else if(board[1] == board[4] && board[1] == board[7])
			return true;
		else if(board[2] == board[5] && board[2] == board[8])
			return true;
		else if(board[0] == board[4] && board[0] == board[8])
			return true;
		else if(board[2] == board[4] && board[2] == board[6])
			return true;
		else
			return false;
	}

}
