package Input.Parsers;

import Input.Direction;
import Input.Instruction;
import Input.Position;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @Description("Method creates a Plateau when valid input is provided")
    void parsePlateauSize() {
        //Arrange
        String input1 = "25 10";
        int expectedOutcome1 = 10;

        //Act
        var result1 = InputParser.parsePlateau(input1);

        //Assert
        assertEquals(expectedOutcome1, result1.getHeight());
    }

    @Test
    @Description("Method handles invalid input")
            void parsePlateauSize_Test_Invalid_input() {
        //Arrange
        String oneNumberOnly = "2510";
        String emptyString = " ";
        String nullString = null;
        String tooLong = "123 456";
        String incorrectFormat = "22 X 22";

        var expectedOutcome = IllegalArgumentException.class;

        //Act & Assert
        assertThrows(expectedOutcome, () -> InputParser.parsePlateau(oneNumberOnly));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateau(emptyString));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateau(nullString));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateau(tooLong));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateau(incorrectFormat));

    }

    @Test
    @Description("Method returns an exception if array to be created is smaller than 2 x 2")
    void testBelowMinimumSize() {
        //Arrange
        String input = "1 1";

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> InputParser.parsePlateau(input));

    }

    @Test
    @Description("Method returns a Position for valid input")
    void parseStartingPosition() {

        // Arrange
        String validInput = "12 15 N";
        Position expectedOutcome = new Position(12, 15, Direction.N);

        String validInput2 = "85 43 W";
        Position expectedOutcome2 = new Position(85, 43, Direction.W);

        //Act
        Position result = InputParser.parseStartingPosition(validInput);
        Position result2 = InputParser.parseStartingPosition(validInput2);

        //Assert
        assertAll(
                () -> assertEquals(expectedOutcome.getFacing(), result.getFacing()),
                () -> assertEquals(expectedOutcome.getX(), result.getX()),
                () -> assertEquals(expectedOutcome.getY(), result.getY())
        );

        assertAll(
                () -> assertEquals(expectedOutcome2.getFacing(), result2.getFacing()),
                () -> assertEquals(expectedOutcome2.getX(), result2.getX()),
                () -> assertEquals(expectedOutcome2.getY(), result2.getY())
        );
    }

        @Test
        @Description("Method handles invalid input")
        void parseStartingPosition_Test_Invalid_input() {
            //Arrange
            String oneNumberOnly = "1234 N";
            String emptyString = " ";
            String nullString = null;
            String tooLong = "123 456 N";
            String incorrectFormat = "22 X 22 N";
            String incorrectFormat2 = "22 22 NW";

            var expectedOutcome = IllegalArgumentException.class;

            //Act & Assert
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(oneNumberOnly));
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(emptyString));
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(nullString));
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(tooLong));
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(incorrectFormat));
            assertThrows(expectedOutcome, () -> InputParser.parseStartingPosition(incorrectFormat2));

        }

    @Test
    void parseInstructions_With_Valid_Input() {

        String inputWithDigits = "LRM123LRM";
        String emptyString = " ";
        String nullString = null;
        String tooLong = "LRMLRMLRMLRMLRML";
        String incorrectFormat = "L R M";
        String incorrectFormat2 = "123";

        var expectedOutcome = IllegalArgumentException.class;

        //Act & Assert
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(inputWithDigits));
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(emptyString));
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(nullString));
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(tooLong));
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(incorrectFormat));
        assertThrows(expectedOutcome, () -> InputParser.parseInstructions(incorrectFormat2));

    }

    @Test
    @Description("Returns an array of Instructions when valid input provided.")
    void parseInstructionsTest() {
        String input = "LMRM";
        Instruction []  expectedOutcome = new Instruction [] {Instruction.L, Instruction.M, Instruction.R, Instruction.M};

        var result = InputParser.parseInstructions(input);

        assertEquals(expectedOutcome.length, result.length);
        assertEquals(expectedOutcome[0], result[0]);
        assertEquals(expectedOutcome[1], result[1]);
        assertEquals(expectedOutcome[2], result[2]);
        assertEquals(expectedOutcome[3], result[3]);
    }
}