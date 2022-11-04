package entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains all the information of a booking
 */
public class Booking implements Serializable {
	/**
	 * The serialisation version number
	 */
	private static final long serialVersionUID = 3967681838005218902L; //HAVENT CHANGED
	/**
	 * The transaction id of the booking
	 */
	private String transactionId; 
	/**
	 * The customer who made the booking
	 */
	private Customer customer;
	/**
	 * An array of tickets selected in the booking
	 */
	private ArrayList<Ticket> tickets;
	/**
	 * The price of the booking
	 */
	private double price;
	
	/**
	 * Creates a {@code Booking} object with a give transaction id, customer, selected seats and price
	 * @param transactionId the transaction id of the booking
	 * @param customer the customer who made the booking
	 * @param selectedSeats the selected seats of the booking
	 * @param price the price of the booking
	 */
	public Booking(String transactionId, Customer customer, boolean[][] selectedSeats, double price) {
		this.transactionId = transactionId;
		this.customer = customer;
		this.price = price;
		this.tickets = new ArrayList<Ticket>();
		for (int i = 0; i < selectedSeats.length ; i++){
			for(int j = 0; j < selectedSeats[i].length; j++){
				if(selectedSeats[i][j] == true){
					Ticket ticket = new Ticket(i, j);
					tickets.add(ticket);
				}
			}
		}
	}
	
	/**
	 * Get the transaction id of the booking
	 * @return the transaction id of the booking
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 * Get the customer who made the booking
	 * @return the customer who made the booking
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Get the tickets booked in the booking
	 * @return the tickets booked in the booking
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Get the price of the booking
	 * @return the price of the booking
	 */
	public double getPrice() {
		return price;
	}	
}