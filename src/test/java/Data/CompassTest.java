package Data;

import Input.Direction;
import Input.Instruction;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test
    @Description("Method returns valid Direction for valid input")
    void rotate() {


        Direction facing = Direction.N;
        Instruction turn = Instruction.L;
        Direction expectedOutput = Direction.W;

        Direction result = Compass.rotate(facing, turn);

        assertEquals(expectedOutput, result);

    }

    @Test
    @Description("Method handles edge cases")
    void rotate_edge_cases() {


        Direction facing = Direction.N;
        Instruction turn = Instruction.L;
        Direction expectedOutput = Direction.W;

        Direction result = Compass.rotate(facing, turn);

        assertEquals(expectedOutput, result);

    }

}