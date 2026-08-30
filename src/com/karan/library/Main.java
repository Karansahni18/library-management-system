package com.karan.library;

import com.karan.library.model.Book;
import com.karan.library.model.Member;
import com.karan.library.model.StudentMember;
import com.karan.library.model.FacultyMember;
import com.karan.library.model.BorrowRecord;
import com.karan.library.repository.Library;
import com.karan.library.service.BorrowingService;

public class Main {
    public static void main(String[] args){
        
        Library library = new Library();
        BorrowingService borrowingService = new BorrowingService(library);

        // 2. Create some books and add them
        Book book1 = new Book("111", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("222", "Clean Code", "Robert Martin");
        library.addBook(book1);
        library.addBook(book2);

        // 3. Create some members and add them
        Member student = new StudentMember(1, "Karan");
        Member faculty = new FacultyMember(2, "Dr. Sharma");
        library.addMember(student);
        library.addMember(faculty);

        // 4. Show available books before borrowing
        System.out.println("Available books before borrowing:");
        borrowingService.listAvailableBooks();

        // 5. Borrow a book
        boolean success = borrowingService.borrowBook(student, book1, "2026-08-30", "2026-09-13");
        System.out.println("Borrow attempt: " + success);

        // 6. Try borrowing the SAME book again — should fail, it's already borrowed
        boolean secondAttempt = borrowingService.borrowBook(faculty, book1, "2026-08-30", "2026-09-13");
        System.out.println("Second borrow attempt on same book: " + secondAttempt);

        // 7. Show available books after borrowing
        System.out.println("Available books after borrowing:");
        borrowingService.listAvailableBooks();

        // 8. Return the book
        BorrowRecord record = library.getBorrowRecords().get(0);
        borrowingService.returnBook(record, "2026-09-10");

        // 9. Show available books after returning
        System.out.println("Available books after returning:");
        borrowingService.listAvailableBooks();
    }
}
