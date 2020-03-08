package com.example.projecttower;

import java.io.Serializable;

import java.util.ArrayList;


public class Textbook implements Serializable{
    private String bookISBN;
    private String bookTitle;
    private ArrayList<String> bookAuthors;
    private double bookPrice;


    public Textbook(String bookISBN, String bookTitle, ArrayList<String> bookAuthors, double bookPrice) {
        super();
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthors = bookAuthors;
        this.bookPrice = bookPrice;

    }


    public String getBookISBN() {
        return bookISBN;
    }


    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }


    public String getBookTitle() {
        return bookTitle;
    }


    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public ArrayList<String> getBookAuthors() {
        return bookAuthors;
    }


    public void setBookAuthors(ArrayList<String> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }


    public double getBookPrice() {
        return bookPrice;
    }


    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }



}