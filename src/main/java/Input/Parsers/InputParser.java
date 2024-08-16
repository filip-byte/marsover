package Input.Parsers;

import Data.Plateau;
import Input.Direction;
import Input.Instruction;
import Input.Position;

import java.util.Arrays;

public class InputParser {

    private static final int PLATEAU_MAX_INPUT_LENGTH = 5;
    private static final int STARTING_POSITION_MAX_INPUT_LENGTH = 7;
    private static final int INSTRUCTIONS_MAX_INPUT_LENGTH = 5;

    public static Plateau parsePlateau(String input) {

        if (input == null || input.length() > PLATEAU_MAX_INPUT_LENGTH || input.trim().isEmpty() || !input.matches("^\\d{1,2}\\s\\d{1,2}$")) {
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

        if (input == null || input.length() > STARTING_POSITION_MAX_INPUT_LENGTH || input.trim().isEmpty() || !input.matches("^\\d{1,2}\\s\\d{1,2}\\s[NSEW]$")) {
            throw new IllegalArgumentException("Please provide a valid input, e.g. 10 10 E");
        }

        String[] array = input.split(" ");

        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        Direction facing = Direction.valueOf(array[2]);

        return new Position(x, y, facing);
    }

    public static Instruction[] parseInstructions (String input) {

        if (input == null || input.length() > INSTRUCTIONS_MAX_INPUT_LENGTH || input.length() == 0 || input.trim().isEmpty() || !input.matches("^[LRM]{1,15}$")) {
            throw new IllegalArgumentException("Please provide a valid input, max 15 instructions.");
        }

        String [] array = input.split("");

        Instruction [] instructions = Arrays.stream(array)
                .map(Instruction::valueOf)
                .toArray(Instruction[]::new);

        return instructions;
    }


}
