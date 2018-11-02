package model.entity;

public class Tomato extends Vegetable {
    {
        setName(this.getClass().getSimpleName());
        setCalories(22);
        setPrice(10);
    }

}
