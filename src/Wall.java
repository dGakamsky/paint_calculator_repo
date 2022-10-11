public class Wall {
    double height;
    double width;

    public double wallArea(){
        return this.width * this.height;
    }

    Wall(double height, double width){
        this.height = height;
        this.width = width;
    }

}
