package Transaction;

public enum TransactionType {
    LOGOUT("00"),
    CREATE("01"),
    DELETE("02"),
    ADVERTISE("03"),
    BID("04"),
    REFUND("05"),
    ADD_CREDIT("06");

    public String getAccountTypeCode() {
        return id;
    }

    public static TransactionType getTransactionEnum(String transType){
        //Get transaction type
        if (transType.equals(TransactionType.CREATE.getAccountTypeCode())) {
            return TransactionType.CREATE;
        } else if (transType.equals(TransactionType.DELETE.getAccountTypeCode())) {
            return TransactionType.DELETE;
        } else if (transType.equals(TransactionType.ADVERTISE.getAccountTypeCode())) {
            return TransactionType.ADVERTISE;
        } else if (transType.equals(TransactionType.BID.getAccountTypeCode())) {
            return TransactionType.BID;
        } else if (transType.equals(TransactionType.REFUND.getAccountTypeCode())) {
            return TransactionType.REFUND;
        } else if (transType.equals(TransactionType.ADD_CREDIT.getAccountTypeCode())) {
            return TransactionType.ADD_CREDIT;
        }else{
            return TransactionType.LOGOUT;
        }
    }

    public String getId() {
        return id;
    }

    String id;
    TransactionType(String id) {
        this.id = id;
    }
}
