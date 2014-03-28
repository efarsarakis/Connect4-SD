package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


import ui.CommandlineConstants;
import connect.Connect4Constants;


/**An instance of CommandlineUI can be used to generate output
 * for a Connect4 game to the command-line. 
 * Uses connect.Constants class for String FIELDS of output.
 * @author Manos
 *
 */
public class CommandlineUI implements UiToolkit{

	private BufferedReader move;

	public CommandlineUI()
	{
		move = new BufferedReader(new 
				InputStreamReader(System.in));
	}

	public void print(String string)
	{
		System.out.println(string);
	}

	public void printWelcome()
	{
		print(CommandlineConstants.BREAK_STR);
		print(CommandlineConstants.WELCOME1_STR);
		print(CommandlineConstants.BREAK_STR);
		print("");
		print(CommandlineConstants.WELCOME2_STR);
	}

	public int getLevel() throws IOException
	{
		print("");
		print(CommandlineConstants.CHOOSE_LEVEL_STR);
		String input = move.readLine().toLowerCase();			//read a line
		if(input.equals("1"))
		{
			print(CommandlineConstants.LEVEL_CHOSEN_STR+CommandlineConstants.EASY_STR+"\n");
			return Connect4Constants.EASY;
		}
		else if(input.equals("2")){
			print(CommandlineConstants.LEVEL_CHOSEN_STR+CommandlineConstants.HARD_STR+"\n");
			return Connect4Constants.HARD;
		}
		else if(input.equals("h")){
			help();
			print("");
			return getLevel();
		}
		else
		{
			invalidInputNotification();
			print("");
			return getLevel();
		}
	}

	public int getUserMove() throws IOException
	{
		int returnMove=-1;
		promptInput();
		String input = move.readLine().toLowerCase();			//read a line
		Integer integer = parseInput(input);	//get Integer val

		if(integer==null)						//if non-int, try again
		{
			if(input.equals("h")||input.equals("help"))
			{
				help();
			}
			else if(input.equals("q")||input.equals("quit"))
			{
				exit();
				System.exit(1);
			}
			else invalidInputNotification();
			print("");
			returnMove = getUserMove();
			return returnMove;
		}
		else returnMove = integer.intValue();
		print(CommandlineConstants.BREAK_STR);
		returnMove--;
		return returnMove;
	}

	public void printMyLastMove(int lastMove){
		lastMove++;
		print(CommandlineConstants.BREAK_STR);
		print(CommandlineConstants.YOUR_MOVE_WAS_STR+lastMove+".");
		print("");
	}

	public void printComputerLastMove(int lastMove){
		lastMove++;
		print(CommandlineConstants.BREAK_STR);
		print(CommandlineConstants.COMP_MOVE_WAS_STR + lastMove + ".");
		print("");
	}

	public void printBoard(String board)
	{
		print("Current board:\n");
		print(board);
	}

	public void promptWait()
	{
		print(CommandlineConstants.WAIT_STR);
	}

	public void invalidInputNotification()
	{
		print(CommandlineConstants.IO_ERROR_STR);
	}

	public void winnerIs(int winner)
	{
		if(winner==1)
			print(CommandlineConstants.WINNER_STR);
		else if(winner==-1)
			print(CommandlineConstants.LOSER_STR);
		else
			print(CommandlineConstants.TIE_STR);
	}

	public void exit()
	{
		print(CommandlineConstants.BREAK_STR);
		print(CommandlineConstants.GOODBYE_STR);
		print(CommandlineConstants.BREAK_STR);
	}

	/*PRIVATE METHODS*/

	private void promptInput()
	{
		print(CommandlineConstants.CHOOSE_COL_STR);
	}

	private void help()
	{
		print(CommandlineConstants.BREAK_STR);
		print(CommandlineConstants.HELP_STR);
		print(CommandlineConstants.BREAK_STR);
	}

	//check if input can be parsed. If not return null.
	private Integer parseInput(String input)
	{
		try{
			return new Integer(input);
		}
		catch(NumberFormatException e){
			return null;
		}
	}


}
