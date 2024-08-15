package Input.Parsers;

import Data.Plateau;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @Description("Method breaks down the string into two integers")
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
    void parseStartingPosition() {
    }

    @Test
    void parseInstructions() {
    }
}