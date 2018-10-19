package data;

import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Shape;
import model.entity.Triangle;

public class DataSource {
    public static Shape[] getShapes() {
        return new Shape[] {
                new Circle("blue", 3),
                new Rectangle("red", 3, 4 ),
                new Triangle("yellow", 4, 6),
                /*new Circle("purple", 5),
                new Rectangle("rose", 2, 6 ),
                new Triangle("black", 6, 3),
                new Circle("white", 6),
                new Rectangle("green", 5, 5 ),
                new Triangle("blue", 7, 3),
                new Circle("yellow", 2),
                new Rectangle("red", 5, 8 ),
                new Triangle("grey", 4, 6)*/

        };
    }
}
