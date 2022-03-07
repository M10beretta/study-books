import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        var integerStream = Stream.of(1, 2, 3, 4, 5);

        var iterator = integerStream.iterator();

        iterator.forEachRemaining(System.out::println);
    }
}
