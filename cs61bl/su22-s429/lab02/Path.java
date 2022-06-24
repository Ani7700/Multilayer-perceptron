/** A class that represents a path via pursuit curves. */
public class Path extends Point {
    private double x;
    private double y;
    Path curr;
    Path next;

    public Path(double x, double y) {

        assert this.next != null;
        this.next.x=x;
        this.next.y=y;
        this.curr.x=1;
        this.curr.y=8;

    }
    public double getCurrX(){

        return this.curr.x;

    }
    public double getCurrY(){

        return this.curr.y;

    }
    public double getNextX(){

        return this.next.x;

    }
    public double getNextY(){

        return this.next.y;

    }
    public Point getCurrentPoint(){

        return curr;

    }
    public void setCurrentPoint(Point point){

        point=curr;

    }
    public void iterate(double dx,double dy){

        next=curr;
        next.x=next.x+dx;
        next.y=next.y+dy;

    }
}