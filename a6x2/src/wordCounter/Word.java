package wordCounter;

public class Word {
    private String word;
    private int wordCount;
    private String wordLowerCase;
    
    public Word(String givenWord) {
        this.word = givenWord;
        this.wordLowerCase = givenWord.toLowerCase();
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordCount;
    }
    
    
}
