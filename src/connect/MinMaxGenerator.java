package connect;

/**An instance of MinMaxGenerator can be used to generage
 * moves for a Connect4 game based on the MinMax Algorithm. 
 * @author Manos
 *
 */
public class MinMaxGenerator implements MoveGenerator{
	
	private Board board;
	private int depth;
	private int cols;

	/**Construct an instance of MinMaxGenerator.
	 * @param board the board of the game.
	 * @param depth the lookahead depth of the algorithm.
	 */
	public MinMaxGenerator(Board board, int depth){
		this.board=board;
		this.depth=depth;
		this.cols= Connect4Constants.COLUMNS;
	}

	
	/* Initiate recursion of MinMax algorighm and return the 
	 * move to be made which most benefits player2.
	 * @see connect.MoveGenerator#getMove()
	 */
	public int getMove()
	{
		int[] moves = new int[cols];
		int highest = 0;
		for(int column=0;column<cols;column++)
		{
			moves[column] = Integer.MIN_VALUE;
			if(board.validMove(column))
			{
				board.makeMove(column);
				moves[column] = minValue(depth);
				if(moves[column]>=moves[highest])
					highest=column;
				board.undoMove();
			}
		}
		return highest;
	}
	
	
	// returns the min of possible moves at this level
	private int minValue(int depthRemaining)
	{
		int[] moves = new int[cols];
		int lowest = 0;
		for(int column=0;column<cols;column++)
		{
			moves[column] = Integer.MAX_VALUE;
			if(board.validMove(column))
			{
				board.makeMove(column);
				if((board.winnerIs() == 0) && depthRemaining>0)
				{
					moves[column] = maxValue(depthRemaining-1);
				}
				else 
				{
					moves[column] = -board.getStrength();
				}
				if(moves[column]<moves[lowest])
					lowest=column;
				board.undoMove();
			}
			//System.out.print(moves[i] + " ");
		}
		
		return moves[lowest];

	}
	
	
	//returns the max of possible moves at this level
	private int maxValue(int depthRemaining)
	{
		//System.out.print("Max" + ply + ": ");
		int[] moves = new int[cols];
		int highest = 0;
		for(int i=0;i<cols;i++)
		{
			moves[i] = Integer.MIN_VALUE;
			if(board.validMove(i))
			{
				board.makeMove(i);
				if((board.winnerIs() == 0) && depthRemaining>0)
				{
					moves[i] = minValue(depthRemaining-1);
				}
				else 
					moves[i] =-board.getStrength();
				if(moves[i]>=moves[highest])
					highest=i;
				board.undoMove();
			}
			//System.out.print(moves[i] + " ");
		}
		//System.out.println();
		return moves[highest];

	}


}

