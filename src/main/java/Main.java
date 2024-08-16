import Data.Plateau;
import Input.Direction;
import Input.Position;
import Logic.MissionControl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Plateau plateau = Plateau.getInstance(5,5);

        int[][] rover1Position = plateau.getPlateau();

        int [] rover1 = new int[]{2,2};

        for (int i = 0; i < 2; i++) {
            rover1Position [rover1[0]][rover1[1]] = 1;
        }

        for (int[] array : plateau.getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("------------------");

        for (int i = 0; i < plateau.getWidth(); i++) {
            for (int j = 0; j < plateau.getHeight(); j++) {
                if (plateau.getPlateau()[i][j] == 1) {
                    System.out.println("Position x of the rover_ONE is: " + i + ", and position y is: " + j);
                }
            }

        }

        int[][] rover2Position = plateau.getPlateau();

        int [] rover2 = new int[]{3,3};

        for (int i = 0; i < 2; i++) {
            rover2Position [rover2[0]][rover2[1]] = 2;
        }

        System.out.println("------------------");

        for (int[] array : plateau.getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        for (int i = 0; i < plateau.getWidth(); i++) {
            for (int j = 0; j < plateau.getHeight(); j++) {
                if (plateau.getPlateau()[i][j] == 2) {
                    System.out.println("Position x of the rover_TWO is: " + i + ", and position y is: " + j);
                }
            }

        }



    }
}
