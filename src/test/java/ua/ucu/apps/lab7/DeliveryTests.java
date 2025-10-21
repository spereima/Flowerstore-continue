package ua.ucu.apps.lab7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ua.ucu.apps.lab7.delivery.DHLDeliveryStrategy;
import ua.ucu.apps.lab7.delivery.PostDeliveryStrategy;
import ua.ucu.apps.lab7.flower.Flower;
import ua.ucu.apps.lab7.flower.FlowerBucket;
import ua.ucu.apps.lab7.flower.FlowerColor;
import ua.ucu.apps.lab7.flower.FlowerPack;
import ua.ucu.apps.lab7.flower.FlowerType;
import ua.ucu.apps.lab7.flower.Item;
import ua.ucu.apps.lab7.flower.Order;

public class DeliveryTests {

    @Test
    void testDHLDeliveryBelowThreshold() {
        DHLDeliveryStrategy dhl = new DHLDeliveryStrategy();
        double price = 1000;
        double deliveryCost = dhl.delivery(price);
        assertEquals(200, deliveryCost, "DHL delivery should cost 200 for orders below 1500");
    }

    @Test
    void testDHLDeliveryAboveThreshold() {
        DHLDeliveryStrategy dhl = new DHLDeliveryStrategy();
        double price = 1600;
        double deliveryCost = dhl.delivery(price);
        assertEquals(0, deliveryCost, "DHL delivery should be free for orders above 1500");
    }

    @Test
    void testPostDeliveryBelowThreshold() {
        PostDeliveryStrategy post = new PostDeliveryStrategy();
        double price = 800;
        double deliveryCost = post.delivery(price);
        assertEquals(100, deliveryCost, "Postal delivery should cost 100 for orders below 1000");
    }

    @Test
    void testPostDeliveryAboveThreshold() {
        PostDeliveryStrategy post = new PostDeliveryStrategy();
        double price = 1200;
        double deliveryCost = post.delivery(price);
        assertEquals(0, deliveryCost, "Postal delivery should be free for orders above 1000");
    }

    @Test
    void testOrderWithDHLDelivery() {
        Flower flower = new Flower(FlowerType.ROSE, 500, 10, FlowerColor.RED);
        FlowerPack pack = new FlowerPack(flower, 2);
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Item item = new Item();
        item.setFlowerBucket(bucket);

        Order order = new Order();
        order.getItems().add(item);
        order.setDelivery(new DHLDeliveryStrategy());

        double expectedPrice = bucket.getPrice() + 200;
        assertEquals(expectedPrice, order.getOrderFinalPrice(), "Order final price with DHL delivery is incorrect");
    }

    @Test
    void testOrderWithPostDeliveryFree() {
        Flower flower = new Flower(FlowerType.TULIP, 600, 12, FlowerColor.PINK);
        FlowerPack pack = new FlowerPack(flower, 2);
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Item item = new Item();
        item.setFlowerBucket(bucket);

        Order order = new Order();
        order.getItems().add(item);
        order.setDelivery(new PostDeliveryStrategy());

        double expectedPrice = bucket.getPrice();
        assertEquals(expectedPrice, order.getOrderFinalPrice(), "Order final price with free Post delivery is incorrect");
    }
}
