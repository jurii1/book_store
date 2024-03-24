/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author Juri
 */
public class BookAuthor {
    private String title, name, lastName, isbn;
    private int year, price;

    public BookAuthor(String title, String name, String lastName, int year, String isbn, int price) {
        this.title = title;
        this.name = name;
        this.lastName = lastName;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public BookAuthor(String title, String name, String lastName, int year) {
        this.title = title;
        this.name = name;
        this.lastName = lastName;
        this.year = year;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
