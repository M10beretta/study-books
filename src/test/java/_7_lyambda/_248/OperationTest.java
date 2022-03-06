package _7_lyambda._248;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class OperationTest {
    private static final List<Integer> A = new ArrayList<>();
    private static final List<Integer> B = new ArrayList<>();

    @BeforeAll
    static void init() {
        IntStream.range(0, 5).forEach(i -> {
            A.add(new Random().nextInt(-20, 20));
            B.add(new Random().nextInt(-20, 20));
        });
    }

    @Test
    public void test() {
        IntStream.range(0, 5).forEach(i -> {
            Assertions.assertEquals( A.get(i).doubleValue() +  B.get(i).doubleValue(), Operation.PLUS.apply(A.get(i), B.get(i)));
            Assertions.assertEquals( A.get(i).doubleValue() -  B.get(i).doubleValue(), Operation.MINUS.apply(A.get(i), B.get(i)));
            Assertions.assertEquals( A.get(i).doubleValue() *  B.get(i).doubleValue(), Operation.TIMES.apply(A.get(i), B.get(i)));
            Assertions.assertEquals( A.get(i).doubleValue() /  B.get(i).doubleValue(), Operation.DIVIDE.apply(A.get(i), B.get(i)));
        });
    }
}