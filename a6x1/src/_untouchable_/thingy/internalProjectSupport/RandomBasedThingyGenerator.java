//"HOME-VCS": git@git.HAW-Hamburg.de:SHF/Px/LabExercise/CXZ_Thingy[.git]
package _untouchable_.thingy.internalProjectSupport;


import java.io.Serializable;
import java.util.Random;

import _untouchable_.thingy.Color;
import _untouchable_.thingy.Item;
import _untouchable_.thingy.Size;
import _untouchable_.thingy.Weight;


/**
 * Die Klasse RandomBasedThingyGenerator erlaubt es
 * mittels der Methode create()
 * zufaellige Items zu generieren.
 *<br />
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class RandomBasedThingyGenerator implements Serializable {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_003___2022_05_26__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    private static final long serialVersionUID = version.getVersionNumber();
    
    
    
    static final private int numberOfColors = Color.values().length;
    static final private int numberOfSizes = Size.values().length;
    static final private int numberOfWeights = Weight.values().length;
    
    
    
    private final boolean useFullRangeLongRandom;
    private final RandomBasedOnPRBS fullRangeLongRandom;
    private final Random randomGenerator;
    private final int maxValue;
    
    
    
    
    public RandomBasedThingyGenerator( final int maxValue ){
        if( 0>maxValue ) {
            if( Integer.MIN_VALUE != maxValue ){
                throw new IllegalArgumentException( "maxValue has to be actually positiv" );
            }else{
                // "secret easter egg", configure to use full range of long ( without 0 )
                useFullRangeLongRandom = true;
                fullRangeLongRandom = new RandomBasedOnPRBS( 0xAA55_EE33__5AA5_77CCL );
            }//if
        }else{
            useFullRangeLongRandom = false;
            fullRangeLongRandom = null;
        }//if
        randomGenerator = new Random();
        this.maxValue = maxValue;
    }//constructor()
    //
    public RandomBasedThingyGenerator(){
        this( 1_000_000_000 );
    }//constructor()
    
    
    
    /**
     * Die Methode create() generiert ein zufaelliges Item.
     * Der Wert (value) des erzeugten Items liegt im zuvor im Konstruktor definierten Bereich.
     * 
     * @return zufaellig generiertes Item
     */
    public Item create(){
        final Color randomGeneratedColor = Color.values()[ randomGenerator.nextInt( numberOfColors ) ];     // any color
        final Size randomGeneratedSize = Size.values()[ randomGenerator.nextInt( numberOfSizes ) ];         // any size
        final Weight randomGeneratedWeight = Weight.values()[ randomGenerator.nextInt( numberOfWeights ) ]; // any weight
        final Long ramdonGeneratedValue =
           useFullRangeLongRandom
           ? fullRangeLongRandom.nextLong()                                     // long in full range
           : (long)( randomGenerator.nextInt( maxValue ));                      // long in limited range
        final Item randomGeneratedItem = new Item( randomGeneratedColor, randomGeneratedSize, randomGeneratedWeight, ramdonGeneratedValue );
        return randomGeneratedItem;
    }//method()
    //
    /**
     * Eine create()-Methoden-Variante.
     * Die Methode create() generiert ein zufaelliges Item.
     * Der Wert (value) des erzeugten Items liegt im als Parameter uebergebenen Wertebereich.
     * 
     * @param maxValue  bestimmt Wertebereich des Werts (value)
     * @return zufaellig generiertes Item
     */
    public Item create( final Long[] codomain ){
        assert null != codomain : "Illegal Argument : null NOT supported";
        assert 1 <= codomain.length : "Illegal Argument : at least one value is necessary";
        
        final Color randomGeneratedColor = Color.values()[ randomGenerator.nextInt( numberOfColors ) ];     // any color
        final Size randomGeneratedSize = Size.values()[ randomGenerator.nextInt( numberOfSizes ) ];         // any size
        final Weight randomGeneratedWeight = Weight.values()[ randomGenerator.nextInt( numberOfWeights ) ]; // any weight
        final Long ramdonGeneratedValue = codomain[ randomGenerator.nextInt( codomain.length ) ];           // long in given codomain
        final Item randomGeneratedItem = new Item( randomGeneratedColor, randomGeneratedSize, randomGeneratedWeight, ramdonGeneratedValue );
        return randomGeneratedItem;
    }//method()
    
}//class
