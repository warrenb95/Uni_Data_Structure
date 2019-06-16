package ticket;

public class Main {

	// Global TicketID variable
	public static int TicketID = 1;

	public static void main(String[] args) {
		
		// Create the ticketList
		TicketList ticketList = new TicketList();
		
		// Create a Ticket
		Ticket tick1 = new NetworkIssue("Elishia");
		
		// Add to the ticket list with Warren as the owner
		ticketList.add(tick1, "Warren");
		
		// Create a Ticket
		Ticket tick3 = new NewPcConfig("Warren");
		
		// Add to the ticket list with Callum as the owner
		ticketList.add(tick3, "Callum");
		
		// Create a Ticket
		Ticket tick2 = new SecurityIssue("Warren");
		
		// Add to the ticket list with Elishia as the owner
		ticketList.add(tick2, "Elishia");		
		
		// Test list all method
		ticketList.listAll();
		
		System.out.println();
		System.out.println();
		
		// Test delete method
		ticketList.delete(1);
		
		System.out.println();
		System.out.println();
		
		ticketList.listAll();
		
		System.out.println();
		System.out.println();
		
		// Test change priority method
		ticketList.changePriority(2, 3);
		
		System.out.println();
		System.out.println();
		
		ticketList.listAll();
		
		System.out.println();
		System.out.println();
		
		// Test pop method
		Ticket popTick = ticketList.pop();
		
		// Make sure pop works
		System.out.printf("Popped Ticket:\nID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				popTick.getID(),
				popTick.getClass().getName().split("\\.")[1],
				popTick.getOwner(),
				popTick.getPriority());
		
		System.out.println();
		System.out.println();
		
		ticketList.listAll();
		
	}
	
}
