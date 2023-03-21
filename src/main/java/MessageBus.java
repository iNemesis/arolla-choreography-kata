import java.util.ArrayList;
import java.util.List;

/**
 * A simple in-memory, observer-pattern-based single-threaded message bus for designing architecture and testing using unit tests before switching to using actual middleware
 */
public class MessageBus {
    private final List<Listener> subs = new ArrayList<Listener>();

    public void subscribe(Listener l) {
        this.subs.add(l);
    }

    public void send(Object msg) {
        for (Listener l : subs) {
            l.onMessage(msg);
        }
    }
}
