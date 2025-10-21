package ua.ucu.apps.lab7.flower;

import lombok.Data;

@Data
public class Item {
    private FlowerBucket flowerBucket;

    double getPrice(){
        return flowerBucket.getPrice();
    }
}
