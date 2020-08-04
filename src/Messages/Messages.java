package Messages;

public class Messages {
    public static void invalidInput(){
        System.out.println("Invalid input.  Try again.");
    }

    public static void getRow(){
        System.out.println("Enter row:");
    }

    public static void getColumn(){
        System.out.println("Enter column:");
    }

    public static void locationInvalid(){
        System.out.println("Location not available.  Please try again.");
    }

    public static void squirrelLocation() {
        System.out.println("Now you must determine the squirrel's starting location.");
    }

    public static void movementDirections() {
        StringBuilder sb = new StringBuilder();
        sb.append("Press W to move up");
        sb.append("\nPress A to move left");
        sb.append("\nPress S to move down");
        sb.append("\nPress D to move right");
        System.out.println(sb.toString());
    }
}
