package _7_lyambda._264;

record Card(Rank rank, Suit suit) implements Comparable<Card> {

    @Override
    public String toString() {
        return suit.getSymbol() + rank.getSymbol();
    }

    @Override
    public int compareTo(Card o) {
        var k = Rank.values().length;
        return Integer.compare((rank.ordinal() * k + suit.ordinal()), (o.rank.ordinal() * k) + o.suit.ordinal());
    }
}
