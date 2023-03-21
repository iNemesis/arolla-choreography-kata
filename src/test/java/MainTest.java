import org.junit.Test;

public class MainTest {

    private final MessageBus messageBus = new MessageBus();
    private final InventoryService inventoryService = new InventoryService(messageBus);
    private final TicketingService ticketingService = new TicketingService(messageBus);
    private final BookingService bookingService = new BookingService(messageBus);
    private final NotificationService notificationService = new NotificationService(messageBus);
    @Test
    public void casPassant() {
        int numberOfSeats = 4;
        bookingService.book(numberOfSeats);
    }

    @Test
    public void casPassant2() {
        int numberOfSeats = 4;
        bookingService.book(numberOfSeats);
        bookingService.book(numberOfSeats);
    }

    @Test
    public void casNonPassant() {
        int numberOfSeats = 110;
        bookingService.book(numberOfSeats);
    }
}
