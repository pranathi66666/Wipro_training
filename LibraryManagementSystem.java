import java.util.*;

class Book {
    String id, title, author;
    boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Member {
    String memberId, name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void issueBook(String bookId, String memberId) {
        for (Book book : books) {
            if (book.id.equals(bookId) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued to Member ID: " + memberId);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.id.equals(bookId) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid Book ID.");
    }
}
