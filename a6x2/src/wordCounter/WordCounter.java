package wordCounter;
import java.util.*; 

public class WordCounter {

    private String sourcePath;
    // Map<Word> wordMap = new HashMap<word.getWord(), int>;

    public WordCounter() {
        // TODO Auto-generated constructor stub
    }


    public void printStatistic( String givenPath ) { 
        this.sourcePath = givenPath;
        getWord(givenPath);
    }

    private void getWord(String textPath) {
        WordGrabber nextWord = new WordGrabber(textPath);
 
        while (nextWord.hasNext()) {
            Word newWord = new Word(nextWord.next());
            
            
            
        }

    }


}
