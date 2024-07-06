package wordCounter;

public class Counter {

    //----- VARIABLES -----
    int countValue;





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
    public int getcountValue() {
        return this.countValue;
    }//getCountValue
    
    
    
    @Override
    public String toString() {
        return String.format("[<%s> : countValue = %d]", Counter.class.getSimpleName(), countValue);
    }//toString

}//class
