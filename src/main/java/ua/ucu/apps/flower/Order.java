package ua.ucu.apps.flower;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import ua.ucu.apps.delivery.Delivery;
import ua.ucu.apps.payment.Payment;


@Data
public class Order {
    private List<Item> items;

    private Delivery delivery;
    private Payment payment;

    public Order(){
        this.items = new ArrayList<>();
    }

    public double getOrderFinalPrice(){
        double finalPrice = items.stream().mapToDouble(Item::getPrice).sum();

        finalPrice += delivery.delivery(finalPrice);
        return finalPrice;
    }
}
