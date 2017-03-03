package TicTacToeGame;

public class Player {
	private String symbol;
	private int val;
	
	public Player(String a, int b){
		symbol = a;
		val = b;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public int getValue()
	{
		return val;
	}
	
}
