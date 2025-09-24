/**
 * The Plane class represents an airplane with basic properties:
 * model name, color, dimensions, and type.
 * Implements Comparable to allow sorting and comparison of planes.
 */
public class Plane implements Comparable<Plane>{
    /** The model name of the plane */
    public String modelName;

    /** The color of the plane */
    public String color;

    /** The length of the plane */
    public int length;

    /** The width of the plane */
    public int width;

    /** The type of the plane (SMALL, MEDIUM, LARGE) */
    public PlaneType planeType;

    /**
     * @param modelName the model name of the plane
     * @param Color the color of the plane
     * @param length the length of the plane
     * @param width the width of the plane
     * @param planeType the type of the plane
     */
    public Plane(String modelName, String Color, int length, int width, PlaneType planeType){
        this.modelName = modelName;
        this.color = Color;
        this.length = length;
        this.width = width;
        this.planeType = planeType;
    }

    /**
     * Default constructor.
     * Creates a Plane with default values:
     * modelName and color set to "Unknown", length and width set to 0,
     * and planeType set to SMALL.
     */
    public Plane(){
        this.modelName = "Unknown";
        this.color = "Unknown";
        this.length = 0;
        this.width = 0;
        this.planeType = PlaneType.SMALL;
    }

    /**
     * Prints all the information about the plane to the console.
     */
    public void printPlaneInfo(){
        System.out.println("ModelName: " + modelName);
        System.out.println("Color: " + color);
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("PlaneType: " + planeType + "\n");
    }

    /**
     * Checks if this plane is equal to another object.
     * Two planes are considered equal if all their fields match.
     *
     * @param obj the object to compare with
     * @return true if the planes are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Plane other))
            return false;
        return (other.color.equals(color)
                && other.length == length
                && other.width == width
                && other.planeType == planeType
                && other.modelName.equals(modelName));
    }


    /**
     * Compares this plane with another plane for sorting.
     * Sorting order:
     * - modelName (lexicographically)
     * - color (lexicographically)
     * - length (descending)
     * - width (descending)
     * - planeType (ordinal descending)
     *
     * @param other the other plane to compare with
     * @return a negative integer, zero, or a positive integer as this plane
     *         is less than, equal to, or greater than the specified plane
     */
    @Override
    public int compareTo(Plane other) {
        if(other.modelName.compareTo(modelName) != 0)
            return other.modelName.compareTo(modelName);
        if(other.color.compareTo(color) != 0)
            return other.color.compareTo(color);
        if(other.length != length)
            return other.length - length;
        if(other.width != width)
            return other.width - width;
        return other.planeType.ordinal() - planeType.ordinal();
    }

}
enum PlaneType{
    SMALL ,
    MEDIUM ,
    LARGE
}

