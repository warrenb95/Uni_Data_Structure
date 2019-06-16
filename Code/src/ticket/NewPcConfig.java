package ticket;

public class NewPcConfig extends Ticket {

	/**
	 * Constructor calls super and sets priority
	 * @param creator
	 */
	NewPcConfig(String creator) {
		super(creator);

		// Automatically set the priority based on ticket type
		setPriortiy(4);
	}
	
}
