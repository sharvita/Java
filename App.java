
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class App {

    public ArrayList<Book> list = new ArrayList<Book>();
    //public Scanne
    // r scan = new Scanner(System.in);

    public void addNewAuthor(Book book){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter name :");
        Author newAuthor = new Author();
        newAuthor.setName(scan.nextLine());

        book.getAuthorList().put(newAuthor.getName(),newAuthor);

    }

    public void addNewBook() {

        Scanner scan = new Scanner(System.in);
        System.out.println("1) Add a printed book ");
        System.out.println("2) Add a electronic book ");


        int input = scan.nextInt();


        if (input == 1) {
            PrintedBook newBook = new PrintedBook();
            scan.nextLine();
            System.out.println("Enter the title of the book: ");
            String str = scan.nextLine();
            newBook.setTitle(str);
            System.out.println("Enter the year published");
            int num = scan.nextInt();
            newBook.setYearPub(num);
            System.out.println("Enter the location code :");
            scan.nextLine();
            String str2 = scan.nextLine();
            newBook.setLocationCode(str2);
            System.out.println("Enter number of pages :");
            num = scan.nextInt();
            newBook.setNumberPages(num);
            System.out.println("Enter uploading date:");
            num = scan.nextInt();
            newBook.setDateOfPrint(num);


            list.add(newBook);
            System.out.println("Now add an author to this book");
            addNewAuthor(newBook);

            boolean another = true;
            while (another) {
                System.out.println("Do you want to add another author? Enter yes or no");
                String choice = scan.nextLine();

                if (choice.equals("yes")) {
                    addNewAuthor(newBook);
                } else if (choice.equals("no")) {
                    another = false;
                } else
                    System.out.println("Enter a valid choice please.");

            }
        } else if (input == 2) {
            ElectronicBook newBook = new ElectronicBook();
            scan.nextLine();
            System.out.println("Enter the title of the book: ");
            String str = scan.nextLine();
            newBook.setTitle(str);
            System.out.println("Enter the year published");
            int num = scan.nextInt();
            newBook.setYearPub(num);
            System.out.println("Enter the location code :");
            scan.nextLine();
            String str2 = scan.nextLine();
            newBook.setLocationCode(str2);
            System.out.println("Enter number of pages :");
            num = scan.nextInt();
            newBook.setNumberPages(num);
            System.out.println("Enter date of print:");
            num = scan.nextInt();
            newBook.setDateUploaded(num);




            list.add(newBook);
            System.out.println("Now add an author to this book");
            addNewAuthor(newBook);


            boolean another = true;
            while (another) {
                System.out.println("Do you want to add another author? Enter yes or no");
                String choice = scan.nextLine();

                if (choice.equals("yes")) {
                    addNewAuthor(newBook);
                } else if (choice.equals("no")) {
                    another = false;
                } else
                    System.out.println("Enter a valid choice please.");

            }
        }
    }

    public void addAuthorToBook(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the title of the book that you would like to add an author to:");
        PrintedBook newBook = new PrintedBook();
        newBook.setTitle(scan.nextLine());

        if(list.size() == 1) {
            if (list.get(0).getTitle().equals(newBook.getTitle()))
                addNewAuthor(list.get(0));
            System.out.println(list.get(0).printAuthors());

        } else {
            for (int i = 0; i < list.size() ; i++) {
                if (list.get(i).getTitle().equals(newBook.getTitle())) {
                    System.out.println("Book was found, Enter the new author information below");
                    addNewAuthor(list.get(i));
                    System.out.println("The book now has the following authors");
                    System.out.println(list.get(i).printAuthors());

                }
            }
        }
    }

    public void removeAuthorFromBook(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the title of the book that you would like to remove an author from:");
        PrintedBook newBook = new PrintedBook();
        newBook.setTitle(scan.nextLine());

        for(int i = 0; i< list.size();i++){
            if(list.get(i).getTitle().equals(newBook.getTitle())){

                System.out.println("Book was found");

                    System.out.println("There are multiple author. Enter the exact name of the author to delete it from book.");
                    Author newAuthor = new Author();
                    newAuthor.setName(scan.nextLine());

                    list.get(i).removeAuthor(newAuthor.getName());
                    System.out.println("The following author was removed :" + newAuthor.getName());
                  }

            }


    }



    public void printList(){
        System.out.println(list.size());
        for(int i =0; i< list.size();i++){
            System.out.println(list.get(i));
            System.out.println();
        }
    }

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        App app = new App();
        boolean keepGoing = true;
        System.out.println("Welcome");
        while(keepGoing) {
            System.out.println("Choose one of the options below :");
            System.out.println("1)Add new book and its author");
            System.out.println("2)Add new author to a book");
            System.out.println("3)Remove author from book");
            System.out.println("4)Exit");
            System.out.println("5)Print books");

            int choice = input.nextInt();

            if(choice == 1)
                app.addNewBook();
            else if(choice == 2)
                app.addAuthorToBook();
            else if(choice ==3)
                app.removeAuthorFromBook();
            else if(choice == 4 )
                break;
            else if(choice == 5)
                app.printList();
            else
                System.out.println("Enter a valid option");
        }
    }
}
