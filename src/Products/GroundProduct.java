package Products;

import Buildings.Warehouse;
import Logic.Constants;
import Logic.Game;
import Logic.MiddleMapObject;
import Utils.Position;

public class GroundProduct extends MiddleMapObject {
    private Product type;
    private int amount;
    private int constructTime = Constants.GROUND_PRODUCT_TIMEOUT;

    public GroundProduct(Game game, Product type, Position position, int amount) {
        super(game, position);
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GroundProduct: " +
                "\ntype: " + type +
                "\namount: " + amount +
                "\nconstructTime" + constructTime;
    }

    @Override
    protected void increaseTurn() {
        if (getPosition() == null)
            return;
        if (constructTime == 0) {
            setPosition(null);
            amount = 0;
        } else
            constructTime--;
    }

    public void collect() {
        Warehouse warehouse = getGame().getWarehouse();
        while (amount > 0 && warehouse.addProduct(type, 1))
            amount--;
        if (amount == 0)
            this.destruct();
    }

    public Product getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
