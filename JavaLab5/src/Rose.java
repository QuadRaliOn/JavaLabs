public class Rose extends Flower {
    private String color;

    public Rose(String color, Double stemLength, int freshness, double price) {
        super("Rose", stemLength, freshness, price);
        if (color == null || color.isBlank()) color = "unknown";
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Rose{color=%s} %s", color, super.toString());
    }
}
