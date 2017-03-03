package TicTacToeGame;

public interface GameType {
	public Player getCurrentPlayer();
	public void reset();
	public void enterValue(int pos, int val);
	public void switchPlayer();
	public boolean checkDraw();
	public boolean checkWin();
}
