package Data;

public class Plateau {

    int width;
    int height;
    int [][] plateau;

    private static Plateau instance;

    private Plateau(int x, int y) {
        this.width = x;
        this.height = y;
        this.plateau = new int[x][y];
    }

    public static Plateau getInstance(int x, int y) {
        if (instance == null) {
            return new Plateau(x, y);
        }
        return instance;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
