package model;

import data.DataSource;
import model.entity.Book;
import org.junit.*;




public class TestBooks {

    private static Books model;

    private static Book[] booksShevchenko = new Book[]{
            new Book("Title1", "Shevchenko", "BXV", 2010, 320, 450.0),
            new Book("Title2", "Shevchenko", "Work", 2000, 120, 250.0),
            new Book("Title7", "Shevchenko", "Work", 2009, 250, 550.0)
    };

    private static Book[] booksWork = new Book[]{
            new Book("Title2","Shevchenko","Work", 2000, 120, 250.0),
            new Book("Title3","Kylish","Work", 2011, 420, 400.0),
            new Book("Title7","Shevchenko","Work", 2009, 250, 550.0)
    };

    private static Book[] booksYear = new Book[]{
            new Book("Title3","Kylish","Work", 2011, 420, 400.0),
            new Book("Title4","Maslov","Bukvar", 2012, 300, 420.0),
            new Book("Title5","Kylish","BXV", 2017, 230, 250.0),
    };

    private static Book[] booksOrdered = new Book[]{
            new Book("Title1","Shevchenko","BXV", 2010, 320, 450.0),
            new Book("Title5","Kylish","BXV", 2017, 230, 250.0),
            new Book("Title4","Maslov","Bukvar", 2012, 300, 420.0),
            new Book("Title6","Tolstoy","Bukvar", 2009, 500, 150.0),
            new Book("Title8","Tolstoy","Bukvar", 2010, 340, 600.0),
            booksWork[0],
            booksWork[1],
            booksWork[2]
    };

    @BeforeClass
    public static void init() {
        model = new Books();
        model.setBooks(DataSource.getBooks());
    }


    @Test
    public void testFindByAuthor() {
        String author = "Shevchenko";
        Assert.assertArrayEquals(booksShevchenko, model.findByAuthor(author));
    }

    @Test
    public void testFindByPublisher(){
        String publisher = "Work";
        Assert.assertArrayEquals(booksWork, model.findByPublisher(publisher));
    }

    @Test
    public void testFindByYear(){
        String year = "2010";
        Assert.assertArrayEquals(booksYear, model.findByYear(year));
    }

    @Test
    public void orderByPublisher(){
        Assert.assertArrayEquals(booksOrdered, model.orderByPublisher());
    }

    @AfterClass
    public static void printResult(){
        System.out.println("All tests are done");
    }
}