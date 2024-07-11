package wordCounter;

public class Counter {

    //----- VARIABLES -----
    private int countValue;




    //----- CONSTRUCTOR -----
    public Counter() {
        this.countValue = 1;
    }//Counter




    //----- METHODS -----

    // increments countValue +1
    void inc() {
        this.countValue += 1;
    }//inc





    //----- GETTER -----
    public int getCountValue() {
        return this.countValue;
    }//getCountValue




    //----- OVERRIDE -----
    @Override
    public String toString() {
        return String.format("%d", countValue);
    }//toString

}//class
