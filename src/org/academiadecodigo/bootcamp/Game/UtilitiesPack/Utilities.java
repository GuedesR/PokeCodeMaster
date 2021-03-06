package org.academiadecodigo.bootcamp.Game.UtilitiesPack;

import org.academiadecodigo.bootcamp.Game.GameScreens;

/**
 * Created by codecadet on 20/02/2019.
 */
public abstract class Utilities extends GameScreens{

    public abstract void drawStage();

    public abstract void hideStage();
    public abstract void setUnlocked();
    public abstract boolean isUnlocked();
    //What the utility stage does
    public abstract boolean action();

}
