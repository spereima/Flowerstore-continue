package ua.ucu.apps.lab7.flower;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Flower> flowers;

    public Store() {
        flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public List<Flower> search(Flower searchFlower) {
        List<Flower> result = new ArrayList<>();

        for (Flower flower : flowers) {

            if (searchFlower.getType() != null && searchFlower.getType() != flower.getType()) {
                continue;
            }

            if (searchFlower.getColor() != null && searchFlower.getColor() != flower.getColor()) {
                continue;
            }

            if (searchFlower.getPrice() != 0 && searchFlower.getPrice() != flower.getPrice()) {
                continue;
            }
            result.add(flower);
        }

        return result;
    }
}
