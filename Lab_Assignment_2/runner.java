package Lab_Assignment_2;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

// Interface for refunds
interface Refundable {
    void refund(double amount);
}

// Composition
class AuditService {
    public void record(String message) {
        System.out.println("AUDIT: " + message);
    }
}

// Base class
abstract class Payment {
    // Encapsulation
    private String payerId;
    private double amount;

    // Composition: has-a relationship with AuditService
    protected AuditService auditService;

    // Constructor
    public Payment(String payerId, double amount, AuditService auditService) {
        this.payerId = payerId;
        this.amount = amount;
        this.auditService = auditService;
    }

    // Getter methods
    public String getPayerId() {
        return payerId;
    }

    public double getAmount() {
        return amount;
    }

    public double substractAmount(double money) {
        return this.amount -= money;
    }
    // Common method
    public void evaluateRisk() {
        System.out.println("Performing risk evaluation for amount $" + this.amount);
    }

    // Abstract method
    public abstract void processPayment();
}

// Credit Card Payment
class creditCardPayment extends Payment implements Refundable { // implements means agreeing to the contract of that
                                                                // interface
    private String cardNumber;

    public creditCardPayment(String payerId, double amount, String cardNumber, AuditService auditService) {
        super(payerId, amount, auditService); // this super() calls the parent class
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        evaluateRisk();
        auditService.record("Processing Credit Card payment for " + getPayerId());
        System.out.println("Payment of $" + getAmount() + " made using Credit Card ending with "
                + cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public void refund(double amount) {
        super.substractAmount(amount);
        System.out.println("Refund of $" + amount + " issued to Credit Card ending with "
                + cardNumber.substring(cardNumber.length() - 4));
    }

}

// Wallet Payment
class digitalWalletPayment extends Payment implements Refundable {
    private String walletId; // encapsulated

    public digitalWalletPayment(String payerId, double amount, String walletId, AuditService auditService) {
        super(payerId, amount, auditService);
        this.walletId = walletId;
    }

    @Override
    public void processPayment() {
        evaluateRisk();
        auditService.record("Processing Digital Wallet payment for " + getPayerId());
        System.out.println("Payment of $" + getAmount() + " completed using Wallet ID: " + walletId);
    }

    @Override
    public void refund(double amount) {
        super.substractAmount(amount);
        System.out.println("Refund of $" + amount + " issued to Digital Wallet ending with "
                + walletId.substring(walletId.length() - 4));
    }
}

// Crypto Payment
class cryptoCurrencyPayment extends Payment implements Refundable {
    private String blockchainKey; // encapsulated

    public cryptoCurrencyPayment(String payerId, double amount, String blockchainKey, AuditService auditService) {
        super(payerId, amount, auditService);
        this.blockchainKey = blockchainKey;
    }

    @Override
    public void processPayment() {
        evaluateRisk();
        auditService.record("Processing Crypto payment for " + getPayerId());
        System.out
                .println("Crypto transaction of $" + getAmount() + " verified using blockchain key: " + blockchainKey);
    }

    @Override
    public void refund(double amount) {
        super.substractAmount(amount);
        System.out.println("Refund of $" + amount + " issued to Crypto Wallet ending with "
                + blockchainKey.substring(blockchainKey.length() - 4));
    }
}

public class runner {
    public static void main(String[] args) {
        // One AuditService shared by all ( Composition )
        AuditService audit = new AuditService();

        Payment card = new creditCardPayment("User123", 250.0, "1234567890123456", audit);
        Payment wallet = new digitalWalletPayment("User456", 80.0, "WALLET-9988", audit);
        Payment crypto = new cryptoCurrencyPayment("User789", 500.0, "11111111112222", audit);

        card.processPayment();
        wallet.processPayment();
        crypto.processPayment();

        // interface usage
        if (card instanceof Refundable) {
            ((Refundable) card).refund(100.0);
        }
        if (wallet instanceof Refundable) {
            ((Refundable) wallet).refund(50.0);
        }

        System.out.println(card.getAmount()); // Should get 150
    }
}
