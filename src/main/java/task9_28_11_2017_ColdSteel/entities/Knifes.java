package task9_28_11_2017_ColdSteel.entities;
import java.util.ArrayList;
import java.util.List;

public class Knifes {

    protected List<Knife> knife;
    public List<Knife> getKnife() {
        if (knife == null) {
            knife = new ArrayList<Knife>();
        }
        return this.knife;
    }

}
