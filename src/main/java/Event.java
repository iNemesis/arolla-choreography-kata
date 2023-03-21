/**
 * A basic event with a name and one single integer value
 */
public class Event {
    private final String name;
    private final int value;

    public Event(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {return name;}
    public int getValue() {return value;}
}
