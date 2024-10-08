package Data;

public class Plateau {

    int width;
    int height;
    int [][] plateau;

    private static Plateau instance = null;

    private Plateau(int x, int y) {
        this.width = x;
        this.height = y;
        this.plateau = new int[x][y];
    }

    public static Plateau getInstance(int x, int y) {
        if (instance == null) {
            instance = new Plateau(x, y);
        }
        return instance;
    }

    public static Plateau getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Plateau dimensions need to be provided");
        }
        return instance;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return width + " " + height;
    }

    public boolean isPositionEmpty (int row, int column) {

        if (row < 0 ) {
            throw new IllegalArgumentException("Player got sucked by a Wormhole of the North");
        }

        if (column < 0 ) {
            throw new IllegalArgumentException("Player got sucked by a Wormhole of the West");
        }

        if (row >= getHeight() ) {
            throw new IllegalArgumentException("Player got sucked by a Wormhole of the South");
        }

        if (row >= getHeight() ) {
            throw new IllegalArgumentException("Player got sucked by a Wormhole of the East");
        }

        return getPlateau()[row][column] == 0;
    }


}
