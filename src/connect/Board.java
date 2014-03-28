package connect;

/**An instance of Board can be used to orchestrate a game of Connect4.
 * It uses FIELDS from the Constants class to set parameters of the board.
 * 
 * @author Manos
 *
 */
public class Board {

	private int player1 = Connect4Constants.PLAYER_ONE;
	private int player2 = Connect4Constants.PLAYER_TWO;
	private int emptyCell = Connect4Constants.EMPTY;

	private Point[][] grid;
	private int[] columnOccupancy;

	private int numCols, numRows;

	private int[] moves;
	private int lastMoveIdx;

	private int currentPlayer;
	private Point[][] winningSets;
	
	private int winSets = Connect4Constants.WINNING_SETS;
	private int winSize = Connect4Constants.TOKENS_TO_WIN;


	public Board()
	{
		this.numCols=Connect4Constants.COLUMNS;
		this.numRows=Connect4Constants.ROWS;
		grid=new Point[numCols][numRows];
		columnOccupancy= new int[numCols];
		moves=new int[numCols*numRows];
		lastMoveIdx=-1;
		for(int x =0; x<numCols;x++)
		{
			columnOccupancy[x]=0;
			for(int y=0;y<numRows;y++)
				grid[x][y]=new Point(emptyCell); 
		}
		generateWinningSets();
		currentPlayer=player1;
	}

	//create catalog of winning combinations
	private void generateWinningSets()
	{
		winningSets=new Point[winSets][winSize];
		int count=0;

		// horizontal winners
		for(int y=0;y<numRows;y++)
		{
			for(int x=0;x<numCols-winSize+1;x++)
			{
				Point[] temp = new Point[winSize];
				for(int i=x;i<x+winSize;i++)
					temp[i-x]=grid[i][y];
				winningSets[count]=temp;
				count++;
			}

		}

		// vertical winners
		for(int x=0;x<numCols;x++)
		{
			for(int y=0;y<numRows-winSize+1;y++)
			{
				Point[] temp = new Point[winSize];
				for(int i=y;i<y+winSize;i++)
					temp[i-y]=grid[x][i];
				winningSets[count]=temp;
				count++;
			}

		}

		// diagonal winners
		for(int x=0;x<numCols-winSize+1;x++)
		{
			for(int y=0;y<numRows-winSize+1;y++)
			{
				Point[] temp = new Point[winSize];
				for(int t=x,i=y;t<x+winSize && i<y+winSize;t++,i++)
					temp[i-y]=grid[t][i];
				winningSets[count]=temp;
				count++;
			}

		}
		for(int x=0;x<numCols-winSize+1;x++)
		{
			for(int y=numRows-1;y>numRows-winSize;y--)
			{
				Point[] temp = new Point[winSize];
				for(int t=x,i=y;t<x+winSize && i>-1;t++,i--)
					temp[t-x]=grid[t][i];
				winningSets[count]=temp;
				count++;
			}
		}


	}

	
	/**Checks if a move is valid.
	 * @param column the column to check if a token can be placed.
	 * @return true if the move is valid, false otherwise.
	 */
	public boolean validMove(int column)
	{
		if(column<this.numCols && column>=0)
		{
			if(columnOccupancy[column]<this.numRows)
				return true;
			else 
				return false;
		}
		else
			return false;
	}

	
	/**Used to place a token in a column.
	 * @param column the column in which to place the token
	 * @return true if the move can be made, false otherwise.
	 */
	public boolean makeMove(int column)
	{
		if(validMove(column)){
			grid[column][columnOccupancy[column]].setState(currentPlayer);
			columnOccupancy[column]++;
			lastMoveIdx++;
			moves[lastMoveIdx]=column;
			currentPlayer=-currentPlayer;
			return true;
		}
		else
			return false;
	}
	

	/**Retracts last move made on the board.
	 * 
	 */
	public void undoMove()
	{
								//empty grid cell where last move was made
		grid[moves[lastMoveIdx]][columnOccupancy[moves[lastMoveIdx]]-1].setState(emptyCell);

		columnOccupancy[moves[lastMoveIdx]]--;		//lower occupancy of that cell's column

		lastMoveIdx--;		//go back on move-traking index
		 
		currentPlayer=-currentPlayer;		//revert player accordingly
	}


	/** Checks if there are any valid moves left to be made on the board.
	 * @return true if there are still valid moves available on the board. 
	 */
	public boolean validMovesLeft()
	{
		return lastMoveIdx<(moves.length-1);
	}


	/** Can be used to find the current winner of the board.
	 * @return 1 if player one wins. -1 if player two wins. 0 if no one wins.
	 */
	public int winnerIs()
	{
		for(int i=0;i<winningSets.length;i++)
			if(getScore(winningSets[i])==winSize)
			{
				return player1;
			}
			else if(getScore(winningSets[i])==-winSize)
				return player2;
		return 0;
	}

	/*
	 * Can be used to get the current score on a winning set. 
	 * If only one player has tokens in the set, the
	 * return value is the number of tokens that the 
	 * player (POSITIVE for player1, NEGATIVE for player2). 
	 * Otherwise the return value is 0.
	 */
	private int getScore(Point[] points) {
		int playerone=0;
		int playertwo=0;
		for(int i=0;i<points.length;i++)
			if(points[i].getState()==player1)
				playerone++;
			else if(points[i].getState()==player2)
				playertwo--;
		if((playerone-playertwo>0) && (!(playerone>0 && playertwo<0)))
		{
			return (playerone!=0)?playerone:playertwo;
		}
		else
			return 0;
	}


	/**Used to get the strength of the board by getting the scores
	 * of each winning set and summing the scores using weights.
	 * @return The strength of the board. 
	 */
	public int getStrength()
	{
		int temp;
		int sum=0;
		int[] weights = {0,1,10,50,600};
		for(int i=0;i<winningSets.length;i++)
		{
			temp=getScore(winningSets[i]);
			sum+=(temp>0)?weights[temp]:-weights[-temp];
		}
		return sum+(currentPlayer==player1?16:-16);
	}

	public String toString()
	{
		String temp = "";
		for(int y=numRows-1;y>-1;y--){
			for(int x=0;x<numCols;x++)
				if(grid[x][y].getState()==emptyCell)
					temp = temp + "-";
				else if(grid[x][y].getState()==player1)
					temp = temp + "O";
				else
					temp = temp + "X";
			temp += "\n";
		}
		temp += "\n^^^^^^^\n1234567\n";
		return temp;
	}

	/**Getter for current player of the game.
	 * @return the current player of the game.
	 */
	public int getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	/** Can be used to specify who the next player is.
	 * Should avoid using unless at the beginning of a game.
	 * @param player the player to be set as current.
	 */
	public void setCurrentPlayer(int player)
	{
		this.currentPlayer=player;
	}

	/**Used to get the last move made in the game. 
	 * @return The column in which a token was last placed.
	 */
	public int getLastMove()
	{
		return moves[lastMoveIdx];
	}
}
