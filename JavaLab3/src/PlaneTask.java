import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class PlaneTask{
    public static Plane[] planes;
    public static void sortPlanes(){
        initPlanes();
        printInfoAboutAllPlanes();

        Arrays.sort(planes); // просто сортування )
        printInfoAboutAllPlanes();

        Arrays.sort(planes, Comparator.comparingInt((Plane p) -> p.length)); // сортування за зростанням
        printInfoAboutAllPlanes();

        Arrays.sort(planes, Comparator.comparingInt((Plane p) -> -p.width)); // сортування за спаданням
        printInfoAboutAllPlanes();
    }

    public static void findIdenticPlane(Plane plane){
        for(int i = 0; i < planes.length; i++){
            if(plane.equals(planes[i])){
                plane.printPlaneInfo();
            }
        }
        System.out.print("There are no identic planes");
    }

    private static void initPlanes(){
        planes = new Plane[4];
        for(int j = 1; planes.length > j; j++){
            planes[j] = getRandomPlane();
        }
        planes[0] = new Plane();
    }

    private static Plane getRandomPlane() {
        String[] modelNames = {"Boeing 737", "Airbus A320", "F-16", "Cessna 172", "Concorde"};
        String[] colors = {"White", "Blue", "Red", "Green", "Gray"};
        Random rand = new Random();

        Plane plane = new Plane();
        plane.modelName = modelNames[rand.nextInt(modelNames.length)];
        plane.color = colors[rand.nextInt(colors.length)];
        plane.length = 20 + rand.nextInt(50);
        plane.width = 10 + rand.nextInt(30);
        plane.planeType = PlaneType.values()[rand.nextInt(PlaneType.values().length)];

        return plane;
    }

    private static void printInfoAboutAllPlanes() {
        System.out.println("\tPlanes:");
        for(int i = 0; i < planes.length; i++){
            planes[i].printPlaneInfo();
        }
    }
}
