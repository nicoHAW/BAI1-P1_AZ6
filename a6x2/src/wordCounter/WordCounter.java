package wordCounter;
import java.util.*; 

public class WordCounter {

    //----- VARIABLES -----
    private Map<Word, Counter> wordMap;     //Map for word and counter




    //----- CONSTRUCTOR -----
    public WordCounter() {
        this.wordMap = new HashMap<Word, Counter>();
    }//constructor




    //----- METHODS -----
    public void printStatistic( String givenPath ) { 

        //variables
        WordGrabber wordGrabber = new WordGrabber(givenPath);

        // get words from WordGrabber
        while (wordGrabber.hasNext()) {
            Word currentWord = new Word(wordGrabber.next());

            // put Word in Map with new counter - if already existing increment Counter.
            /*
            Counter currentWordCounter = wordMap.putIfAbsent(currentWord, new Counter());
            currentWordCounter.inc();
            */
            Counter currentWordCounter = wordMap.get(currentWord);
            if ( currentWordCounter == null ) {
                currentWordCounter = new Counter();
                this.wordMap.put(currentWord, currentWordCounter);
            } else currentWordCounter.inc();
        }//while


        // Convert Map to List
        //TODO Word verwenden
        List<Word> wordList = new ArrayList<Word>(wordMap.keySet());

        //sort list
        Collections.sort(wordList);
        
      //print list
        for (Word word : wordList) {
            System.out.printf("\"%s\": %s \n", word, wordMap.get(word));
        }//for
        
      
    }//printStatistics

}
