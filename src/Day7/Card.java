package Day7;

public enum Card {
    A,
    K,
    Q,
    J,
    T,
    NINE,
    EIGHT,
    SEVEN,
    SIX,
    FIVE,
    FOUR,
    THREE,
    TWO;

    public static Card stringToCard(String str) {
        return switch (str) {
            case "A" -> A;
            case "K" -> K;
            case "Q" -> Q;
            case "J" -> J;
            case "T" -> T;
            case "9" -> NINE;
            case "8" -> EIGHT;
            case "7" -> SEVEN;
            case "6" -> SIX;
            case "5" -> FIVE;
            case "4" -> FOUR;
            case "3" -> THREE;
            case "2" -> TWO;
            default -> null;
        };
    }
}
