package connect;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**An instance of RandomMoveGenerator can be used to generate
 * moves for a Connect4 game by randomly choosing among all valid 
 * next moves. 
 * Random choice is based on pseudorandom number generator java.util.Random class.
 * 
 * @author Manos
 *
 */
public class RandomMoveGenerator implements MoveGenerator {

	private Board board;
	private Random rand; 
	
	/**Creates an instance of RandomMoveGenerator.
	 * @param board the board of the Connect4 game.
	 */
	public RandomMoveGenerator(Board board)
	{
		this.board = board;
		rand = new Random();
	}
	
	/* Creates a list of possible valid next moves
	 * and chooses one at random, using pseudorandom
	 * number generator.
	 * @see connect.MoveGenerator#getMove()
	 */
	public int getMove() {
		List<Integer> possibleMoves= new ArrayList<Integer>();
		for(int i = 0; i <7; i++)
		{
			if(board.validMove(i))
			{
				possibleMoves.add(i);
			}
		}
		return possibleMoves.get(Math.abs(rand.nextInt(possibleMoves.size())));

	}







}
