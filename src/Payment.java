import java.math.BigDecimal;

public class Payment {

    private final  String id;
    private final BigDecimal amount;
    private final  String currency;
    private final  Status status;


    public Payment(String id, BigDecimal amount, String currency, Status status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Status getStatus() {
        return status;
    }

    public String toString(){
        return String.format("Payment[ID=%s, Amount=%s, Currency=%s, Status=%s]", id, amount, currency, status);
    }

}
