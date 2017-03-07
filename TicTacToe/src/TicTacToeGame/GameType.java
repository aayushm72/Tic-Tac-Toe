package TicTacToeGame;

public interface GameType {
	public Player getCurrentPlayer();
	public void reset();
	public void enterValue(int pos, int val);
	public void switchPlayer();
	public boolean checkDraw(int[] a);
	public boolean checkWin(int[] a);
	public int[] getBoard();
	public boolean isSinglePlayer();
	public int AITurn();
}
