import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        Payment p1 = new Payment("PAY001", new BigDecimal("150.50"), "USD", Status.SUCCESS);
        Payment p2 = new Payment("PAY002", new BigDecimal("200.00"), "USD", Status.PENDING);
        Payment p3 = new Payment("PAY003", new BigDecimal("75.25"), "USD", Status.SUCCESS);
        Payment p4 = new Payment("PAY004", new BigDecimal("500.00"), "USD", Status.FAILED);
        Payment p5 = new Payment("PAY005", new BigDecimal("125.75"), "USD", Status.SUCCESS);


        // Add payments to processor
        processor.addPayment(p1);
        processor.addPayment(p2);
        processor.addPayment(p3);
        processor.addPayment(p4);
        processor.addPayment(p5);


        processor.printStatistics();

    }



}