package bloch._7_lyambda._264;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckUtilTest {

    private final int deck;

    {
        deck = Rank.values().length * Suit.values().length;
    }

    @Test
    void initDeck() {
        assertEquals(DeckUtil.initDeck(Rank.values(), Suit.values()).size(), deck);
    }

    @Test
    void initDeckLambda() {
        assertEquals(DeckUtil.initDeckLambda(Rank.values(), Suit.values()).size(), deck);
    }
}