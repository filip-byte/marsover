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

        Compass compass = new Compass();

        Direction facing = Direction.N;
        Instruction turn = Instruction.L;
        Direction expectedOutput = Direction.W;

        Direction result = compass.rotate(facing, turn);

        assertEquals(expectedOutput, result);

    }

    @Test
    @Description("Method handles invalid input")
    void rotate_invalid_input() {

        Compass compass = new Compass();

        Direction facing = Direction.N;
        Instruction turn = Instruction.M;

        assertThrows(IllegalArgumentException.class, () -> compass.rotate(facing, turn));

    }

    @Test
    @Description("Method handles null input")
    void rotate_null_input() {

        Compass compass = new Compass();

        Direction facing = null;
        Instruction turn = null;

        assertThrows(IllegalArgumentException.class, () -> compass.rotate(Direction.N, turn));
        assertThrows(IllegalArgumentException.class, () -> compass.rotate(facing, Instruction.L));
        assertThrows(IllegalArgumentException.class, () -> compass.rotate(facing, turn));


    }

}