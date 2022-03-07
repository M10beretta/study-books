package _7_lyambda._278;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalTime;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

public class Main {
    public static void main(String[] args) {
        var now = LocalTime.now();
        extracted1(); //136
        System.out.println(Instant.now().get(MILLI_OF_SECOND)-now.get(MILLI_OF_SECOND));
    }

    private static void extracted1() {
        primes().map(p->TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(m->m.isProbablePrime(50))
                .limit(10)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
