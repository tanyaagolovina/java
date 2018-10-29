package model.entity;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private double price;

    public Book(String title,String author, String publisher, int year, int pages,double price){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;


    }
    @Override
    public String toString() {
        return "Book : " +
                "Title - " + title +
                ", Author - " + author +
                ", Publisher - " + publisher +
                ", Year - " + year +
                ", Pages - " + pages +
                ", Price - " + price ;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Book() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {

        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
