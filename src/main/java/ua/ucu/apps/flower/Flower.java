package ua.ucu.apps.flower;

public class Flower {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType type;

    public Flower(){
    }

    public Flower(FlowerType type, double price, double sepalLength, FlowerColor color) {
        this.type = type;
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
    }
    public double getSepalLength() {
        return sepalLength;
    }
    public String getColor() {
        return color.toString();
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    public FlowerType getType() {
        return type;
    }
    
}
