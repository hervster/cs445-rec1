import java.util.Scanner;

// This class demonstrates multiple references to the same object, as well as
// static vs. non-static variables.
public class Rec1A {
    // Every Rec1A object has a name
    private String name;

    // All Rec1A objects share a count
    private static int count = 0;

    /**
     * Returns this Rec1A's name
     */
    public String getName() { return name; }

    /**
     * Changes this Rec1A's name. Throws IllegalArgumentException if the
     * argument is null or blank.
     */
    public void setName(String name) {
        if (name == null || name.length() == 0) {
            // Throw exception if name is invalid
            throw new IllegalArgumentException("Name cannot be null or blank.");
        } else {
            this.name = name;
        }
    }

    /**
     * Creates a Rec1A object with the given name. Throws
     * IllegalArgumentException if the name is null or blank.
     */
    public Rec1A(String name) {
        if (name == null || name.length() == 0) {
            // Throw exception if name is invalid
            throw new IllegalArgumentException("Name cannot be null or blank.");
        } else {
            // Assign the argument value to the data member
            this.name = name;
            // Increment the count
            Rec1A.count++;
        }
    }

    /**
     * Test the Rec1A class by making several instances.
     */
    public static void main(String[] args) {
        // Note that count is accessed via the Rec1A class, not one of its
        // instances!
        System.out.println("Number of Rec1A objects created at start: " +
                Rec1A.count);

        Rec1A matilda = new Rec1A("Matilda");

        // Again, note this is not matilda.count
        System.out.println("Number of Rec1A objects created incl. Matilda: " +
                Rec1A.count);

        Rec1A lakshmi = new Rec1A("Lakshmi");
        Rec1A owen = new Rec1A("Owen");

        System.out.println("Number of Rec1A objects created after two more: " +
                Rec1A.count);

        // Note here that custom is another reference to the same object as
        // matilda!
        Rec1A custom = owen;

        System.out.println("Number of Rec1A objects created incl. custom: " +
                Rec1A.count);

        System.out.println();

        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter a new name: ");
        String name = stdin.nextLine();
        custom.setName(name);
        System.out.println();

        System.out.println("custom's name: " + custom.getName());
        System.out.println("matilda's name: " + matilda.getName());
        System.out.println("lakshmi's name: " + lakshmi.getName());
        System.out.println("owen's name: " + owen.getName());

    }

}

