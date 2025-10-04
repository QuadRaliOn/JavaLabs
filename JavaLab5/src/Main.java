import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Bouquet bouquet = initBouquet();

            System.out.println(bouquet);
            System.out.printf("Загальна вартість букета: %.2f грн%n", bouquet.getTotalPrice());

            sortByFreshness(bouquet);

            findFlowersWithLength(bouquet,30,40);

        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.err.println("Помилка: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Несподівана помилка: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static Bouquet initBouquet() {
        Rose r1 = new Rose("red", 40.0, 90, 30.0);
        Rose r2 = new Rose("white", 35.0, 70, 25.0);
        Tulip t1 = new Tulip(false, 30, 85, 15.0);
        Tulip t2 = new Tulip(true, 25, 60, 20.0);
        Lily l1 = new Lily(true, 45.0, 95, 40.0);

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(r1);
        bouquet.addFlower(r2);
        bouquet.addFlower(t1);
        bouquet.addFlower(t2);
        bouquet.addFlower(l1);

        bouquet.addAccessory(Accessory.WRAPPING_PAPER, 1);
        bouquet.addAccessory(Accessory.RIBBON, 1);
        bouquet.addAccessory(Accessory.CARD, 1);
        return bouquet;
    }

    private static void findFlowersWithLength(Bouquet bouquet, double min, double max) {
        List<Flower> found = bouquet.findByLengthRange(min, max);
        System.out.printf("%nКвіти з довжиною в діапазоні [%.1f, %.1f]:%n", min, max);
        if (found.isEmpty()) {
            System.out.println("  Нічого не знайдено.");
        } else {
            found.forEach(f -> System.out.println("  - " + f));
        }
    }

    private static void sortByFreshness(Bouquet bouquet) {
        bouquet.sortByFreshness(true);
        System.out.println("\nПісля сортування за свіжістю (від найсвіжішої):");
        bouquet.getFlowers().forEach(System.out::println);
    }
}
