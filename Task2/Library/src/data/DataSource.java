package data;

import model.entity.Book;

public class DataSource {

    public static Book[] getBooks(){
        return new Book[]{
                new Book("Title1","Shevchenko","BXV", 2010, 320, 450.0),
                new Book("Title2","Shevchenko","Work", 2000, 120, 250.0),
                new Book("Title3","Kylish","Work", 2011, 420, 400.0),
                new Book("Title4","Maslov","Bukvar", 2012, 300, 420.0),
                new Book("Title5","Kylish","BXV", 2017, 230, 250.0),
                new Book("Title6","Tolstoy","Bukvar", 2009, 500, 150.0),
                new Book("Title7","Shevchenko","Work", 2009, 250, 550.0),
                new Book("Title8","Tolstoy","Bukvar", 2010, 340, 600.0)
        };
    }
}
