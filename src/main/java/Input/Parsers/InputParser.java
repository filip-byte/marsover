package Input.Parsers;

import Data.Plateau;
import Input.Direction;
import Input.Instruction;
import Input.Position;

import java.util.Arrays;

public class InputParser {

    public static Plateau parsePlateauSize (String input) {

        if (input == null || input.length() > 5 || input.trim().isEmpty() || !input.matches("^\\d{1,2}\\s\\d{1,2}$")) {
            throw new IllegalArgumentException("Please provide a valid input. Maximum size of the plateau is 99 x 99");
        }


        int[] array = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (array[0] <2 || array[1] <2) {
            throw new IllegalArgumentException("Minimum size of the Plateau is 2 x 2");
        }

        return Plateau.getInstance(array[0],array[1]);
    }

    public static Position parseStartingPosition (String input) {

        return new Position(1, 2, Direction.N);
    }

    public static Instruction[] parseInstructions (String input) {

        return new Instruction[0];
    }


}
