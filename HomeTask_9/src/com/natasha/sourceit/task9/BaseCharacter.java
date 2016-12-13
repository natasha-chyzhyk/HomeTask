package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public abstract class BaseCharacter implements Character{
    private int health;
    public BaseCharacter(int health) {
        this.health = health;
    }

    public final void modifyHealth(int val) {
        this.health += val;
        if(this.health < 0) {
            this.health = 0;
            System.out.println(getClass().getName() + " is DEAD");
        }
    }

    public final void doAction(CharacterAction action){
        //implementing default algorithm for doing any action and making it immutable
        if(canDoAction(action) && health > 0) {
            action.doAction();
        }
    }

    public final int getHealth() {
        return this.health;
    }

    public final boolean isNpc() {
        return Npc.class.isAssignableFrom(this.getClass());
    }

    public final boolean canMove() {
        return Movable.class.isAssignableFrom(this.getClass());
    }

    protected boolean canFly(Object o){
        return Flying.class.isAssignableFrom(o.getClass());
    }

    protected boolean canSwim(Object o) {
        return Swimming.class.isAssignableFrom(o.getClass());
    }
}
