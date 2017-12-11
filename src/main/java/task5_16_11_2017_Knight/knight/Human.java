package task5_16_11_2017_Knight.knight;

import task5_16_11_2017_Knight.utils.Name;

public abstract class Human {
    private Name name;
    private int age;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
