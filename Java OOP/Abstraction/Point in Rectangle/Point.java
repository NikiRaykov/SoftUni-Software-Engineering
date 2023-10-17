public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isGreatThanOrEqual(Point p){
        return x >= p.x && y >= p.y;
    }

    public boolean isLeesThanOrEqual (Point p){
        return x <= p.x && y <= p.y;
    }
}
