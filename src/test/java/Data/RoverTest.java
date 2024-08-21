package Data;

import Input.Direction;
import Input.Instruction;
import Input.Position;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @Description("Move method returns valid facing Direction for input of two turning Instructions")
    void move_Turn_Only() {

        Plateau.getInstance(5,5);

        Rover rover = new Rover(new Position(2,2, Direction.N), 1);
        Instruction[] turningOnly = {Instruction.L, Instruction.L };
        var expectedOutcome = Direction.S;

        rover.move(turningOnly);

        var result = rover.getPosition().getFacing();

        assertEquals(expectedOutcome, result);

    }

    @Test
    @Description("Method will test if the position is being updated accurately when facing North")
    void move_When_Facing_North() {

        Plateau.getInstance(5, 5);

        Rover rover1 = new Rover(new Position(4,4, Direction.N), 1);

        Instruction[] movingNorth = {Instruction.M};

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-------------------");

        rover1.move(movingNorth);
        assertEquals(1, Plateau.getInstance().getPlateau()[3][4]);

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        rover1.move(movingNorth);
        assertEquals(1, Plateau.getInstance().getPlateau()[2][4]);

        rover1.move(movingNorth);
        assertEquals(1, Plateau.getInstance().getPlateau()[1][4]);

        rover1.move(movingNorth);
        assertEquals(1, Plateau.getInstance().getPlateau()[0][4]);
    }

    @Test
    @Description("Method will test if the position is being updated accurately when going out of boundary")
    void move_too_far_when_facing_North() {

        Plateau.getInstance(5, 5);

        Rover rover1 = new Rover(new Position(4,4, Direction.N));

        Instruction[] movingTooFarNorth = {Instruction.M, Instruction.M, Instruction.M, Instruction.M, Instruction.M};

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-------------------");


        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        assertThrows(IllegalArgumentException.class, () -> rover1.move(movingTooFarNorth));
    }

    @Test
    @Description("Method will test if position is being updated when moving one position to the West")
    void move_facing_West() {

        Plateau.getInstance(5, 5);

        Rover rover1 = new Rover(new Position(2,2, Direction.W), 1);

        Instruction[] movingWest = {Instruction.M};

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-------------------");

        rover1.move(movingWest);

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        assertEquals(1, Plateau.getInstance().getPlateau()[2][1]);
    }

    @Test
    @Description("Method will test if the position is being updated accurately when going out of boundary")
    void move_too_far_when_facing_West() {

        Plateau.getInstance(5, 5);

        Rover rover1 = new Rover(new Position(2,2, Direction.N), 1);

        Instruction[] movingTooFarWest = {Instruction.M, Instruction.M, Instruction.M};

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-------------------");


        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        assertThrows(IllegalArgumentException.class, () -> rover1.move(movingTooFarWest));
    }

    @Test
    @Description("Method will test if position is being updated when moving South by one instruction")
    void move_facing_South() {

        Plateau.getInstance(5, 5);

        Rover rover1 = new Rover(new Position(2,2, Direction.S), 1);

        Instruction[] movingSouth = {Instruction.M};

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-------------------");

        rover1.move(movingSouth);

        for (int [] array : Plateau.getInstance().getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        assertEquals(1, Plateau.getInstance().getPlateau()[3][2]);
    }

}