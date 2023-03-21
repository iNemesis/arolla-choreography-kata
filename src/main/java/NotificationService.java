public class NotificationService implements Listener {
    private final MessageBus messageBus;

    public NotificationService(MessageBus messageBus) {
        this.messageBus = messageBus;
        messageBus.subscribe(this);
    }

    public void notifyFailure() {
        System.out.println("Reservation failed !");
    }

    @Override
    public void onMessage(Object msg) {
        if (((Event) msg).getName().equals("overcapacity requested")) {
            notifyFailure();
        }
    }
}
