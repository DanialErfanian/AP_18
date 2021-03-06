package Buildings;

import Logic.Game;
import Logic.MainObject;

abstract public class BaseBuilding extends MainObject {
    BaseBuilding(Game game) {
        super(game);
    }

    abstract public String toString();

    abstract public boolean upgrade();

    public final boolean canUpgrade(){
        return getGame().getMoney() >= getUpgradeCost();
    }

    abstract protected int getUpgradeCost();
}
