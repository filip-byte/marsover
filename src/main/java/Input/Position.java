package Input;

public class Position {
    private int x;
    private int y;
    private Directions facing;

    public Position(int x, int y, Directions facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Directions getFacing() {
        return facing;
    }

    public void setFacing(Directions facing) {
        this.facing = facing;
    }
}
