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

        for (Instruction instruction : instructions) {

            // Rotating rover

            if (instruction != Instruction.M) {
                this.position.setFacing(compass.rotate(this.position.getFacing(), instruction));
            } else {

                // Movement when facing North

                if (this.position.getFacing() == Direction.N) {
                    if (Plateau.getInstance().isPositionEmpty(this.position.getX() -1, this.position.getY()))
                    {
                        Plateau.getInstance().getPlateau()[this.position.getX()][this.position.getY()] = 0;
                        Plateau.getInstance().getPlateau()[this.position.getX()-1][this.position.getY()] = rover_ID;
                        this.position.setX(position.getX()-1);
                    } else {
                        throw new IllegalArgumentException("Position on your route is already occupied by another rover.");
                    }

                // Movement when facing West

                } else if (this.position.getFacing() == Direction.W) {

                    if (Plateau.getInstance().isPositionEmpty(this.position.getX(), this.position.getY() - 1))
                    {
                        Plateau.getInstance().getPlateau()[this.position.getX()][this.position.getY()] = 0;
                        Plateau.getInstance().getPlateau()[this.position.getX()][this.position.getY() - 1] = rover_ID;
                        this.position.setY(position.getY()-1);
                    } else {
                        throw new IllegalArgumentException("Position on your route is already occupied by another rover.");
                    }

                // Movement when facing South

                } else if (this.position.getFacing() == Direction.S) {

                    if (Plateau.getInstance().isPositionEmpty(this.position.getX() + 1, this.position.getY()))
                    {
                        Plateau.getInstance().getPlateau()[this.position.getX()][this.position.getY()] = 0;
                        Plateau.getInstance().getPlateau()[this.position.getX() + 1][this.position.getY()] = rover_ID;
                        this.position.setX(position.getX() + 1);
                    } else {
                        throw new IllegalArgumentException("Position on your route is already occupied by another rover.");
                    }

                // Movement when facing East

                } else if(this.position.getFacing() == Direction.E) {

                }


            }
        }


    }

}
