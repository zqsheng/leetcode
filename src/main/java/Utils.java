import java.util.Iterator;

public class Utils {

    public static <T> void print(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString() + ",");
        }
        System.out.println();
    }
}
