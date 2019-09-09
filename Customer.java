import java.util.Scanner;

public class Customer {    //creates class

    //variabled

    public int accountNum =0;
    public int currentBal =0;
    public int items=0;
    public int credits=0;
    public int creditLimit=0;


    //this function calculates if the user has reached a credit limit
    public void problem1(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter account number: ");
        accountNum = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("Enter current balance: ");
        currentBal = reader.nextInt();// Scans the next token of the input as an int.
        System.out.println("Enter number of items: ");
        items = reader.nextInt();// Scans the next token of the input as an int.
        System.out.println("Enter credits: ");
        credits = reader.nextInt();// Scans the next token of the input as an int.
        System.out.println("Enter allowed charged limit: ");
        creditLimit = reader.nextInt();// Scans the next token of the input as an int.

        reader.close();  //closes the scanner

        System.out.println("Your new balance is:");

        //calcuates the new balance
        int newBalance = currentBal + items - credits;
        System.out.println(newBalance);

        //checks if the new balance is exceeded
        if(newBalance > creditLimit) {
            System.out.println("Credit limit exceeded");
        } else {
            System.out.println("Credit limit has not exceeded");
        }

    }

    public static void main(String[] args){
        Customer a = new Customer();   //creates object

        a.problem1();    //calls function on object 
    }
}
