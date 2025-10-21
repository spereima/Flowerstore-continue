package ua.ucu.apps.lab7.delivery;

public class DHLDeliveryStrategy implements Delivery{

    @Override
    public double delivery(double orderPrice) {
        System.out.println("DHL delivery");
        if (orderPrice > 1500){
            return 0;
        }
        return 200;
    }
    
}
