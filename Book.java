import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Book implements Comparable <Book>{

    protected String title;
    protected int yearPub;
    protected String locationCode;
    protected Map<String, Object> authorList = new HashMap();

    //getters
    public String getTitle(){
        return this.title;
    }
    public int getYearPub(){
        return this.yearPub;
    }
    public String getLocationCode(){
        return this.locationCode;
    }
    public Map<String, Object>  getAuthorList() { return this.authorList;}

    //setters
    public void setTitle(String _title){
        this.title = _title;
    }
    public void setYearPub(int _yearPub){
        this.yearPub = _yearPub;
    }
    public void setLocationCode(String _locationCode){
        this.locationCode = _locationCode;
    }

    //to String
    public String toString(){
        return "Title : " + this.getTitle() + "\nYear Published : " + this.getYearPub() + "\nAuthors : " + printAuthors();
    }

    //other functions
    public void removeAuthor(String author){

       // for(int i  = 0 ; i < authorList.size(); i++){

                authorList.remove(author);
                //System.out.println("The author was removed.");
               // break;
        }
     //   System.out.println("Author was not found in the list.");
    //}

    public void addAuthor(Author author){
        authorList.put(author.getName(), author);
    }

    public String printAuthors(){
        String authors = "";
        for(Map.Entry<String,Object> entry : authorList.entrySet()){
            authors += " " +entry.getKey() +", ";
        }
        return authors;
    }

}
