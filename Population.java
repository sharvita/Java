import static java.lang.Math.pow; //importing library

public class Population { //declaring class

    public void calculatePopulation(){   //declaring function

        //variables
        long population = 7650816456L;
        int year = 2018;
        long oldPop  = 7650816456L;
        long newPop;
        long increase;
        Boolean isDouble = true;
    //for loop that goes 75 times
        for(int i=1; i < 76;++i){
            year++;   //increments the year
            newPop = (long) (population * Math.pow (( 2.71828) ,(.0109*i))); //new population is calculated by using the PERT formula
            increase = newPop-oldPop; //numerical increase is calculted

            System.out.println(" " + year + "                 "+ newPop +"                   " + increase        ); //prints out the year, new population and increase

            if(increase >= population & isDouble) {       //check for the very first year that the population is double the size
                System.out.println("The population doubles in this year : " + year);
                isDouble = false;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(" Year                  Population                  Numerical Increase");
        System.out.println(" 2018                 7650816456                          --         ");

        Population p = new Population();     //object is created
        p.calculatePopulation();            //function is called using object

    }
}
