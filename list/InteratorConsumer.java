
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        // Get the iterator from the ArrayList
        Iterator<String> iterator = names.iterator();

        // Move the cursor forward
        if (iterator.hasNext()) {
            iterator.next(); // Move cursor to "Alice"
        }

        // Define the action to be performed on each remaining element
        Consumer<String> action1 = name -> System.out.println("Hello, " + name);
        Consumer<String> action2 = name -> System.out.println("Bye, " + name);
        // Use the forEachRemaining method to perform the action on all remaining elements
        iterator.forEachRemaining(action1.andThen(action2));
    }
/*
Consumer interface

public interface Consumer<T> {
    void accept(T t);
    
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

*/

}
