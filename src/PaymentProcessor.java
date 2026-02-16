import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentProcessor {
    private List<Payment> payments;


    public PaymentProcessor() {
        this.payments = new ArrayList<>();
    }

    public void addPayment(Payment payment){this.payments.add(payment);}

    public List<Payment> getAllPayments(){
        return  new ArrayList<>(this.payments);}


    public List<Payment> getPaymentsByStatus(Status status){
        return payments.stream().filter(payment -> payment.getStatus()==status).collect(Collectors.toList());}



    public int getTotalPayments(){
        return payments.size();
    }


    // Total amount of successful payments using BigDecimal
    public BigDecimal getTotalSuccessfulAmount() {
        return payments.stream()
                .filter(p -> p.getStatus() == Status.SUCCESS)
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Average amount of successful payments using BigDecimal
    public BigDecimal getAverageSuccessfulAmount() {
        List<Payment> successfulPayments = payments.stream()
                .filter(p -> p.getStatus() == Status.SUCCESS)
                .collect(Collectors.toList());

        if (successfulPayments.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = successfulPayments.stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total.divide(BigDecimal.valueOf(successfulPayments.size()), 2, RoundingMode.HALF_UP);
    }

    // Sort payments by amount (descending)
    public List<Payment> sortByAmountDescending() {
        return payments.stream()
                .sorted(Comparator.comparing(Payment::getAmount).reversed())
                .collect(Collectors.toList());
    }



    public void printStatistics() {
        System.out.println("\n========== PAYMENT STATISTICS ==========");
        System.out.println("Total Payments: " + getTotalPayments());
        System.out.println("Successful Payments: " + getPaymentsByStatus(Status.SUCCESS).size());
        System.out.println("Pending Payments: " + getPaymentsByStatus(Status.PENDING).size());
        System.out.println("Failed Payments: " + getPaymentsByStatus(Status.FAILED).size());
        System.out.println("Total Successful Amount: " + getTotalSuccessfulAmount() + " USD");
        System.out.println("Average Successful Amount: " + getAverageSuccessfulAmount() + " USD");
        System.out.println("========================================\n");
    }

}

