package _7_lyambda._264;

import lombok.Getter;

enum Suit {
    H("♥"), D("♦"), C("♣"), S("♠");

    @Getter
    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }
}
