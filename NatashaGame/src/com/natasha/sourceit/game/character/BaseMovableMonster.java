package com.natasha.sourceit.game.character;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.move.Direction;
import com.natasha.sourceit.game.move.DirectionOption;
import com.natasha.sourceit.game.move.Movable;
import com.natasha.sourceit.game.move.Mover;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * The last abstract character class in models
 * Speed property is still abstract. It will be defined as a constant for each final implementation
 */
public abstract class BaseMovableMonster extends BaseCharacter implements Monster, Movable {

    private Direction direction;

    /**
     * The counter for skipping game cycles according to speed.
     */
    private int speedCounter;

    private int attackPower;

    public BaseMovableMonster(int health, int attackPower) {
        super(health);
        this.attackPower = attackPower;
    }

    public BaseMovableMonster(int health, int attackPower, Point position) {
        super(health, position);
        this.attackPower = attackPower;
    }

    @Override
    public final int getAttackPower() {
        return attackPower;
    }

    protected abstract Attack getAttack();

    /******************************************************************
     * ATTACK target character IMPLEMENTATION !!!
     * @param car
     */
    public void attack(Character car) {
        if (health > 0) {
            getAttack().doAction(car);
        } else {
            throw new IllegalStateException("Already dead");
        }
    }

    @Override
    public boolean canMove() {
        return isAlive();
    }



    @Override
    public void moveToPosition(int x, int y) {
        position.setLocation(x, y);
    }



    /*************   Characxter moving IMPLEMENTATION!!!        ***********************/
    @Override
    public boolean moveOneStep(Mover mvr) {
        if (!canMove()) {
            throw new IllegalStateException("This character cannot move.");
        } else if (++speedCounter < getSpeed()) {
            //--- Check speed and skip syscle ------
            return false;
        } else {
            speedCounter = 0;
            moveInternal(mvr);
            return true;
        }
    }

    @Override
    public Direction getDirection() {
        return direction;
    }


    /**
     * REAL MOVING LOGIC!!!!!!
     * @param mvr
     */
    private void moveInternal(Mover mvr) {

        //----  Init direction ramdomly for the 1-st cycle   --------
        if (direction == null) {
            direction = selectRandomDirectionFromOptions(mvr.getAvailableDirections(position, null));
        }

        if (mvr.isEnemyNear(this)) {
            //Stand still, wait for fight!!!
            return;

        } else if (mvr.isPositionAvailable(position.x+direction.dx(), position.y+direction.dy())) {
            //  Destination cell is free -> move
            position.translate(direction.dx(), direction.dy());

        } else {
            // Destination cell is occupied -> ask for new directions,
            // select one of them randomly and move there
            direction = selectRandomDirectionFromOptions(mvr.getAvailableDirections(position, direction));
            position.translate(direction.dx(), direction.dy());
        }

    }

    /**
     * Select single direction from several options with probabilities
     * @param availableDirections
     * @return
     */
    private Direction selectRandomDirectionFromOptions(DirectionOption[] availableDirections) {


        int n = availableDirections.length;

        // Growing array of probabilities
        float[] probabilities = new float[n+1];
        for (int i=0, j=1; i<n; i++, j++) {
            probabilities[j] = probabilities[j-1] + availableDirections[i].getProbabilityPercent();
        }
        float rVal = rnd.nextFloat() * probabilities[n];
        System.out.println("Select direction: options="+ Arrays.toString(availableDirections)+",  random="+rVal);

        // Find the segment where a random value is and select direction related to this segment
        for (int j=1; j<=n; j++) {
            if (rVal > probabilities[j-1] && rVal <= probabilities[j]) {
                return availableDirections[j-1].getDirection();
            }
        }
        throw new RuntimeException("Error selecting direction: options="+ Arrays.toString(availableDirections)+",  random="+rVal);
    }
    Random rnd = new Random();
}
