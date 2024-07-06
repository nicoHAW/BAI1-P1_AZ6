package wordCounter;

public class Word {
    
    //----- VARIABLES -----
    private String word;
    private Counter wordCounter;
    
    
    
    
  //----- CONSTRUCTOR -----
    public Word(String givenWord) {
        this.word = givenWord.toLowerCase();
        this.wordCounter = new Counter();
    } //word

    
    
    
    
  //----- METHODS -----
    public String getWord() {
        return this.word;
    }//getWord

    
    
    public Counter getWordCounter() {
        return this.getWordCounter();
    }//getwordCounter
    
    
    
    public int getWordValue() {
        return this.wordCounter.countValue;
    }//getWordValue
    
    
    
    @Override
    public String toString() {
        return String.format("[<%s> : Word = %s  WordCounter = %s  WordCount = %d]", Word.class.getSimpleName(), word, wordCounter, wordCounter.countValue);
    }//toString
    
}
