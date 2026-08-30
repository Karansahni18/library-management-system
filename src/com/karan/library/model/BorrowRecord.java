package com.karan.library.model;

public class BorrowRecord {

    private Book book;
    private Member member;
    private String borrowDate;
    private String dueDate;
    private String returnDate;

    public BorrowRecord(Book book , Member member , String borrowDate , String dueDate) {

        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {

        this.returnDate = returnDate;
    }
}