package Input.Parsers;

import Data.Plateau;
import Input.Direction;
import Input.Instruction;
import Input.Position;
import com.sun.source.tree.LiteralTree;

import java.util.Arrays;
import java.util.stream.Collectors;

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

        if (input == null || input.length() > 7 || input.trim().isEmpty() || !input.matches("^\\d{1,2}\\s\\d{1,2}\\s[NSEW]$")) {
            throw new IllegalArgumentException("Please provide a valid input, e.g. 10 10 E");
        }

        String[] array = input.split(" ");

        int x = Integer.valueOf(array[0]);
        int y = Integer.valueOf(array[1]);
        Direction facing = Direction.valueOf(array[2]);

        return new Position(x, y, facing);
    }

    public static Instruction[] parseInstructions (String input) {

        if (input == null || input.length() > 15 || input.length() == 0 || input.trim().isEmpty() || !input.matches("^[LRM]{1,15}$")) {
            throw new IllegalArgumentException("Please provide a valid input, max 15 instructions.");
        }

        String [] array = input.split("");

        Instruction [] instructions = Arrays.stream(array)
                .map(s -> Instruction.valueOf(s))
                .toArray(Instruction[]::new);

        return instructions;
    }


}
