package connect;

/**An implementation of the MoveGenerator can be used to generate 
 * moves for an AI player in a Connect4 game. 
 * @author Manos
 *
 */
public interface MoveGenerator {

	/**Used to get a move for the AI player. 
	 * @return the move recommended by the underlying algorithm. 
	 */
	public int getMove();	
	
}
