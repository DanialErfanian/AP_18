package Products;

public enum Product {
    Egg(1, 20, 10), Wool(5, 200, 100), Plume(2, 200, 100), Milk(10, 2000, 1000), Horn(6, 2000, 1000), DriedEggs(4, 100, 50), Cake(5, 200, 100), FlouryCake(6, 400, 200), Sewing(3, 300, 150), Fabric(6, 400, 300), CarnivalDress(8, 1400, 1300), SourCream(8, 3000, 1500), Curd(6, 4000, 2000), Cheese(5, 5000, 2500), ColoredPlume(2, 300, 150), Adornment(4, 400, 300), BrightHorn(5, 3000, 1500), Intermediate(4, 4000, 2000), Souvenir(3, 5000, 2500), Flour(2, 20, 10), CheeseFerment(2, 25, 15), Varnish(3, 25, 15), MegaPie(20, 20000, 10000), SpruceGrizzly(25, 2500, 7000), SpruceLion(25, 2500, 7000), SpruceBrownBear(25, 2500, 7000), SpruceJaguar(25, 2500, 7000), SpruceWhiteBear(25, 2500, 7000), CagedGrizzly(20, 80, 80), CagedLion(20, 150, 150), CagedBrownBear(20, 100, 100), CagedJaguar(20, 200, 200), CagedWhiteBear(20, 100, 100);
    private int depotSize, buyCost, saleCost;

    Product(int depotSize, int buyCost, int saleCost) {
        this.depotSize = depotSize;
        this.buyCost = buyCost;
        this.saleCost = saleCost;
    }

    public int getSaleCost() {
        return this.saleCost;
    }

    public int getBuyCost() {
        return this.buyCost;
    }

    public static Product getProductByName(String name) {
        return valueOf(name);
    }

    int getDepotSize() {
        return depotSize;
    }
}
