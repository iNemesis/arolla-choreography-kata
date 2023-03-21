
public class TicketingService implements Listener {
    private final MessageBus messageBus;

    public TicketingService(MessageBus messageBus) {
        this.messageBus = messageBus;
        messageBus.subscribe(this);
    }

    public void printTicket(int numberOfSeats) {
        System.out.println("ticket printed " + numberOfSeats);
    }

    @Override
    public void onMessage(Object msg) {
        if (((Event) msg).getName().equals("capacity allocated")) {
            printTicket(((Event) msg).getValue());
        }
    }
}
