/**
 * Аксесуари для букета з їх вартістю.
 */
public enum Accessory {
    WRAPPING_PAPER(10.0),
    RIBBON(5.0),
    VASE(50.0),
    CARD(15.0);

    private final double price;

    Accessory(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
