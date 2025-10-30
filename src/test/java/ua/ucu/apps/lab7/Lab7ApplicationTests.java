package ua.ucu.apps.lab7;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ua.ucu.apps.delivery.DHLDeliveryStrategy;
import ua.ucu.apps.delivery.Delivery;
import ua.ucu.apps.delivery.PostalDeliveryStrategy;
import ua.ucu.apps.payment.CreditCardPaymentStrategy;
import ua.ucu.apps.payment.PayPalPaymentStrategy;
import ua.ucu.apps.payment.Payment;

@SpringBootTest
class Lab7ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void testCreditCardPayment() {
        Payment payment = new CreditCardPaymentStrategy();

        assertDoesNotThrow(() -> payment.pay(500));
    }

    @Test
    void testPayPalPayment() {
        Payment payment = new PayPalPaymentStrategy();

        assertDoesNotThrow(() -> payment.pay(1000));
    }

	@Test
    void testDHLDeliveryBelowThreshold() {
        Delivery delivery = new DHLDeliveryStrategy();

        double price = 1000;
        double deliveryCost = delivery.delivery(price);

        assertEquals(200, deliveryCost, "DHL delivery should cost 200 for orders below 1500");
    }

    @Test
    void testDHLDeliveryAboveThreshold() {
        Delivery delivery = new DHLDeliveryStrategy();

        double price = 2000;
        double deliveryCost = delivery.delivery(price);

        assertEquals(0, deliveryCost, "DHL delivery should be free for orders above 1500");
    }

    @Test
    void testPostalDeliveryBelowThreshold() {
        Delivery delivery = new PostalDeliveryStrategy();

        double price = 500;
        double deliveryCost = delivery.delivery(price);

        assertEquals(100, deliveryCost, "Postal delivery should cost 100 for orders below 1000");
    }

    @Test
    void testPostalDeliveryAboveThreshold() {
        Delivery delivery = new PostalDeliveryStrategy();

        double price = 1500;
        double deliveryCost = delivery.delivery(price);

        assertEquals(0, deliveryCost, "Postal delivery should be free for orders above 1000");
    }
}
