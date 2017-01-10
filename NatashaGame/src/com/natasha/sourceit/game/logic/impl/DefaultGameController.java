package com.natasha.sourceit.game.logic.impl;

import com.natasha.sourceit.game.character.BaseCharacter;
import com.natasha.sourceit.game.character.BaseCharacterList;
import com.natasha.sourceit.game.character.BaseMovableMonster;
import com.natasha.sourceit.game.character.Monster;
import com.natasha.sourceit.game.drawing.DrawingSurface;
import com.natasha.sourceit.game.logic.GameService;
import com.natasha.sourceit.game.map.GameField;
import com.natasha.sourceit.game.move.Direction;
import com.natasha.sourceit.game.move.DirectionOption;
import com.natasha.sourceit.game.move.Movable;
import com.natasha.sourceit.game.move.Mover;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Game logic implementation
 */
public class DefaultGameController implements GameService, Mover {

    /**
     * Screen to draw the game on
     */
    private DrawingSurface surface;

    /**
     * GAME MAP
     */
    private GameField map;

    /**
     * All Characters
     */
    BaseCharacterList characters = new BaseCharacterList();

    public DefaultGameController(GameField map) {
        this.map = map;
    }




    /*************************************  GameService implementation  ***********************************************/

    @Override
    public void setDrawingSurface(DrawingSurface surface) {
        this.surface = surface;
    }

    @Override
    public void populateCharacters(List<BaseCharacter> characters) {
        this.characters.clear();
        for (BaseCharacter c : characters) {
            putCharacterOnMap(c);
        }
    }

    /**
     * PLace new character in a random position on the map
     * taking into account positions of already placed characters
     * @param character
     */
    private void putCharacterOnMap(BaseCharacter character) {
        Point candidate;
        do {
            candidate = map.getRandomFreePosition();
            for (BaseCharacter c : this.characters) {
                if (c.getPosition().equals(candidate)) {
                    candidate = null;
                    break;
                }
            }
        } while (candidate == null);
        character.initPositionOnce(candidate);
        this.characters.add(character);
    }


    /**
     * MAKE THE GAME!!!!!!!!!!!!!!!!!!!
     */
    @Override
    public void calculateNextStep() {
        //---  make fight  ---
        List<BaseCharacter> targets = new ArrayList<>();
        for (BaseCharacter car : characters) {
            if (car.isAlive() && (car instanceof Monster)) {
                for (BaseCharacter target : characters.getCharactersNear(car, targets)) {
                    if (target.isAlive()) {
                        ((Monster) car).attack(target);
                        if (!target.isAlive()) {
                            map.addWall(target.getPosition());
                        }
                    }
                }
            }
        }

        //--- all characters move next step ---
        for (BaseCharacter c : characters) {
            if ((c.canMove()) && (c instanceof BaseMovableMonster)) {
                ((BaseMovableMonster) c).moveOneStep(this);
            }
        }
    }


    /**
     * Draw full GAME!!!!!!!!!!!!!!!!!
     */
    @Override
    public void drawScene() {
        if (surface != null) {
            //Clear virtual screen
            surface.clear();

            // Draw maP
            map.drawSelf(surface);

            // Draw characters
            drawAllCharacters();

            // Clear phisicl screen
            surface.clearScreen();

            // Move content from virtual to physical scren
            surface.printOnScreen();
        }
    }

    private void drawAllCharacters() {
        for (BaseCharacter c : characters) {
            c.drawOnMap(surface, map.getPlaygroundOffset());
        }
    }


    /*******************************   Mover Implementation   *********************************************************/

    @Override
    public boolean isPositionAvailable(int x, int y) {
        return map.isPositionFree(x, y) && (getCharacterInPosition(x, y) == null);
    }

    public BaseCharacter getCharacterInPosition(int x, int y) {
        for (BaseCharacter c : characters) {
            if (c.getPosition().x == x && c.getPosition().y == y) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean isEnemyNear(Movable mObj) {
        for (BaseCharacter c : characters) {
            if ((c != mObj) && c.isAlive() && (mObj.getPosition().distance(c.getPosition()) < 1.42)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Switch current moving direction
     * @param p
     * @param currentDirection
     * @return
     */
    @Override
    public DirectionOption[] getAvailableDirections(Point p, Direction currentDirection) {
        List<DirectionOption> optDirs = new ArrayList<>();
        if (currentDirection != null) {
            switch (currentDirection) {
                case DIR_N:
                    optDirs = createOptionsForN(p);
                    break;
                case DIR_NE:
                    optDirs = createOptionsForNE(p);
                    break;
                case DIR_E:
                    optDirs = createOptionsForE(p);
                    break;
                case DIR_SE:
                    optDirs = createOptionsForSE(p);
                    break;
                case DIR_S:
                    optDirs = createOptionsForS(p);
                    break;
                case DIR_SW:
                    optDirs = createOptionsForSW(p);
                    break;
                case DIR_W:
                    optDirs = createOptionsForW(p);
                    break;
                case DIR_NW:
                    optDirs = createOptionsForNW(p);
                    break;

            }
        } else {
            optDirs = createAllDirections();
        }
        return evaluateOptionalDirections(optDirs, p);
    }

    private List<DirectionOption> createOptionsForN(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(5);
        if ((currPos.y-1 >= 0) && map.isPositionFree(currPos.x, currPos.y-1)) {
            opts.add(new DirectionOption(Direction.DIR_N, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_S, 30f));
            opts.add(new DirectionOption(Direction.DIR_SE, 25f));
            opts.add(new DirectionOption(Direction.DIR_SW, 25f));
            opts.add(new DirectionOption(Direction.DIR_E, 10f));
            opts.add(new DirectionOption(Direction.DIR_W, 10f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForNE(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(7);
        int nextX = currPos.x + 1;
        int nextY = currPos.y - 1;

        if ((nextX < map.getPlaygroundW()) && (nextY >= 0) && map.isPositionFree(nextX, nextY)) {
            opts.add(new DirectionOption(Direction.DIR_NE, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_N, 25f));
            opts.add(new DirectionOption(Direction.DIR_E, 25f));
            opts.add(new DirectionOption(Direction.DIR_NW, 20f));
            opts.add(new DirectionOption(Direction.DIR_SE, 20f));
            opts.add(new DirectionOption(Direction.DIR_W, 4f));
            opts.add(new DirectionOption(Direction.DIR_S, 4f));
            opts.add(new DirectionOption(Direction.DIR_SW, 2f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForE(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(5);
        if ((currPos.x+1 < map.getPlaygroundW()) && map.isPositionFree(currPos.x+1, currPos.y)) {
            opts.add(new DirectionOption(Direction.DIR_E, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_W, 30f));
            opts.add(new DirectionOption(Direction.DIR_NW, 25f));
            opts.add(new DirectionOption(Direction.DIR_SW, 25f));
            opts.add(new DirectionOption(Direction.DIR_N, 10f));
            opts.add(new DirectionOption(Direction.DIR_S, 10f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForSE(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(7);
        int nextX = currPos.x + 1;
        int nextY = currPos.y + 1;

        if ((nextX < map.getPlaygroundW()) && (nextY < map.getPlaygroundH()) && map.isPositionFree(nextX, nextY)) {
            opts.add(new DirectionOption(Direction.DIR_SE, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_S, 25f));
            opts.add(new DirectionOption(Direction.DIR_E, 25f));
            opts.add(new DirectionOption(Direction.DIR_NE, 20f));
            opts.add(new DirectionOption(Direction.DIR_SW, 20f));
            opts.add(new DirectionOption(Direction.DIR_N, 4f));
            opts.add(new DirectionOption(Direction.DIR_W, 4f));
            opts.add(new DirectionOption(Direction.DIR_NW, 2f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForS(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(5);
        if ((currPos.y+1 < map.getPlaygroundH()) && map.isPositionFree(currPos.x, currPos.y+1)) {
            opts.add(new DirectionOption(Direction.DIR_S, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_N, 30f));
            opts.add(new DirectionOption(Direction.DIR_NW, 25f));
            opts.add(new DirectionOption(Direction.DIR_NE, 25f));
            opts.add(new DirectionOption(Direction.DIR_E, 10f));
            opts.add(new DirectionOption(Direction.DIR_W, 10f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForSW(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(7);
        int nextX = currPos.x - 1;
        int nextY = currPos.y + 1;

        if ((nextX >= 0) && (nextY < map.getPlaygroundH()) && map.isPositionFree(nextX, nextY)) {
            opts.add(new DirectionOption(Direction.DIR_SW, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_S, 25f));
            opts.add(new DirectionOption(Direction.DIR_W, 25f));
            opts.add(new DirectionOption(Direction.DIR_SE, 20f));
            opts.add(new DirectionOption(Direction.DIR_NW, 20f));
            opts.add(new DirectionOption(Direction.DIR_E, 4f));
            opts.add(new DirectionOption(Direction.DIR_N, 4f));
            opts.add(new DirectionOption(Direction.DIR_NE, 2f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForW(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(5);
        if ((currPos.x-1 >= 0) && map.isPositionFree(currPos.x-1, currPos.y)) {
            opts.add(new DirectionOption(Direction.DIR_W, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_E, 30f));
            opts.add(new DirectionOption(Direction.DIR_SE, 25f));
            opts.add(new DirectionOption(Direction.DIR_NE, 25f));
            opts.add(new DirectionOption(Direction.DIR_N, 10f));
            opts.add(new DirectionOption(Direction.DIR_S, 10f));
        }
        return opts;
    }

    private List<DirectionOption> createOptionsForNW(Point currPos) {
        List<DirectionOption> opts = new ArrayList<>(7);
        int nextX = currPos.x - 1;
        int nextY = currPos.y - 1;

        if ((nextX >= 0) && (nextY >= 0) && map.isPositionFree(nextX, nextY)) {
            opts.add(new DirectionOption(Direction.DIR_NW, 100f));
        } else {
            opts.add(new DirectionOption(Direction.DIR_N, 25f));
            opts.add(new DirectionOption(Direction.DIR_W, 25f));
            opts.add(new DirectionOption(Direction.DIR_NE, 20f));
            opts.add(new DirectionOption(Direction.DIR_SW, 20f));
            opts.add(new DirectionOption(Direction.DIR_S, 4f));
            opts.add(new DirectionOption(Direction.DIR_E, 4f));
            opts.add(new DirectionOption(Direction.DIR_SE, 2f));
        }
        return opts;
    }

    List<DirectionOption> createAllDirections() {
        List<DirectionOption> opts = new ArrayList<>(8);
        opts.add(new DirectionOption(Direction.DIR_N, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_NE, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_E, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_SE, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_S, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_SW, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_W, 15.5f));
        opts.add(new DirectionOption(Direction.DIR_NW, 15.5f));
        return opts;
    }


    /**
     * Check if there are more wall which make some of options unavailable.
     * @param optDirs
     * @param p
     * @return
     */
    private DirectionOption[] evaluateOptionalDirections(List<DirectionOption> optDirs, Point p) {

        //---  Check each option direction to see if it is available  -----
        List<DirectionOption> validOpts = new ArrayList<>(optDirs.size());
        for (DirectionOption option : optDirs) {
            if (map.isPositionFree(p.x + option.getDirection().dx(), p.y + option.getDirection().dy())) {
                validOpts.add(option);
            }
        }

        //---  Recalculate probabilities proportionally. Make sum of probs = 100%
        if (validOpts.size() < optDirs.size()) {
            float sumValid = 0;
            for (DirectionOption option : validOpts) {
                sumValid += option.getProbabilityPercent();
            }
            float k = 100f / sumValid;
            for (DirectionOption option : validOpts) {
                option.setProbabilityPercent(k * option.getProbabilityPercent());
            }
        }

        return validOpts.toArray(new DirectionOption[validOpts.size()]);
    }

}
