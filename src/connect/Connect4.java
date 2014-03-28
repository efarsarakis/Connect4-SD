

package connect;



import ui.CommandlineUI;

/** This class sets up a Connect4 game. 
 * The current version supports only command line UI, though 
 * this can be changed by specifying a different UiToolkit 
 * implementation. 
 */
public class Connect4 {

	public static void main(String args[]) throws Exception
	{
		Board board; 
		MoveGenerator playerSearch;
		CommandlineUI ui = new CommandlineUI();
		board=new Board();
		
		ui.printWelcome();

		int level = ui.getLevel();
		if(level==Connect4Constants.EASY)
			playerSearch=new RandomMoveGenerator(board);
		else
			playerSearch=new MinMaxGenerator(board, Connect4Constants.DEPTH);

		//GO!
		ui.printBoard(board.toString());
		//do until there is a winner or board is full (tie)
		while((board.winnerIs()==0) && board.validMovesLeft())
		{//get user's move and make it
			if(board.getCurrentPlayer() == Connect4Constants.PLAYER_ONE){
				while(!board.makeMove(ui.getUserMove()))ui.invalidInputNotification();
				ui.printMyLastMove(board.getLastMove());
			}
			else//or generate a move for computer
			{
				ui.promptWait();
				board.makeMove(playerSearch.getMove());
				ui.printComputerLastMove(board.getLastMove());
			}
			//refresh the board
			ui.printBoard(board.toString());
		}
		ui.winnerIs(board.winnerIs());
		ui.exit();
	}

	
}




