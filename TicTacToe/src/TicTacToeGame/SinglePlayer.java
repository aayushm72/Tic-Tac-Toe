package TicTacToeGame;

public class SinglePlayer implements GameType {

	private int[] board = new int[9];
	private Player player1 = new Player("X",100);
	private Player player2 = new Player("O",-100);
	private Player currentPlayer = player1;
	
	public SinglePlayer(){
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
		for (int a=0; a <9 ; a++)
		{
			board[a] = 0;
		}
		currentPlayer = player1;
	}

	@Override
	public void enterValue(int pos, int val) {
		board[pos] = val;
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
            if(a[i] != player1.getValue() && a[i] != player2.getValue())  
                 return false;  
       return true; 
	}

	@Override
	public boolean checkWin(int[] a) {   //returns true if 
		if(a[0] == a[1] && a[0] == a[2] && (a[0] == player1.getValue() || a[0] == player2.getValue()))
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
		int[] h = b.clone();
		if(checkDraw(g) || checkWin(g))
			return heuristicValue(g);
		
		if (Comp == player2)
		{
			int bestValue = -1;
			for(int a =0; a<9; a++)
			{
				if (g[a] == player1.getValue() || g[a] == player2.getValue())
				{
					continue;
				}
				h[a] = player2.getValue();
				g[a] = minimax(a,h,player1);
				if (g[a] > bestValue) {bestValue = g[a];}
				h[a] = 0;
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
				h[a] = player1.getValue();
				g[a] = minimax(a,h,player2);
				if (g[a] < bestValue) {bestValue = g[a];}
				h[a] = 0;
			}
			return bestValue;
		}
	}
	
	public int AITurn()
	{
		int[] h = board.clone();
		int[] b = board.clone();
		int maxVal = -1;
		int a;
		
		for(a = 0; a < 9; a++)
		{
			if(h[a] == player1.getValue() || h[a] == player2.getValue())
			{
				continue;
			}
			h[a] = player2.getValue();
			b[a] = minimax(a,h,player1);
			if (b[a] > maxVal) {maxVal = b[a];}
			h[a] = 0;
		}
		for(a =0; a<9;a++)
		{
			if(b[a] == maxVal)
				break;
		}
		board[a] = player2.getValue();
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
