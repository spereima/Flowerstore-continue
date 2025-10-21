package ua.ucu.apps.lab7;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ua.ucu.apps.lab7.payment.CreditCardPaymentStrategy;
import ua.ucu.apps.lab7.payment.PayPalPaymentStrategy;

public class PaymentTests {
    @Test
    void testPayPalPayment() {
        PayPalPaymentStrategy paypal = new PayPalPaymentStrategy();
        double amount = 500;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        paypal.pay(amount);

        String expectedOutput = "Payment was successfully done by paypal, sum 500.0";
        assertTrue(outContent.toString().trim().contains(expectedOutput), "PayPal payment message incorrect");
    }

    @Test
    void testCreditCardPayment() {
        CreditCardPaymentStrategy creditCard = new CreditCardPaymentStrategy();
        double amount = 800;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        creditCard.pay(amount);

        String expectedOutput = "Payment was successfully done by credit card, sum 800.0";
        assertTrue(outContent.toString().trim().contains(expectedOutput), "Credit card payment message incorrect");
    }
}
