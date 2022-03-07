package _7_lyambda._264;

import lombok.Getter;

import java.util.Set;

final class Deck {
    @Getter
    private  Set<Card> cards;

    {
        init();
    }

    private void init() {
        cards = DeckUtil.initDeck(Rank.values(), Suit.values());
    }


    @Override
    public String toString() {
        return String.format("[%d]%s", cards.size(), cards);

    }

}


