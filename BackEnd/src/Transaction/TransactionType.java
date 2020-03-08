package Transaction;

public enum TransactionType {
    LOGOUT("00"),
    CREATE("01"),
    DELETE("02"),
    ADVERTISE("03"),
    BID("04"),
    REFUND("05"),
    ADD_CREDIT("06");
    String id;
    TransactionType(String id) {
        this.id = id;
    }
}
