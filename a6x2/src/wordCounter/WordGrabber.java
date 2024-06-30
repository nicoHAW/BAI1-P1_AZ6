package wordCounter;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * WordGrabber for "TextProcessor/WordCounter-project"  -  see task
 * 
 * @author   Michael Schaefers (correct german writing: "Michael Schäfers");  P1@Hamburg-UAS.eu 
 * @version  2020/06/06 #2
 */
public class WordGrabber implements Iterator<String>, Iterable<String> {
    
    // declarations----------------------------------------------
    
    // related to usage of  regular expression
    private final BufferedReader br;
    private String line;
    private final Pattern pattern;
    private Matcher matcher;
    
    // related to emulation of iterator
    private boolean wordInBuffer;
    private String bufferedWord;
    
    
    
    
    
    // constructors----------------------------------------------
    
    public WordGrabber( final String fn ){
        try{
            pattern = Pattern.compile( "\\w+" );
            br = new BufferedReader( new FileReader( fn ) );
            line = br.readLine();
            matcher = pattern.matcher( line );
        }catch( final IOException ex ){
            throw new IllegalArgumentException( ex.getMessage() );
        }//try
        wordInBuffer = false;
    }//constructor()
    //
    public WordGrabber(){
        this( "PrincessOfMars.txt" );
    }//constructor()
    
    
    
    
    
    // methods---------------------------------------------------
    
    @Override
    public Iterator<String> iterator(){ return this; }
    
    @Override
    public boolean hasNext(){
        if( wordInBuffer ){
            return true;
        }else{
            bufferedWord = iGetNext();
            wordInBuffer = ( null!=bufferedWord );              // ATTENTION! wordInBuffer belongs to state
            return wordInBuffer;                                // if there is NOT any word in buffer yet, there is none left
        }//if
    }//method()
    
    @Override
    public String next(){
        if( wordInBuffer ){
            wordInBuffer = false;
            return bufferedWord;
        }else{
            bufferedWord = iGetNext();
            if( null==bufferedWord )  throw new NoSuchElementException();
            return bufferedWord;
        }//if
    }//method()
    
    @Override
    public void remove(){ throw new UnsupportedOperationException(); }
    
    
    private String iGetNext(){
        try{
            boolean found;
            found = matcher.find();
            while ( (!found) && (this.line!=null) ){
                line = br.readLine();
                if ( line!=null ){
                    matcher = pattern.matcher( line );
                    found = matcher.find();
                }else{
                    found = false;
                }//if
            }//while
            return  found ? matcher.group() : null;
        }catch( final IOException ex ){
            System.err.printf( ex.getMessage() );
            throw new NoSuchElementException();
        }//try
    }//method()
    
}//class
