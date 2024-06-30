package testOfListAnalyzer;


import static cards.Card.Constant.*;

import cards.Card;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import listAnalyzer.FrequencyReporter_I;
//import listAnalyzer.ListAnalyzer;
import listAnalyzer.ListAnalyzer_I;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Die Klasse {@link TestFrameAndStarter} testet die Lösung zur Aufgabe "frequency map" - siehe Aufgabenstellung.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class TestFrameAndStarter {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_003___2023_06_02__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    /**
     * Die Methode {@link #main() testet die Lösung zur Aufgabe "frequency map".
     * ...
     * 
     * @param unused wird nicht genutzt, aber "von Java eingefordert".
     */
    public static void main( final String... unused ){
        
        /*scope*/{
            System.out.printf( "Test#1\n" );
            
            // "Tippel-Schritte"
            final Card[] cardArray = { CJ, DJ, CK, DT, S2, HQ, SA, C4, S2, SQ };
            final List<Card> cardList = Arrays.asList( cardArray );
            
            final ListAnalyzer_I<Card> listAnalyzer = null; //new ListAnalyzer<Card>( cardList );
            System.out.printf( "%s\n",  listAnalyzer.getList() );
            //
            final FrequencyReporter_I<Card> frequencyReporter = listAnalyzer.computeFrequencyReporter();
            for( final Card currentItem : frequencyReporter.knownElements() ){
                System.out.printf( "%3d *  %s\n",  frequencyReporter.getfrequency( currentItem ), currentItem );
            }//for
            
            System.out.printf( "\n\n" );
        }//scope
        
        /*scope*/{
            System.out.printf( "Test#2\n" );
            
            try(
                final Scanner workAroundForSeriousUserInterface = new Scanner( System.in );
            ){
                loop:
                while(true){                                                    // do..while coded as while(true)..break for the "power of constants"
                    System.out.printf( "\n" );
                    System.out.printf( "Gib ein \"Wort\" ein. (Ein einzelner Buchstabe leitet das (Programm-)Ende ein\n" );
                    System.out.printf( "=> " );
                    final String text = workAroundForSeriousUserInterface.next();
                    
                    final List<Character> characterList = new ArrayList<Character>();
                    for( final char c : text.toCharArray() )  characterList.add( c );
                    
                    final ListAnalyzer_I<Character> listAnalyzer = null; //new ListAnalyzer<Character>( characterList );
                    System.out.printf( "Das Wort bzw. die daraus resultierende Liste \"%s\" enthielt die Zeichen:\n",  listAnalyzer.getList() );
                    //
                    final FrequencyReporter_I<Character> frequencyReporter = listAnalyzer.computeFrequencyReporter();
                    for( final Character currentItem : frequencyReporter.knownElements() ){
                        System.out.printf( "%3d *  %s\n",  frequencyReporter.getfrequency( currentItem ), currentItem );
                    }//for
                    //
                    if( 1 >= text.trim().length() )  break loop; //<<<<<<<<<<<<<
                }//while
            }catch( final Throwable ex ){
                if( ! (( ex instanceof AssertionError ) || ( ex instanceof IllegalArgumentException ))){
                    System.out.flush();
                    System.err.printf( "###\n" );
                    System.err.printf( "### Uuuupppss, was ist denn da passiert ????\n" );
                    System.err.printf( "###\n" );
                    System.err.printf( "\n" );
                }//if
                throw( ex );
            }//try
        }//scope
        
    }//method()
    
}//Class
