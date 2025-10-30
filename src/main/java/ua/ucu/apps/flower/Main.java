package ua.ucu.apps.flower;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Flower rose = new Flower(FlowerType.ROSE, 5, 0.4,  FlowerColor.RED);
        Flower chamomile = new Flower(FlowerType.CHAMOMILE, 3, 0.7, FlowerColor.WHITE);
        Flower tulip = new Flower(FlowerType.TULIP, 8, 1, FlowerColor.PINK);

        store.addFlower(rose);
        store.addFlower(chamomile);
        store.addFlower(tulip);

        Flower searchFlower = new Flower(FlowerType.ROSE, 0, 0, FlowerColor.RED);

        List<Flower> result = store.search(searchFlower);

        System.out.println("Found flowers;");
        for (Flower f : result) {
            System.out.println("Color: " + f.getColor() + ", Price: " + f.getPrice());
        }
    }
}