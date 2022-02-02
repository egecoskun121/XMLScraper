public class Currency {
    private double buyPrice;
    private double sellPrice;
    private String name;

    public Currency(double buyPrice, double sellPrice, String name) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.name = name;
    }


    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calcDiff(double stockPrice,double c1,double c2){
        return c2*stockPrice-c1*stockPrice;
    }
}
