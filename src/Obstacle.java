import java.util.Scanner;

public class Obstacle {
    Scanner scanner = new Scanner(System.in);
    double area = 0;

    void defineArea(){

        System.out.println("Please input the shape of the obstacle: Rectangle (or Square), Circle, Triangle, Ellipse, Misc");
        String shape = scanner.nextLine().toLowerCase();
        switch(shape){
            case "rectangle","square" -> rectangleArea();
            case "circle" -> circleArea();
            case "triangle" -> triangleArea();
            case "elipse" -> ellipseArea();
            default -> miscArea();
        }
    }

    void rectangleArea(){
        System.out.println("Please enter the height of the obstacle");
        double height = scanner.nextDouble();
        System.out.println("Please enter the width of the obstacle");
        double width = scanner.nextDouble();
        this.area = height*width;
    }

    void circleArea(){
        System.out.println("Please enter the diameter of the obstacle");
        double diameter = scanner.nextDouble();
        this.area = Math.PI * ((diameter/2) * (diameter/2));
    }

    void triangleArea(){
        System.out.println("Please enter the height of the obstacle");
        double height = scanner.nextDouble();
        System.out.println("Please enter the length of the base of the obstacle");
        double width = scanner.nextDouble();
        this.area = height*width/2;

    }

    void ellipseArea(){
        System.out.println("Please enter the long radius");
        double longRadius = scanner.nextDouble();
        System.out.println("Please enter the short radius");
        double shortRadius = scanner.nextDouble();
        this.area = Math.PI * longRadius * shortRadius;

    }

    void miscArea(){
        System.out.println("Please enter the area of the obstacle");
        this.area = scanner.nextDouble();

    }
}
