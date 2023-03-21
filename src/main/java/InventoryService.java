
public class InventoryService implements Listener {
    private final MessageBus messageBus;
    int capacity = 100;

    public InventoryService(MessageBus messageBus) {
        this.messageBus = messageBus;
        messageBus.subscribe(this);
    }

    public boolean decrementCapacity(int numberOfSeats) {
        if (capacity < numberOfSeats) {
            messageBus.send(new Event("overcapacity requested", numberOfSeats));
            return false;
        }
        capacity -= numberOfSeats;
        System.out.println("capacity :" + capacity);
        messageBus.send(new Event("capacity allocated", numberOfSeats));

        return true;
    }

    @Override
    public void onMessage(Object msg) {
        if (((Event) msg).getName().equals("booking requested")) {
            decrementCapacity(((Event) msg).getValue());
        }
    }
}
