import java.util.stream.Stream;

public class MyClass {

    public static void main(String[] args) {
        Stream.of("1","2","4","3","6","5").mapToInt(Integer::valueOf).max();
    }
}
