package connect;

/**An instance of this class is used to represent a Point on a Cartesian
 * grid. Each Point object also can contain an int value called its "state".
 * @author Manos
 *
 */
public class Point {

	// This code was generated by a tool. 

	private int state;
	private int column=0;
	private int row=0;


	
	/**Note that this constructor leaves x,y coordinates to be equal to 0.
	 * 
	 * @param state the state of the returned Point object. 
	 */
	public Point(int state)
	{
		this.state=state;
	}
	
	/**
	 * @param column the column coordinate of the returned Point object.
	 * @param row the row coordinate of the returned Point object.
	 * @param state the state of the returned Point object.  
	 */
	public Point(int column, int row, int state)
	{
		this.column=column;
		this.row=row;
		this.state=state;
	}

	/**
	 * @param state the state of this point to be set
	 */
	public void setState(int state)
	{
		this.state=state;
	}

	/**
	 * @return the state of this Point.
	 */
	public int getState()
	{
		return state;
	}
	
	/**
	 * @return the column coordinate
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * @param column the column coordinate to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	/**
	 * @return the row coordinate
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row coordinate to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

}
