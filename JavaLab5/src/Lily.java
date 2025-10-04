public class Lily extends Flower {
    private boolean scented;

    public Lily(boolean scented, Double stemLength, int freshness, double price) {
        super("Lily", stemLength, freshness, price);
        this.scented = scented;
    }

    public boolean isScented() {
        return scented;
    }

    @Override
    public String toString() {
        return String.format("Lily{scented=%b} %s", scented, super.toString());
    }
}

