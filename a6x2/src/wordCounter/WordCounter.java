package wordCounter;
import java.util.*; 

public class WordCounter {

    //----- VARIABLES -----
    private String sourcePath;      //path of file. 
    Map<Word, Counter> wordMap;     //Map for word and counter




    //----- CONSTRUCTOR -----
    public WordCounter() {
        this.wordMap = new HashMap<Word, Counter>();
    }//constructor




    //----- METHODS -----
    public void printStatistic( String givenPath ) { 
        //VARIABLES
        this.sourcePath = givenPath;
        WordGrabber nextWord = new WordGrabber(sourcePath);

        // get words
        while (nextWord.hasNext()) {
            Word newWord = new Word(nextWord.next());

            // put Word in Map
            
            
        }
    }//printStatistics

    void iPutInMap(Word CurrentWord) {
        
    


}


}
