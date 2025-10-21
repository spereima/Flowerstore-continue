package ua.ucu.apps.lab7.flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> flowerpacks;

    public FlowerBucket() {
        flowerpacks = new ArrayList<>();
    }

    public void add(FlowerPack flowerpack) {
        flowerpacks.add(flowerpack);
    }

    public double getPrice(){
        double total = 0;
        for(FlowerPack flowerpack : flowerpacks){
            total += flowerpack.getPrice();
        }
        return total;
    }
}
