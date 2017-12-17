package task12_07_12_2017_Stock_Exchange;

public class Share {
    private double price = 100;
    private String companyName;
    private int salesCount = 0;
    private int buysCount = 0;
    private int amountOnStock = 200;

    public Share(String companyName) {
        this.companyName = companyName;
    }

    public void recalculatePrice() {
        double deltaPricePercent = Math.random();
        if (salesCount > buysCount) price -= (deltaPricePercent * price);
        else price += (deltaPricePercent * price);
        System.out.println("Новая цена "+ price+"на облигации компании " + companyName);
    }

    public synchronized double getPrice() {
        return price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public synchronized int getAmountOnStock() {
        return amountOnStock;
    }

    public synchronized void setAmountOnStock(int amountOnStock) {
        this.amountOnStock = amountOnStock;
    }

    void incrementSalesCount() {
        salesCount++;
    }

    void incrementBuysCount() {
        buysCount++;
    }
}
