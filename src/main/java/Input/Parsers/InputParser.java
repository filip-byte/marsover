package Input.Parsers;

import Data.Plateau;
import Input.Direction;
import Input.Instruction;
import Input.Position;

import java.util.Arrays;

public class InputParser {

    public static Plateau parsePlateauSize (String input) {
        int [] array = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Plateau.getInstance(array[0],array[1]);
    }

    public static Position parseStartingPosition (String input) {

        return new Position(1, 2, Direction.N);
    }

    public static Instruction[] parseInstructions (String input) {

        return new Instruction[0];
    }


}
