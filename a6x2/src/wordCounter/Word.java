package wordCounter;

public class Word implements Comparable<Word>{

    //----- VARIABLES -----
    private String word;




    //----- CONSTRUCTOR -----
    public Word(String givenWord) {
        this.word = givenWord.toLowerCase();
    } //word




    //----- METHODS -----
    public String getWord() {
        return this.word;
    }//getWord


    //---- OVERRIDE METHODS -----
    @Override
    public boolean equals( Object other ) {
        //same Object?
        if (this == other) return true;

        //is null?
        if (other == null) return false;

        //same Class?
        if (other.getClass() != this.getClass()) return false;

        //Typconvertion
        Word otherWord = (Word) other;

        return (this.word.equals(otherWord.word));
    }



    @Override
    public int hashCode() {
        return this.word.hashCode();
    }



    @Override
    public String toString() {
        return word;
    }//toString




    @Override
    public int compareTo(Word otherWord) {
        return this.word.compareTo(otherWord.word)  ;
    }//compareTo

}
