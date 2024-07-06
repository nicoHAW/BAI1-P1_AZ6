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
        this.sourcePath = givenPath;
        getWord(givenPath);
    }//printStatistics

    private void getWord(String textPath) {
        WordGrabber nextWord = new WordGrabber(textPath);

        while (nextWord.hasNext()) {
            Word newWord = new Word(nextWord.next());



        }

    }


}
