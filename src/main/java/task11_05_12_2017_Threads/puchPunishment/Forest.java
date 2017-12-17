package task11_05_12_2017_Threads.puchPunishment;

public class Forest {
    private boolean[] forest;

    public Forest (int forestLength, int vinniInForest){
        setLength(forestLength);
        hideVinniInForest(vinniInForest);
        setLengthOfForest(forestLength);
    }

    public void setLengthOfForest(int lengthOfForest) {
        int lengthOfForest1 = lengthOfForest;
    }

    public int getLength() {
        return forest.length;
    }
    public void setLength(int i){
        if(i<1)throw new IllegalArgumentException();
        else forest=new boolean[i];
    }
    public boolean[] getForest(){
        return forest;
    }
    public void hideVinniInForest(int place){
        if(place<1)throw new IllegalArgumentException();
        else forest[place]=true;
    }
}
