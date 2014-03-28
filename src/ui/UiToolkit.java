package ui;

import java.io.IOException;


/** Can be used to link a Connect4 game to a user interface.
 * @author Manos
 *
 */
public interface UiToolkit {

	/**Used to provide user with a custom message.
	 * @param string the message to user.
	 */
	public void print(String string);
	
	/**Should be called at the beginning of each game. 
	 * 
	 */
	public void printWelcome();

	/**Used to request a difficulty level from user.
	 * @return the level the user chooses.
	 * @throws IOException if input from user fails.
	 */
	public int getLevel() throws IOException;
	
	/**Used to request the user's next desired move to be made.
	 * @return the column in which the user wishes to enter a token.
	 * @throws IOException IOException if input from user fails.
	 */
	public int getUserMove() throws IOException;
	
	/**Used to confirm to the user which move they have made. 
	 * @param lastMove the user's last move
	 */
	public void printMyLastMove(int lastMove);
	
	/**Called after AI user's move.
	 * Used to notify the user which move the AI user 
	 * has chosen to make.
	 * @param lastMove
	 */
	public void printComputerLastMove(int lastMove);

	/**Used to notify the user of the current state
	 * of the Connet4 playing board.
	 * @param board the Board of the game. 
	 */
	public void printBoard(String board);
	
	/**Used to notify the user that the AI player
	 * is chosing a move. This process can take 
	 * more time than the user anticipates.
	 * Could be used to initiate a status bar
	 * with movement, to assure user that system
	 * has not stalled. 
	 */
	public void promptWait();
	
	/**Used after an input request to 
	 * notify the user that the given input
	 * is not supported for the current action.
	 */
	public void invalidInputNotification();
	
	/**Used to notify the user of the winner of the game.
	 * @param winner the winner of the game. 1 if winner is 
	 * user, -1 if winner is AI player, 0 if it's a tie.
	 */
	public void winnerIs(int winner);

	/**Used to notify the user that the application is terminating.
	 * Call right before application termination.
	 * 
	 */
	public void exit();

}
