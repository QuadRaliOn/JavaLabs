public class Tulip extends Flower {
    private boolean isDouble; // подвійний пелюсток

    public Tulip(boolean isDouble, Integer stemLength, int freshness, double price) {
        super("Tulip", stemLength, freshness, price);
        this.isDouble = isDouble;
    }

    public boolean isDouble() {
        return isDouble;
    }

    @Override
    public String toString() {
        return String.format("Tulip{double=%b} %s", isDouble, super.toString());
    }
}

