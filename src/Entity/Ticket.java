package entity;
import java.io.Serializable;

/**
 * This class stores the column and row of a ticket booked by customer
 */
public class Ticket implements Serializable{
	/**
	 * The serialisation version number
	 */
	private static final long serialVersionUID = 6163594143675954354L; //DIDNT CHANGE NUMBER
	/**
	 * The column of the seat
	 */
	private int column;
	/**
	 * The column of the seat
	 */
	private int row;
	
	/**
	 * Creates a {@code Ticket} object of seat booked for a given row and column
	 * @param row row of the booked seat
	 * @param column column of the booked seat
	 */
	public Ticket(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/**
	 * @return the column of the booked seat
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the row of the booked seat
	 */
	public int getRow() {
		return row;
	}
}
