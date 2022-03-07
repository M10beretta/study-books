package _7_lyambda._264;

import lombok.Getter;

enum Rank {
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _T("T"),
    _J("J"),
    _D("D"),
    _K("K"),
    _A("A");

    @Getter
    private final String symbol;

    Rank(String symbol) {
        this.symbol = symbol;
    }
}
