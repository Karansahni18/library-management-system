package com.karan.library;

import com.karan.library.model.Book;
import com.karan.library.model.Member;
import com.karan.library.model.StudentMember;
import com.karan.library.model.FacultyMember;
import com.karan.library.model.BorrowRecord;
import com.karan.library.repository.Library;
import com.karan.library.service.BorrowingService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Library library = new Library();
        BorrowingService borrowingService = new BorrowingService(library);

        while(running) {

            System.out.println("==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("6. Search Book by Title");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice) {
                case 1:
                    System.out.print("Enter ISBN:");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title:");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author:");
                    String author = scanner.nextLine();
                    Book book = new Book(isbn , title , author);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.println("Enter Member Type:");
                    System.out.println("1. Student");
                    System.out.println("2. Faculty");
                    int memberType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Member ID:");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name:");
                    String name = scanner.nextLine();
                    Member member;
                    if(memberType == 1) {
                        member = new StudentMember(memberId, name);
                    } else {
                        member = new FacultyMember(memberId, name);
                    }
                    library.addMember(member);
                    System.out.println("Member registered successfully.");
                    break;
                case 3:
                    System.out.print("Enter Member ID:");
                    int borrowMemberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book ISBN:");
                    String borrowIsbn = scanner.nextLine();
                    System.out.print("Enter Borrow Date (YYYY-MM-DD):");
                    String borrowDate = scanner.nextLine();
                    System.out.print("Enter Due Date (YYYY-MM-DD):");
                    String dueDate = scanner.nextLine();
                    Member borrowMember = library.findMemberById(borrowMemberId);
                    Book borrowBook = library.findBookByIsbn(borrowIsbn);

                    if(borrowMember != null && borrowBook != null) {
                        boolean success = borrowingService.borrowBook(borrowMember, borrowBook, borrowDate, dueDate);
                        if(success) {
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Failed to borrow book. It might be already borrowed or member has reached the limit.");
                        }
                    } else {
                        System.out.println("Invalid Member ID or Book ISBN.");
                    }
                    break;
                case 4 :
                    System.out.print("Enter Borrow Isbn to return:");
                    String borrowedIsbn = scanner.nextLine();
                    System.out.print("Enter Return Date (YYYY-MM-DD):");
                    String returnDate = scanner.nextLine();
                    BorrowRecord recordToReturn = null;
                    for(BorrowRecord record : library.getBorrowRecords()) {
                        if(record.getBook().getIsbn().equals(borrowedIsbn) && record.getReturnDate() == null) {
                            recordToReturn = record;
                            break;
                        }
                    }
                    if(recordToReturn != null) {
                        borrowingService.returnBook(recordToReturn, returnDate);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Invalid BorrowIsbn.");
                    }
                    break;

                case 5:
                    System.out.println("Available Books:");
                    borrowingService.listAvailableBooks();
                    break;
                case 6 :
                    System.out.print("Enter Book Title to search:");
                    String bookTitle = scanner.nextLine();
                    boolean found = false;
                    for(Book b : library.getAllBooks()) {
                        if(b.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
                            System.out.println("Found: " + b.getTitle() + " by " + b.getAuthor() + " (ISBN: " + b.getIsbn() + ")");
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("No book found with the title: " + bookTitle);
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;

            }

        }

        scanner.close();

        
        // Library library = new Library();
        // BorrowingService borrowingService = new BorrowingService(library);

        // // 2. Create some books and add them
        // Book book1 = new Book("111", "Effective Java", "Joshua Bloch");
        // Book book2 = new Book("222", "Clean Code", "Robert Martin");
        // library.addBook(book1);
        // library.addBook(book2);

        // // 3. Create some members and add them
        // Member student = new StudentMember(1, "Karan");
        // Member faculty = new FacultyMember(2, "Dr. Sharma");
        // library.addMember(student);
        // library.addMember(faculty);

        // // 4. Show available books before borrowing
        // System.out.println("Available books before borrowing:");
        // borrowingService.listAvailableBooks();

        // // 5. Borrow a book
        // boolean success = borrowingService.borrowBook(student, book1, "2026-08-30", "2026-09-13");
        // System.out.println("Borrow attempt: " + success);

        // // 6. Try borrowing the SAME book again — should fail, it's already borrowed
        // boolean secondAttempt = borrowingService.borrowBook(faculty, book1, "2026-08-30", "2026-09-13");
        // System.out.println("Second borrow attempt on same book: " + secondAttempt);

        // // 7. Show available books after borrowing
        // System.out.println("Available books after borrowing:");
        // borrowingService.listAvailableBooks();

        // // 8. Return the book
        // BorrowRecord record = library.getBorrowRecords().get(0);
        // borrowingService.returnBook(record, "2026-09-10");

        // // 9. Show available books after returning
        // System.out.println("Available books after returning:");
        // borrowingService.listAvailableBooks();
    }
}
