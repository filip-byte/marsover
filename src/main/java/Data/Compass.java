package Data;

import Input.Direction;
import Input.Instruction;
import Input.Position;

public class Compass {

    public static Direction rotate (Direction facing, Instruction turn) {

        if (facing == Direction.N){
            switch (turn) {
                case L:
                    facing = Direction.W;
                    break;
                case R:
                    facing = Direction.E;
                    break;
            }
        } else if (facing == Direction.E){
            switch (turn) {
                case L:
                    facing = Direction.N;
                    break;
                case R:
                    facing = Direction.S;
                    break;
            }
        } else if (facing == Direction.W){
            switch (turn) {
                case L:
                    facing = Direction.S;
                    break;
                case R:
                    facing = Direction.N;
                    break;
            }
        }else if (facing == Direction.S){
            switch (turn) {
                case L:
                    facing = Direction.E;
                    break;
                case R:
                    facing = Direction.W;
                    break;
            }
        }

        return facing;

    }

}
