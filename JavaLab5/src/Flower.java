
public abstract class Flower {
    private final String name;
    private final double stemLength; // см
    private int freshness; // 0..100, 100 — найсвіжіша
    private double price; // грн

    /**
     * @param name      назва квітки
     * @param stemLength довжина стебла
     * @param freshness  рівень свіжості 0..100
     * @param price      ціна за квітку
     */
    public Flower(String name, double stemLength, int freshness, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name не може бути порожнім");
        }
        if (freshness < 0 || freshness > 100) {
            throw new IllegalArgumentException("freshness має бути в діапазоні 0..100");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price не може бути від'ємною");
        }
        this.name = name;
        this.stemLength = stemLength;
        this.freshness = freshness;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getStemLength() {
        return stemLength;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        if (freshness < 0 || freshness > 100) {
            throw new IllegalArgumentException("freshness має бути в діапазоні 0..100");
        }
        this.freshness = freshness;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("price не може бути від'ємною");
        this.price = price;
    }

    /**
     * @return опис
     */
    @Override
    public String toString() {
        return String.format("%s (довжина=%s см, свіжість=%d, ціна=%.2f)",
                name, stemLength, freshness, price);
    }
}
