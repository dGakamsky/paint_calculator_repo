
public class Room {
    double width;
    double height;
    double length;
    Wall[] roomWalls = new Wall[4];

    Ceiling roomCeiling = new Ceiling(0,0);

    Room(double width, double height, double length){
        this.width = width;
        this.height = height;
        this.length = length;
        roomCeiling.width = this.width;
        roomCeiling.length = this.length;
        makeWalls();
    }

    private void makeWalls(){
        this.roomWalls[0] = new Wall(this.height, this.width);
        this.roomWalls[1] = new Wall(this.height, this.width);
        this.roomWalls[2] = new Wall(this.height, this.length);
        this.roomWalls[3] = new Wall(this.height, this.length);
    }

    public double getWallArea(){
        double area = 0;
        for (Wall wall : roomWalls){
            area += wall.wallArea();
        }
        return area;
    }
}
