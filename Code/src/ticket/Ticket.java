package ticket;

public class Ticket {

	// All tickets must have unique ID's
	private int ID = Main.TicketID;
	
	// All tickets must have these:
	private String creator;
	private String owner;
	// Tickets can have a description
	private String desc;
	
	// All tickets have a priority, defined in child class
	private int priority;
	
	// All tickets point to the next and previous else null
	private Ticket nextTicket = null;
	private Ticket prevTicket = null;
	
	// Ticket constructor
	Ticket(String creator){
		// Set creator and owner
		this.creator = creator;
	}
	
	/**
	 * Set the next ticket
	 * @param tick
	 */
	public void setNext(Ticket tick) {
		this.nextTicket = tick;
	}
	
	/**
	 * Set the previous ticket 
	 * @param tick
	 */
	public void setPrev(Ticket tick) {
		this.prevTicket = tick;
	}
	
	/**
	 * Set the tickets priority
	 * @param i
	 */
	public void setPriortiy(int i) {
		this.priority = i;
	}
	
	/**
	 * Return the ticket priority
	 * @return priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Get the next ticket
	 * @return nextTicket
	 */
	public Ticket getNextTicket() {
		if(this.nextTicket == null) {
			return null;
		} else {
			return this.nextTicket;
		}
	}
	
	/**
	 * Return the previous ticket
	 * @return prevTicket
	 */
	public Ticket getPrevTicket() {
		if(this.prevTicket == null) {
			return null;
		} else {
			return this.prevTicket;
		}
	}
	
	/**
	 * Check to see if ticket has a
	 * nextTicket
	 * @return boolean
	 */
	public boolean hasNext() {
		if (nextTicket == null) return false;
		
		return true;
	}
	
	/**
	 * Return the ticket owner
	 * @return owner
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Set the ticket owner
	 * @param newOwner
	 */
	public void setOwner(String newOwner) {
		this.owner = newOwner;
	}

	/**
	 * Return the ticket ID
	 * @return ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Set the ticket ID
	 * @param i
	 */
	public void setID(int i) {
		this.ID = i;
	}
	
}
