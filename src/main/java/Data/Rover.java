package Data;

import Input.Direction;
import Input.Instruction;
import Input.Position;

public class Rover {
    private Position position;
    private int rover_ID;

    private Compass compass = new Compass();

    public Rover(Position position, int rover_ID) {
        this.position = position;
        this.rover_ID = rover_ID;
        if (Plateau.getInstance().isPositionEmpty(position.getX(), position.getY())) {
            Plateau.getInstance().getPlateau()[position.getX()][position.getY()] = rover_ID;
        } else {
            throw new IllegalArgumentException("This position is not available.");
        }
    }

    public Rover(Position position) {
        this.position = position;
        if (Plateau.getInstance().isPositionEmpty(position.getX(), position.getY())) {
            Plateau.getInstance().getPlateau()[position.getX()][position.getY()] = 1;
        } else {
            throw new IllegalArgumentException("This position is not available.");
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getRover_ID() {
        return rover_ID;
    }

    public void setRover_ID(int rover_ID) {
        this.rover_ID = rover_ID;
    }

    public int[] currentPosition() {
        return new int[]{this.position.getX(), this.position.getY()};
    }

    public void move (Instruction[] instructions) {

        // this method provides a set of instructions
        // it will have to handle each of the instructions one by one
        // if instruction is L or R,
        // it will take a compass and adjust facing position parameter accordingly
        // if it is an M
        // based on facing, it will want to move one field in that direction
            // if N then we decrease the column parameter by one
            // if S, then we increase the column parameter by one
            // therefore
            // if W then we increase the row parameter by one
            // if E then we decrease the row parameter by one
            //
            // once we know the new location
            // we check Plateau if the position is empty
        // if it isn't empty it will throw an error
        // if it is empty, the position will be updated.

        for (Instruction instruction : instructions) {
            if (instruction != Instruction.M) {
                this.position.setFacing(compass.rotate(this.position.getFacing(), instruction));
            } else {
                if (this.position.getFacing() == Direction.N) {
                    if (Plateau.getInstance().isPositionEmpty(this.position.getX() -1, this.position.getY()))
                    {
                        Plateau.getInstance().getPlateau()[this.position.getX()][this.position.getY()] = 0;
                        Plateau.getInstance().getPlateau()[this.position.getX()-1][this.position.getY()] = rover_ID;
                        this.position.setX(position.getX()-1);
                    } else {
                        System.out.println("Position on your route is already occupied!");
                        throw new IllegalArgumentException("No sorry, no.");
                    }
                } else if (this.position.getFacing() == Direction.W) {

                } else if (this.position.getFacing() == Direction.S) {

                } else if(this.position.getFacing() == Direction.E) {

                }


            }
        }


    }

}
