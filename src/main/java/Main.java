import Data.Plateau;
import Logic.MissionControl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Plateau plateau = Plateau.getInstance(5,10);
        System.out.println(Arrays.deepToString(plateau.getPlateau()));

    }
}
