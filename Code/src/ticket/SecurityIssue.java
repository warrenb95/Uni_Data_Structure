package ticket;

public class SecurityIssue extends Ticket {

	/**
	 * Constructor calls super and sets priority
	 * @param creator
	 */
	SecurityIssue(String creator) {
		super(creator);

		// Automatically set the priority based on ticket type
		setPriortiy(1);
	}
	
}
