import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedSet<String> set1 = new SinglyLinkedSet<>();
        set1.add("Alice");
        set1.add("Bob");
        set1.add("Alice"); // дубль — не додасться

        System.out.println("set1 = " + set1);
        System.out.println("Містить Bob? " + set1.contains("Bob"));

        SinglyLinkedSet<String> set2 = new SinglyLinkedSet<>("Carol");
        set2.addAll(Arrays.asList("Dave", "Eve", "Bob"));
        System.out.println("set2 = " + set2);

        set1.addAll(set2);
        System.out.println("Після об’єднання: " + set1);

        set1.remove("Alice");
        System.out.println("Після видалення Alice: " + set1);

        System.out.println("Розмір: " + set1.size());
    }
}

