import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {
    public static void main(String[] args) {

        String[] acceptedPaints = {"cheap", "medium", "expensive"};
        List<String> acceptedPaintsList = new ArrayList<>(Arrays.asList(acceptedPaints));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room width");
        double roomWidth = scanner.nextDouble();
        System.out.println("Enter room Length");
        double roomLength = scanner.nextDouble();
        System.out.println("Enter room Height");
        double roomHeight = scanner.nextDouble();
        System.out.println("would you like Cheap, Medium or Expensive paint?");
        String paint = scanner.next().toLowerCase();
        while (!acceptedPaintsList.contains(paint)){
            System.out.println("Please enter a valid paint");
            System.out.println("Valid paints are: Cheap, Medium, Expensive");
            paint = scanner.next().toLowerCase();
        }

        System.out.println("how many obstacles are there in the room");
        Obstacle[] obstacles = new Obstacle[scanner.nextInt()];
        for (Obstacle obstacle : obstacles){
            System.out.println("please define the area of the next obstacle");
            obstacle.defineArea();
        }


        calculateCost(roomWidth,roomHeight,roomLength,paint, obstacles);
        //calculateCostSimple();

    }

    public static void calculateCost(double width, double height, double length, String paint, Obstacle[] obstacles)
    {
        Room room = new Room(width,height,length);
        double ceilingArea = room.roomCeiling.ceilingArea();
        System.out.println("the area of the ceiling is: " + ceilingArea + " metres square");
        double wallArea = room.getWallArea();
        System.out.println("the area of the walls is: " + wallArea + " metres square");
        double obstacleArea = 0;
        for(Obstacle obstacle : obstacles) {
            obstacleArea += obstacle.area;
        }
        double totalArea = ceilingArea + wallArea - obstacleArea;
        System.out.println("The total area that would need painted is: " + totalArea + " metres square");

        double metresPaintedPerHour = 4;
        double hourlyRate = 10.5;
        double hoursOfWork = totalArea / metresPaintedPerHour;
        double salary = hourlyRate * hoursOfWork;
        System.out.println("The total cost of paying the painted would be: £" + salary);

        double costOfLitre = switch(paint) {
            case "cheap" -> 4;
            case "medium" -> 21.6;
            case "expensive" -> 208.3;
            default -> 0;
        };

        double litresNeeded = Math.ceil(totalArea/6);
        System.out.println("The total litres needed is: " + litresNeeded);
        double costOfPaint = litresNeeded * costOfLitre;
        System.out.println("The total cost of the paint would be: £" + costOfPaint);

        double totalCost = salary + costOfPaint;
        System.out.println("The total cost of having the room painted would come out to: £" + totalCost);


    }

    public static void calculateCostSimple()
    {
        int wall_1 = 4;
        int wall_2 = 3;
        int wall_3 = 4;
        int wall_4 = 2;
        int ceiling = 4;

        int[] roomSurfaces = {wall_1, wall_2, wall_3, wall_4, ceiling};

        int totalArea = 0;

        for (int roomSurface : roomSurfaces) {
            totalArea += roomSurface;
        }
        System.out.println("the total surface area of the room is: " + totalArea + " metres squared");

        int costOfPaintPerMetre = 3;
        int costToPaintRoom = totalArea * costOfPaintPerMetre;

        System.out.println(("As such it would cost £" + costToPaintRoom + " to paint the room"));
    }
}