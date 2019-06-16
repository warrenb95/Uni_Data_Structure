package ticket;

public class TicketList {

	private Ticket head = null;
	private Ticket tail = null;
	
	/**
	 * Method to add a ticket into the priority queue
	 * @param tick
	 * @param owner
	 */
	public void add(Ticket tick, String owner) {
		
		// Set the ticket owner
		tick.setOwner(owner);
		
		System.out.printf("Adding:\nID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				tick.getID(),
				tick.getClass().getName().split("\\.")[1],
				tick.getOwner(),
				tick.getPriority());
		
		// If empty make tick front and tail
		if (head == null && tail == null) {
			
			this.head = tick;
			this.tail = tick;
			tick.setID(Main.TicketID++);
			
		} else if (head == tail ){	// If only one item in list
			
			// Add tick to front
			if (tail.getPriority() >= tick.getPriority()) {
				
				// Set next ticket
				tail.setNext(tick);
				// Set previous ticket
				tick.setPrev(tail);
				
				head = tick;
				
				// Increment ID
				tick.setID(Main.TicketID++);
				
			} else if (tail.getPriority() <= tick.getPriority()) {
				// Add ticket to tail
				
				// Set next ticket
				tick.setNext(tail);
				// Set previous ticket
				tail.setPrev(tick);
				
				tail = tick;
				
				// Increment from next ticket
				tick.setID(Main.TicketID++);
			}
			
		} else {
			
			// Loop through all tickets and find where tick should go
			Ticket currentTicket = tail;
			
			while(currentTicket.hasNext()) {
				
				// tick should have a higher priority than currentTicket
				if (currentTicket.getPriority() > tick.getPriority() &&
						tick.getPriority() >= currentTicket.getNextTicket().getPriority()){
					
					// Set tick next to current ticket next
					tick.setNext(currentTicket.getNextTicket());
					
					// Set current ticket next ticket to tick
					currentTicket.setNext(tick);
					// Set previous ticket
					tick.setPrev(currentTicket);
					break;
					
				} else if (currentTicket.getPriority() <= tick.getPriority()) {
					
					// Set tick next to current ticket next
					tick.setNext(currentTicket);
					// Set previous ticket
					currentTicket.setPrev(tick);
					
					// Update tail of queue
					tail = tick;
					break;
					
				} else {
					
					currentTicket = currentTicket.getNextTicket();
					
				}
				
				// Check front
				if (head.getPriority() >= tick.getPriority()) {
					
					// Set current ticket next ticket to tick
					head.setNext(tick);
					// Set previous ticket
					tick.setPrev(head);
					
					// Update front of queue
					head = tick;
					break;
					
				}
				
				// Set ID of ticket
				tick.setID(Main.TicketID++);
			}
		}
		
	}
	
	/**
	 * List all tickets in linked list
	 */
	public void listAll() {
		// Create temp ticket
		Ticket currentTicket = tail;
		
		System.out.println("Listing All Tickets:");
		
		if (tail == head) {
			System.out.printf("ID: %d - Type: %s - Owner: %s - Priority %d\n\n",
					tail.getID(),
					tail.getClass().getName().split("\\.")[1],
					tail.getOwner(),
					tail.getPriority());
		} else {
			// Loop through tickets
			while(currentTicket.hasNext()) {
						
				System.out.printf("ID: %d - Type: %s - Owner: %s - Priority %d\n\n",
						currentTicket.getID(),
						currentTicket.getClass().getName().split("\\.")[1],
						currentTicket.getOwner(),
						currentTicket.getPriority());
				
				currentTicket = currentTicket.getNextTicket();
			}	
		}
		
		// Print the front ticket
		if (tail != head) {
			System.out.printf("ID: %d - Type: %s - Owner: %s - Priority %d\n\n",
					head.getID(),
					head.getClass().getName().split("\\.")[1],
					head.getOwner(),
					head.getPriority());	
		}
		
	}
	
	/**
	 * Search for a ticket
	 * @param ID
	 * @return The ticket if found
	 */
	public Ticket search(int ID) {
		
		// Create temp current ticket
		Ticket currentTicket = tail;
		
		// Loop through tickets
		while(currentTicket.hasNext()) {
			
			if (currentTicket.getID() == ID) {
				
				return currentTicket;
				
			}
			
			currentTicket = currentTicket.getNextTicket();
			
		}
		
		// Check front
		if (head.getID() == ID) {
			return head;
		}
		
		return null;
		
	}
	
	/**
	 * Delete a ticket from priority queue by its ID
	 * @param ID
	 */
	public void delete(int ID) {
		
		// Search for the ticket to delete
		Ticket deleteMe = search(ID);
		
		System.out.printf("Deleting:\nID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				deleteMe.getID(),
				deleteMe.getClass().getName().split("\\.")[1],
				deleteMe.getOwner(),
				deleteMe.getPriority());
		
		// Change where prev ticket points to
		Ticket behind;
		
		// If last ticket
		if (deleteMe == head) {
			
			// Behind points to null because it is at the front of the queue
			behind = deleteMe.getPrevTicket();
			
			behind.setNext(null);
			head.setPrev(null);
			
			head = behind;
			
			// Check to see if only one item in list
			if (head == tail) {
				tail = head;
			}
			
		} else if (deleteMe == tail) {
			
			// Change tail to next ticket in list
			tail = deleteMe.getNextTicket();
			tail.setPrev(null);
			
			// Check to see if only one item in list
			if (tail == head) {
				head = tail;
			}
			
		} else {
			
			behind = deleteMe.getPrevTicket();
			
			// Change where behind is pointing to
			behind.setNext(deleteMe.getNextTicket());
			deleteMe.getNextTicket().setPrev(behind);
		}
		
		// Set value to null/remove from heap
		deleteMe = null;
		
	}
	
	/**
	 * Delete the ticket passed in
	 * @param deleteMe
	 */
	public void delete(Ticket deleteMe) {
		// Change where prev ticket points to
		Ticket behind;
		
		System.out.printf("Deleting:\nID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				deleteMe.getID(),
				deleteMe.getClass().getName().split("\\.")[1],
				deleteMe.getOwner(),
				deleteMe.getPriority());
				
		// If last ticket
		if (deleteMe == head) {
			
			// Behind points to null because it is at the front of the queue
			behind = deleteMe.getPrevTicket();
			
			behind.setNext(null);
			head.setPrev(null);
			
			head = behind;
			
			// Check to see if only one item in list
			if (head == tail) {
				tail = head;
			}
			
		} else if (deleteMe == tail) {
			
			// Change tail to next ticket in list
			tail = deleteMe.getNextTicket();
			tail.setPrev(null);
			
			// Check to see if only one item in list
			if (tail == head) {
				head = tail;
			}
			
		} else {
			
			behind = deleteMe.getPrevTicket();
			
			// Change where behind is pointing to
			behind.setNext(deleteMe.getNextTicket());
			deleteMe.getNextTicket().setPrev(behind);
		}
		
		// Set value to null/remove from heap
		deleteMe = null;
	}
	
	/**
	 * Remove and return the front ticket from the queue
	 * @return front Ticket
	 */
	public Ticket pop() {
		
		// Get the front of the queue
		Ticket popTick = head;
		
		System.out.printf("Popping:\nID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				popTick.getID(),
				popTick.getClass().getName().split("\\.")[1],
				popTick.getOwner(),
				popTick.getPriority());
		
		// Delete front
		this.delete(head);
		
		// Set next and prev to null
		popTick.setNext(null);
		popTick.setPrev(null);
		
		return popTick;
	}
	
	/**
	 * Search for and change the priority of a ticket
	 * @param owner
	 * @param type
	 * @param newPriority
	 */
	public void changePriority(int ID, int newPriority) {
		
		// Search for ticket
		Ticket tick = search(ID);
		
		System.out.printf("Changing priority:\n"
				+ "ID: %d - Type: %s - Owner: %s - Priority %d\n\n",
				tick.getID(),
				tick.getClass().getName().split("\\.")[1],
				tick.getOwner(),
				tick.getPriority());
		
		// Delete the ticket from the list
		this.delete(tick);
		
		// Change the priority
		tick.setPriortiy(newPriority);
		
		// Add ticket tail to list
		this.add(tick, tick.getOwner());
		
		// Keep the same ID
		tick.setID(ID);
		
	}
	
	/**
	 * Get the front of the queue
	 * @return front ticket
	 */
	public Ticket getHead() {
		return head;
	}
	
	/**
	 * Get the tail of the queue
	 * @return tail ticket
	 */
	public Ticket getTail() {
		return tail;
	}

}
