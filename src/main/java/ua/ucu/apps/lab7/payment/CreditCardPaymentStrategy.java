package ua.ucu.apps.lab7.payment;

public class CreditCardPaymentStrategy implements Payment{

    @Override
    public void pay(double price) {
        System.out.println("Payment was successfully done by credit card, sum " + price);
    }
    
}
