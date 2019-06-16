package ticket;

public class NetworkIssue extends Ticket {

	/**
	 * Constructor calls super and sets priority
	 * @param creator
	 */
	NetworkIssue(String creator) {
		super(creator);

		// Automatically set the priority based on ticket type
		setPriortiy(2);
	}

}
