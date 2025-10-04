import java.util.*;
import java.util.stream.Collectors;

public class Bouquet {
    private final List<Flower> flowers;
    private final Map<Accessory, Integer> accessoriesCount;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessoriesCount = new EnumMap<>(Accessory.class);
    }

    /**
     * @param flower квітка
     * @throws NullPointerException якщо flower == null
     */
    public void addFlower(Flower flower) {
        Objects.requireNonNull(flower, "flower не може бути null");
        flowers.add(flower);
    }

    public boolean removeFlower(Flower flower) {
        return flowers.remove(flower);
    }

    public List<Flower> getFlowers() {
        return Collections.unmodifiableList(flowers);
    }

    /**
     * @param accessory аксесуар
     * @param count     кількість (>=1)
     */
    public void addAccessory(Accessory accessory, int count) {
        if (accessory == null) throw new IllegalArgumentException("accessory не може бути null");
        if (count <= 0) throw new IllegalArgumentException("count має бути >= 1");
        accessoriesCount.merge(accessory, count, Integer::sum);
    }

    /**
     * @return загальна ціна
     * @throws IllegalStateException якщо букет порожній
     */
    public double getTotalPrice() {
        if (flowers.isEmpty()) throw new IllegalStateException("Букет порожній");
        double flowersSum = flowers.stream().mapToDouble(Flower::getPrice).sum();
        double accessoriesSum = accessoriesCount.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
        return flowersSum + accessoriesSum;
    }

    /**
     * @param descending true — від найсвіжіших до найменш свіжих
     * @throws IllegalStateException якщо букет порожній
     */
    public void sortByFreshness(boolean descending) {
        if (flowers.isEmpty()) throw new IllegalStateException("Букет порожній");
        Comparator<Flower> comp = Comparator.comparingInt(Flower::getFreshness);
        if (descending) comp = comp.reversed();
        flowers.sort(comp);
    }

    /**
     * @param min мінімальна довжина (включно)
     * @param max максимальна довжина (включно)
     * @return список відповідних квіток; порожній список якщо не знайдено
     * @throws IllegalArgumentException якщо min > max
     */
    public List<Flower> findByLengthRange(double min, double max) {
        if (min > max) throw new IllegalArgumentException("min не може бути > max");
        return flowers.stream()
                .filter(f -> {
                    double len = f.getStemLength();
                    return len >= min && len <= max;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bouquet:\n");
        for (Flower f : flowers) {
            sb.append("  - ").append(f).append("\n");
        }
        sb.append("Accessories:\n");
        accessoriesCount.forEach((a, c) -> sb.append("  - ").append(a).append(" x").append(c).append("\n"));
        return sb.toString();
    }
}
