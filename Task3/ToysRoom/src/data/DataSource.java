package data;

import model.entity.Lego;
import model.entity.Soft;
import model.entity.Toy;

public class DataSource {
    public static Toy[] getToys(){
        return new Toy[] {
                new Lego("Builder", 300, "home", 300),
                new Soft("Barni", 500, "bear", "brown"),
                new Lego("Mark", 800, "person", 700),
                new Soft("Teddi", 600, "bear", "grey"),
                new Lego("Car", 300, "audi", 750),
                new Soft("Barbi", 500, "doll", "pink"),
        };
    }
}
