public class BookingService implements Listener {
    private final MessageBus messageBus;

    public BookingService(MessageBus messageBus) {
        this.messageBus = messageBus;
        messageBus.subscribe(this);
    }

    public void book(int numberOfSeats) {
        System.out.println("Booking requested " + numberOfSeats);
        messageBus.send(new Event("booking requested", numberOfSeats));
    }

    @Override
    public void onMessage(Object msg) {

    }
}
