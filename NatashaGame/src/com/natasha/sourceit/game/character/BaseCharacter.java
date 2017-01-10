package com.natasha.sourceit.game.character;

import com.natasha.sourceit.game.drawing.DrawingSurface;
import com.natasha.sourceit.game.drawing.DrawingUtils;

import java.awt.*;


public abstract class BaseCharacter implements Character, Displayable {

    public static final char DEAD_CHARACTER_SYMBOL = DrawingUtils.ASCII_197;

    protected int health;
    protected Point position;

    /**
     * The initPositionOnce() method can be called only once
     */
    private boolean initPositionCalled;

    public BaseCharacter(int health) {
        this(health, new Point(0, 0));
    }

    public BaseCharacter(int health, Point position) {
        this.position = position;
        this.health = health;
    }

    @Override
    public void drawOnMap(DrawingSurface sf, Point playgroundOffset) {
        //---  Draw character on display using symbol provided by final implementation -----
        //---  If character is dead - special symbol is used  ------------------------------
        char symbol = isAlive() ? getCharCode() : DEAD_CHARACTER_SYMBOL;
        sf.draw(playgroundOffset.x + position.x, playgroundOffset.y + position.y, symbol);
    }

    public final void modifyHealth(int val) {
        if (health > 0) {
            this.health += val;
            if(this.health < 0) {
                System.out.println(getClass().getName() + " is DEAD");
            }
        } else {
            throw new IllegalStateException(getClass().getName() + " is already dead");
        }
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void initPositionOnce(Point position) {
        if (!initPositionCalled) {
            initPositionCalled = true;
            this.position.setLocation(position);
        } else {
            throw new IllegalStateException("Already initialized");
        }
    }




    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Cannot move yet because it is not Movable!!!!
     * @return
     */
    @Override
    public boolean canMove() {
        return false;
    }
}
