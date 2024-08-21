import Data.Plateau;
import Data.Rover;
import Input.Direction;
import Input.Instruction;
import Input.Position;
import Logic.MissionControl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Plateau plateau = Plateau.getInstance(11,11);

        Rover rover1 = new Rover(new Position(5, 5, Direction.N) , 1);
        Rover rover2 = new Rover(new Position(3, 8, Direction.W) , 2);

        for (int[] array : plateau.getPlateau()) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("---------------------------");

        rover1.move(new Instruction[]{Instruction.M,Instruction.M, Instruction.M, Instruction.M, Instruction.M});
        rover2.move(new Instruction[]{Instruction.M,Instruction.M, Instruction.M, Instruction.M, Instruction.M, Instruction.M, Instruction.M, Instruction.M});

        for (int[] array : plateau.getPlateau()) {
            System.out.println(Arrays.toString(array));
        }




    }
}
