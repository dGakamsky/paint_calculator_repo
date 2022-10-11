public class Ceiling {
    double width;
    double length;

    public double ceilingArea(){
        return this.width * this.length;
    }

    Ceiling(double width, double length){
        this.width = width;
        this.length = length;
    }
}
