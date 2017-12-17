package task11_05_12_2017_Threads.military;

public class Valuables {
    private int price;

    public Valuables(int price){
        this.price = price;
    }

    public static Valuables create(){
        int price = (int)(Math.random()*50);
        return new Valuables(price);
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        if(price>0)this.price=price;
        else throw new IllegalArgumentException();
    }
    @Override
    public String toString() {
        return "цена=" + price;
    }
}