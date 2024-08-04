// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "HOME-VCS": git@git.HAW-Hamburg.de:SHF/Px/LabExercise/CXZ_Thingy[.git]
package _untouchable_.thingy;


import static _untouchable_.thingy.Color.*;
import static _untouchable_.thingy.Size.*;
import static _untouchable_.thingy.Weight.*;
//
import _untouchable_.thingy.internalProjectSupport.Version;


/**
 * Die Klasse {@link ThingyDemo} soll beispielhaft den Umgang mit den "Dingen" aus
 * dem thingy-Package demonstrieren.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public class ThingyDemo {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_002___2022_05_26__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    /**
     * Die Methode {@link #main()} startet die Demo.
     * 
     * @param unused wird nicht genutzt, aber "von Java eingefordert".
     */
    public static void main( final String... unused ){
        
        System.out.printf( "Dies ist eine Demo fuer das Thingy-package bzw. die darin enthaltenen Items.\n" );
        System.out.printf( "Wirklich wichtig ist die %s-Klasse.\n",  Item.class.getSimpleName() );
        System.out.printf( "Diese nutzt die \"Enums\": %s, %s und %s fuer ihre Felder/Exemplarvariablen.\n",  Color.class.getSimpleName(), Size.class.getSimpleName(), Weight.class.getSimpleName() );
        System.out.printf( "Der Rest muss Sie nicht interessieren (ausser diese Demo natuerlich ;-)\n" );
        System.out.printf( "\n\n\n" );
        
        
        
        System.out.printf( "Ein Item erzeugen und dessen Werte ausgeben:\n" );
        Item someItem = new Item( RED, LARGE, HEAVY, 123L );
        System.out.printf( "%s\n", someItem );
        
        Color colorOfItem = someItem.getColor();
        System.out.printf( "Color:  %s\n", colorOfItem );
        
        Size sizeOfItem = someItem.getSize();
        System.out.printf( "Size:   %s\n", sizeOfItem );
        
        Weight weightOfItem = someItem.getWeight();
        System.out.printf( "Weight: %s\n", weightOfItem );
        
        Long valueOfItem = someItem.getValue();
        System.out.printf( "Value:  %d\n", valueOfItem );
        
        System.out.printf( "\n\n\n" );
        
        
        
        System.out.printf( "Ein teures Item erzeugen und dessen Werte ausgeben:\n" );
        Item expensiveItem = new Item( GOLD, TINY, LIGHT, 9_223_372_036_854_775_807L );
        System.out.printf( "%s\n", expensiveItem );
        
        colorOfItem = expensiveItem.getColor();
        System.out.printf( "Color:  %s\n", colorOfItem );
        
        sizeOfItem = expensiveItem.getSize();
        System.out.printf( "Size:   %s\n", sizeOfItem );
        
        weightOfItem = expensiveItem.getWeight();
        System.out.printf( "Weight: %s\n", weightOfItem );
        
        valueOfItem = expensiveItem.getValue();
        System.out.printf( "Value:  %d\n", valueOfItem );
        
        System.out.printf( "\n\n\n" );
        
        
        
        System.out.printf( "2 Items mit equals() vergleichen:\n" );
        boolean isEqual = someItem.equals( expensiveItem );
        System.out.printf(
            "%s =?= %s  ->  %s\n",
            someItem,
            expensiveItem,
            isEqual
        );
        System.out.printf( "\n" );
        
        System.out.printf( "Die Farben zweier Items mit equals() vergleichen:\n" );
        Color color1stItem = someItem.getColor();
        Color color2ndItem = expensiveItem.getColor();
        isEqual = color1stItem.equals( color2ndItem );
        System.out.printf(
            "%s =?= %s  ->  %s\n",
            color1stItem,
            color2ndItem,
            isEqual
        );
        System.out.printf( "\n" );
        
        System.out.printf( "hashCode fuer die beiden Items anschauen:\n" );
        System.out.printf( "%s  ->  %d\n",  someItem, someItem.hashCode() );
        System.out.printf( "%s  ->  %d\n",  expensiveItem, expensiveItem.hashCode() );
        
        System.out.printf( "\n\n\n" );
        
        
        
        System.out.printf( "Farben, die ein Item aufweisen kann (zurzeit):\n" );
        for( Color currentColor : Color.values() )  System.out.printf( "%s ",  currentColor );
        System.out.printf( "\n" );
        System.out.printf( "Es werden %d Farben unterstuetzt (zurzeit).\n",  Color.values().length );
        System.out.printf( "\n" );
        
        System.out.printf( "Groessen, die ein Item aufweisen kann (zurzeit):\n" );
        for( Size currentSize : Size.values() )  System.out.printf( "%s ",  currentSize );
        System.out.printf( "\n" );
        System.out.printf( "Es werden %d Groessen unterstuetzt (zurzeit).\n",  Size.values().length );
        System.out.printf( "\n" );
        
        System.out.printf( "\"Gewichtsklassen\", die ein Item aufweisen kann (zurzeit):\n" );
        for( Weight currentWeight : Weight.values() )  System.out.printf( "%s ",  currentWeight );
        System.out.printf( "\n" );
        System.out.printf( "Es werden %d \"Gewichtsklassen\" unterstuetzt (zurzeit).\n",  Weight.values().length );
        System.out.printf( "\n" );
        
        System.out.printf( "Bzgl. des Werts(value) eines Items ist zunaechst jeder Long-Wert moeglich.\n" );
        System.out.printf( "Das sind 18_446744_073709_551616 (=2^64) Werte.\n" );
        System.out.printf( "U.U. schraenkt die konkrete Aufgabenstellung dies ein.\n" );
        System.out.printf( "\n\n\n" );
        
        
        
        System.out.printf(
            "ACHTUNG!\n"
          + "========\n"
          + "Sofern die Thingies/Items Teil der Rechnerpruefung werden, sind die Thingies/Items\n"
          + "o) in ihrem grundsaetzlichen Aufbau identisch, aber\n"
          + "o) in ihren konkreten Auspraegungen u.U. anders!\n"
          + "   Also konkrete Farben usw.\n"
          + "\n"
          + "P.S:\n"
          + "Wenn Sie meinen, es fehlt eine wichtige Farbe, lassen Sie es mich wissen, ich nehme sie auf."
        );
    }//method()
    
}//class
