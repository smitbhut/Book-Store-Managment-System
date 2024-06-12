import java.util.*;
// import java.util.logging.LogManager;

// import javax.security.auth.login.LoginContext;

class Book2 {
    String Book_name;
    int id, prize;
    String auther_name;
    Scanner sc = new Scanner(System.in);
    int password = 1234;

    void login() {
        System.out.println("------Welcome to Book Store Managment System------");
        System.out.println("enter password: ");
        int p = sc.nextInt();

        if (p == password) {
            System.out.println("-----Successful Login-----");
        } else {
            System.out.println("Wrong password please re-enter the password: ");
            int p1 = sc.nextInt();
            if (p1 == password) {
                System.out.println("valid password");
            } else {
                System.out.println("Your account is locked for 1 hour");
            }
        }
    }

    void resetPassWord() {
        boolean flage = false;
        while (!flage) {
            System.out.println("Reset password");
            String s = sc.next();
            if (s.length() == 4 && s.matches("[0-9]+")) {
                flage = true;
                System.out.println("password changed successfuly");
            } else {
                System.out.println("Invalied combination , enter valied password");
            }
        }
    }

    void imfo() {
        System.out.println("enter book name: ");
        Book_name = sc.nextLine();
        System.out.println("enter auther name: ");
        auther_name = sc.nextLine();
        System.out.println("enter price: ");
        prize = sc.nextInt();
        System.out.println("enter id: ");
        id = sc.nextInt();
    }

    void showBook() {
        System.out.println("Book name: " + Book_name);
        System.out.println("auther name: " + auther_name);
        System.out.println("price: " + prize);
        System.out.println("id: " + id);
    }

    int search() {
        System.out.println("enter id  to remove");
        int x = sc.nextInt();
        return x;
    }

    void remove(int bookId, Book2[] b) {
        boolean flage = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i].id == bookId) {
                b[i] = null;
                System.out.println("Book with id " + bookId + " removed.");
                flage = true;
                break;
            }
        }
        if (flage == false) {
            System.out.println("Book with id " + bookId + " not found.");
        }
    }

    int update_sc() {
        System.out.println("Enter the updated book information: ");
        sc.nextLine();
        imfo();
        return 0;
    }

    void update(int bookId, Book2[] b) {
        boolean flage = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i].id == bookId) {
                b[i].update_sc();
                System.out.println(" Id" + bookId + " updated");
                flage = true;
                break;
            }
        }
        if (flage == false) {
            System.out.println("Id " + bookId + " not found.");
        }
    }

    void add(Book2[] b2, Book2 newBook) {
        boolean flage = false;
        for (int i = 0; i < b2.length; i++) {
            if (b2[i] == null) {
                b2[i] = newBook;
                flage = true;
                System.out.println("Book added successfully.");
                break;
            }
        }
        if (flage == false) {
            System.out.println("Book Store is full. Cannot add more books.");
        }
    }

    void shellBook(Book2[] b) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book to shell: ");
        String bookName = sc.nextLine();
        boolean flage = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null && b[i].Book_name.equalsIgnoreCase(bookName)) {
                b[i] = null;
                System.out.println("Book " + bookName + " shelled.");
                flage = true;
                break;
            }
        }
        if (flage == false) {
            System.out.println("Book " + bookName + " not found.");
        }
    }
}

class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book2 bk = new Book2();
        // Login
        Book2 bk2 = new Book2();
        bk2.login();
        bk2.resetPassWord();
        // Book array for for 2 books details
        Book2 b[] = new Book2[2];

        System.out.println("-------Enter Books details-------");
        for (int i = 0; i < b.length; i++) {
            b[i] = new Book2();
            System.out.println("-----Enter Book " + (i + 1) + " Data-----");
            b[i].imfo();
        }
       
        System.out.println("-------welcome-------");
        System.out.println(
                "1. Show Books \n 2. removing book\n 3. updating book\n 4. add books \n 5.shell book \n 6. Exit");
        System.out.println("enter choice: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                // Book details
                System.out.println("-----Books Details-----");
                for (int i = 0; i < b.length; i++) {
                    b[i].showBook();
                }
                break;
            case 2:
                // Remove Book
                int z = bk.search();
                bk.remove(z, b);
                break;
            case 3:
                // Updating Book
                int z1 = bk.search();
                bk.update(z1, b);
                break;
            case 4:
                // Add Book
                System.out.println("How many books do you want to enter?");
                int numBooks = sc.nextInt();
                Book2[] newBooks = new Book2[numBooks];
                for (int i = 0; i < numBooks; i++) {
                    newBooks[i] = new Book2();
                    newBooks[i].imfo();
                    bk.add(b, newBooks[i]);
                }
                break;
            case 5:
                // Shell Book
                bk.shellBook(b);
                break;
            case 6:
                // Exit
                System.out.println("Thank you");
                break;
            default:
                // Ivalide option
                System.out.println("Please choose valide option");

        }
    

    }

}
