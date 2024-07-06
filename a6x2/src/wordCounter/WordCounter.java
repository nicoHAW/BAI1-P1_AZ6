package wordCounter;
import java.util.*; 

public class WordCounter {

    //----- VARIABLES -----
    private String sourcePath;      //path of file. 
    private Map<Word, Counter> wordMap;     //Map for word and counter




    //----- CONSTRUCTOR -----
    public WordCounter() {
        this.wordMap = new HashMap<Word, Counter>();
    }//constructor




    //----- METHODS -----
    public void printStatistic( String givenPath ) { 

        //variables
        this.sourcePath = givenPath;
        WordGrabber nextWord = new WordGrabber(sourcePath);

        // get words from WordGrabber
        while (nextWord.hasNext()) {
            Word newWord = new Word(nextWord.next());

            // put Word in Map with new counter - if already existing increment Counter.
            if (!this.wordMap.containsKey(newWord)) {
                Counter newWordCounter = new Counter();
                this.wordMap.put(newWord, newWordCounter);
            } else this.wordMap.get(newWord).inc();

        }//while


        // Convert Map to List
        List<String> wordList = new ArrayList<String>();

        // go through every single entry and put in list.
        for (Map.Entry<Word, Counter> content : this.wordMap.entrySet() ) {
            Word keyWord = content.getKey();
            Counter counterWord = content.getValue();

            //new string out of keyword and counter
            String wordAndCounter = keyWord.toString() + counterWord.toString();

            //add new string to list.
            wordList.add(wordAndCounter);
        }

        //sort list
        wordList.sort(null);;

        //print list
        for (String sorted : wordList) {
            System.out.println(sorted);
        }


    }//printStatistics

}
