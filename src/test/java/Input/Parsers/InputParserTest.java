package Input.Parsers;

import Data.Plateau;
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
        var result1 = InputParser.parsePlateauSize(input1);

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
        assertThrows(expectedOutcome, () -> InputParser.parsePlateauSize(oneNumberOnly));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateauSize(emptyString));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateauSize(nullString));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateauSize(tooLong));
        assertThrows(expectedOutcome, () -> InputParser.parsePlateauSize(incorrectFormat));

    }

    @Test
    @Description("Method returns an exception if array to be created is smaller than 2 x 2")
    void testBelowMinimumSize() {
        //Arrange
        String input = "1 1";

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> InputParser.parsePlateauSize(input));

    }








    @Test
    void parseStartingPosition() {
    }

    @Test
    void parseInstructions() {
    }
}