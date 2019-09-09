
public class PrintedBook extends Book{

    private int numberPages;
    private int dateOfPrint;


    public int getNumberPages(){
        return this.numberPages;
    }

    public int getDateOfPrint()
    {
        return this.dateOfPrint;
    }

    public void setNumberPages(int _num){
        this.numberPages = _num;
    }
    public void setDateOfPrint(int _num){
        this.dateOfPrint = _num;
    }

    public String toString(){

        return super.toString() +  "\nNumber Of Pages :" + numberPages + "\nPrinting Date : " + dateOfPrint;
    }
    @Override
    public int compareTo(Book o) {

        return 0;
    }


}
