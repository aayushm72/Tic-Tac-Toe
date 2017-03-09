package TicTacToeGame;

public class SinglePlayer implements GameType {

	private int[] board = new int[9];
	private int counter = 0;
	private Player player1 = new Player("X",100);
	private Player player2 = new Player("O",-100);
	private Player currentPlayer = player1;
	
	public SinglePlayer(){
		counter = 0;
		for (int a=0; a <9 ; a++)
		{
			board[a] = 0;
		}
	}
	
	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public void reset() {
		counter = 0;
		for (int a=0; a <9 ; a++)
		{
			board[a] = 0;
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
	public boolean checkDraw(int[] a) {
		for(int i=0; i<9; i++)  
            if(a[i] == 0)  
                 return false;  
       return true; 
	}

	@Override
	public boolean checkWin(int[] a) {
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

	@Override
	public int[] getBoard() {
		return board;
	}
	
	public int minimax(int pos,int[] b, Player Comp)
	{
		int[] g = b.clone();
		g[pos] = Comp.getValue();
		if(checkDraw(g) || checkWin(g))
			return heuristicValue(g);
		
		if (Comp == player1)
		{
			int bestValue = -1;
			for(int a =0; a<9; a++)
			{
				if (g[a] == player1.getValue() || g[a] == player2.getValue())
				{
					continue;
				}
				g[a] = minimax(a,g,player2);
				if (g[a] > bestValue) {bestValue = g[a];}
			}
			return bestValue;
		}
		else
		{
			int bestValue = 1;
			for(int a=0;a<9;a++)
			{
				if(g[a] == player1.getValue() || g[a] == player2.getValue())
				{
					continue;
				}
				g[a] = minimax(a,g,player1);
				if (g[a] < bestValue) {bestValue = g[a];}
			}
			return bestValue;
		}
	}
	
	public int AITurn() //return the position of the cell in which the computer placed the "O"
	{
		int[] h = board.clone();
		int maxVal = -1;
		int a;
		for(a = 0; a < 9; a++)
		{
			if(h[a] == player1.getValue() || h[a] == player2.getValue())
			{
				continue;
			}
			h[a] = minimax(a,h,player2);  //minimax reutrn the heuristic value
			if (h[a] > maxVal) {maxVal = h[a];}
		}
		for(a =0; a<9;a++)
		{
			if(h[4] == maxVal)
			{
				a = 4; break;
			}
			if(h[a] == maxVal)
				break;
		}
		board[a] = player2.getValue();
		counter++;
		return a;
	}

	public int heuristicValue(int[] a)
	{
		if( (a[0] == a[1] && a[0] == a[2] && a[0] == player1.getValue()) 
				|| (a[3] == a[4] && a[3] == a[5] && a[3] == player1.getValue())
				|| (a[6] == a[7] && a[6] == a[8] && a[6] == player1.getValue()) 
				|| (a[0] == a[3] && a[0] == a[6] && a[0] == player1.getValue()) 
				|| (a[1] == a[4] && a[1] == a[7] && a[1] == player1.getValue()) 
				|| (a[2] == a[5] && a[2] == a[8] && a[2] == player1.getValue()) 
				|| (a[0] == a[4] && a[0] == a[8] && a[0] == player1.getValue()) 
				|| (a[2] == a[4] && a[2] == a[6] && a[2] == player1.getValue()) )
			return -1;
		if( (a[0] == a[1] && a[0] == a[2] && a[0] == player2.getValue()) 
				|| (a[3] == a[4] && a[3] == a[5] && a[3] == player2.getValue())
				|| (a[6] == a[7] && a[6] == a[8] && a[6] == player2.getValue()) 
				|| (a[0] == a[3] && a[0] == a[6] && a[0] == player2.getValue()) 
				|| (a[1] == a[4] && a[1] == a[7] && a[1] == player2.getValue()) 
				|| (a[2] == a[5] && a[2] == a[8] && a[2] == player2.getValue()) 
				|| (a[0] == a[4] && a[0] == a[8] && a[0] == player2.getValue()) 
				|| (a[2] == a[4] && a[2] == a[6] && a[2] == player2.getValue()) )
			return 1;
		return 0;
	}

	@Override
	public boolean isSinglePlayer() {
		return true;
	}

}
