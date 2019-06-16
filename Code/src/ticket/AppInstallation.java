package ticket;

public class AppInstallation extends Ticket {

	/**
	 * Constructor calls super and sets priority
	 * @param creator
	 */
	AppInstallation(String creator) {
		super(creator);
		
		// Automatically set the priority based on ticket type
		this.setPriortiy(3);
	}

}
