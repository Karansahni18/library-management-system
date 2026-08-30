package com.karan.library.service;

import com.karan.library.model.Book;
import com.karan.library.model.Member;
import com.karan.library.model.BorrowRecord;
import com.karan.library.model.BookStatus;
import com.karan.library.repository.Library;

public class BorrowingService {

    private Library library;

    public BorrowingService(Library library) {
        this.library = library;
    }

    public boolean borrowBook(Member member , Book book , String borrowDate , String dueDate) {

        if(book.getStatus() == BookStatus.AVAILABLE) {

            book.setStatus(BookStatus.BORROWED);
            BorrowRecord record = new BorrowRecord(book,member,borrowDate,dueDate);
            library.getBorrowRecords().add(record);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(BorrowRecord record , String returnDate) {

        
        record.setReturnDate(returnDate);
        record.getBook().setStatus(BookStatus.AVAILABLE);
        return true;
    }

    public void listAvailableBooks() {

        for(Book book : library.getAllBooks()) {
            if(book.getStatus() == BookStatus.AVAILABLE) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
        
    }
}
