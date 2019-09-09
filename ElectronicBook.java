
public class ElectronicBook extends Book{

    private int numberPages;
    private int dateUploaded;


    public int getNumberPages(){
        return this.numberPages;
    }

    public int getDateUploaded()
    {
        return this.dateUploaded;
    }

    public void setNumberPages(int _num){
        this.numberPages = _num;
    }
    public void setDateUploaded(int _num){
        this.dateUploaded = _num;
    }

    public String toString(){

        return super.toString() +  "\nNumber Of Pages :" + numberPages + "\nUploading Date : " + dateUploaded;
    }
    @Override
    public int compareTo(Book o) {

        return 0;
    }


}
