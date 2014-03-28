package connect;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import connect.Point;

import org.junit.Test;


public class TestPoint {
	
	@Test
	public void testPointAfterConstruction() {
		Point testPoint = new Point(1,1,4);
		assertTrue("test constructor -column- value set", testPoint.getColumn()==1);
		assertTrue("test constructor -row- value set", testPoint.getRow()==1);
		assertTrue("test constructor -state- values set", testPoint.getState()==4);
	}

	@Test
	public void testPointChanges()
	{
		Point testPoint = new Point(-1,1,4);
		testPoint.setColumn(0);
		testPoint.setRow(99);
		testPoint.setState(-29333);
		assertTrue("test set -column- value", testPoint.getColumn()==0);
		assertTrue("test set -row- value", testPoint.getRow()==99);
		assertTrue("test set -state- value", testPoint.getState()==-29333);
	}


}
