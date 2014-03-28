package ui;
import connect.Connect4Constants;
/**Class Constants is used to set constant values to be used in a Connect4 game
 * implementation.
 * @author Manos
 *
 */
public class CommandlineConstants {
	
		
	/*
	 * Strings for UI
	 */
	public final static String WELCOME1_STR =		"          Welcome to Connect4!";
	public final static String WELCOME2_STR = 		"If you need help at any point in the game, \n"
													+"enter \"h\" to access the help section.";
	
	public final static String BREAK_STR = 			"=========================================";
	
	public final static String CHOOSE_LEVEL_STR = 	"Please choose a level of difficulty: \n"
													+"Enter \"1\" for EASY, or \"2\" for HARD.\n";
	
	public final static String LEVEL_CHOSEN_STR = 	"Difficulty set to: ";
	
	public final static String EASY_STR = 			"EASY";
	
	public final static String HARD_STR = 			"HARD";
	
	public final static String CHOOSE_COL_STR = 	"YOUR TURN! Enter a value from 1 to "+Connect4Constants.COLUMNS+".";
	
	public final static String YOUR_MOVE_WAS_STR =	"You are placing a token in column: ";
	public final static String COMP_MOVE_WAS_STR =	"Your opponent is placing a token in column: ";
	
	public final static String WAIT_STR = 			"Please WAIT your turn. Computer working...";
	
	public final static String IO_ERROR_STR =		"Oops! The value you gave is invalid. \nPlease try again!\n";
	
	public final static String WINNER_STR =			"\n   Congradulations!! YOU WIN!\n\n";
	public final static String LOSER_STR = 			"\n  :( You lose. Try again some time...";
	public final static String TIE_STR = 			"\n           It's a TIE!!";
	
	public final static String GOODBYE_STR = 		"   Sorry to see you go! Come back soon!!"
													+"\n              GOODBYE!!\n";
	
	public final static String HELP_STR = 			"WELCOME TO THE CONNECT4 HELP SECTION\n\n" 
													+"Game strategy:\n"
													+"Drop tokens into the columns from the top.\n"
													+"The first player to have 4 next to each\n"
													+"other WINS!!!!\n\n"
													+"How to play:\n"
													+"Enter a number from 1 to "+Connect4Constants.COLUMNS +" to drop a token \n"
													+"into that column. Then, wait your turn!\n"
													+"Your tokens are the \"O\"s and your opponent\n"
													+"uses the \"X\"s."
													+"SIMPLE, right?\n\n"
													+"If you want to quit enter \"q\" or if \n"
													+"you want to see this help again, enter \"h\".\n"
													+"\n       HAVE FUN PLAYING!!!!";
	
	
	
	

}
