package _7_lyambda._264;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

final class DeckUtil {
    private DeckUtil() {
    }


    public static Set<Card> initDeck(Rank[] ranks, Suit[] suits) {
        var res = new TreeSet<Card>();
        for (Rank rank : ranks) {
            for (Suit suit : suits) {
                res.add(new Card(rank, suit));
            }
        }
        return res;
    }


    public static Set<Card> initDeckLambda(Rank[] ranks, Suit[] suits) {
        return Arrays.stream(ranks)
                .flatMap(rank -> Stream.of(suits)
                        .map(suit -> new Card(rank, suit)))
                .collect(toSet());
    }
}
