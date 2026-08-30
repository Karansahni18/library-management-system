package com.karan.library.repository;

import com.karan.library.model.Book;
import com.karan.library.model.Member;
import com.karan.library.model.BorrowRecord;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private List<BorrowRecord> borrowRecords;

    public Library() {

        this.books = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
        this.borrowRecords = new ArrayList<BorrowRecord>();
    }

    public void addBook(Book book) {

        books.add(book);
    }

    public void addMember(Member member) {

        members.add(member);
    }

    public Book findBookByIsbn(String isbn) {
        
        for(Book book : books) {
            if(isbn.equals(book.getIsbn())) {
                return book;
            }
        }

        return null;
    }

    public Member findMemberById(int memberId) {

        for(Member member : members) {
            if(memberId == member.getMemberId()) {
                return member;
            }
        }

        return null;
    }

    public List<Book> getAllBooks() {

        return books;
    }

    public List<BorrowRecord> getBorrowRecords() {

        return borrowRecords;
    }
}

