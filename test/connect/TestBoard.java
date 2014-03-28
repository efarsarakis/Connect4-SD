package connect;


import org.junit.Test;
//import org.junit.Before;


import connect.Board;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestBoard {

	//tests the outcome of passing invalid input to makeMove() function.
	@Test
	public void testValidInput() {
		Board board = new Board();
		assertFalse("lower-bound test", board.makeMove(-1));
		assertFalse("upper-bound test", board.makeMove(7));
		assertTrue("in-bound test", board.makeMove(5));
	}
	
	//test the outcome if a user tries to place a token in an already full column.
	@Test
	public void testFullColumn() {
		Board board = new Board();
		for(int i=0; i<6; i++)
		{
			board.makeMove(0);
		}
		assertFalse("full first column", board.makeMove(0));
	}
	
	//tests that the winnerIs() method returns the correct value.
	@Test
	public void testWinner() {
		Board board = new Board();
		
		board.makeMove(0);	//player1
		board.makeMove(1);
		board.makeMove(0);	//player1
		board.makeMove(2);
		board.makeMove(0);	//player1
		board.makeMove(1);
		board.makeMove(0);	//player1
		
		assertTrue("Test user wins", board.winnerIs()==Connect4Constants.PLAYER_ONE);
		
		board = new Board();
		
		board.makeMove(0);	//player1
		board.makeMove(1);
		board.makeMove(2);	//player1
		board.makeMove(1);
		board.makeMove(3);	//player1
		board.makeMove(1);
		board.makeMove(0);	//player1
		board.makeMove(1);
		
		assertTrue("Test AI wins", board.winnerIs()==Connect4Constants.PLAYER_TWO);

		board = new Board();
		
		board.makeMove(0);	//player1
		board.makeMove(0);
		board.makeMove(1);	//player1
		board.makeMove(1);
		board.makeMove(2);	//player1
		board.makeMove(2);
		board.makeMove(4);	//player1
		board.makeMove(4);
		
		assertTrue("Test -tie- result", board.winnerIs()==0);

	}
	
	
	

}
