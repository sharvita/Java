import java.util.Scanner; //imports scanner library


public class BinaryToDeci {   //class declaration

/*
  This function takes in a binary integer and converts it to
  a decimal number.
 */

    public int convert(int n){
        int decimal = 0;
        int p=0;

        while(n!=0)       //while loop to see the end
        {
            decimal+=((n%10)*Math.pow(2,p));   //power of two
            n=n/10;
            p++;
        }
        return decimal;   //returns decimal
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);    //used for taking in input

        System.out.println("Enter a binary number:");
        int n=s.nextInt();                      //takes in the next integer

        BinaryToDeci test = new BinaryToDeci();   //creates object
        System.out.println(test.convert(n));      //calls function on object
    }

}
