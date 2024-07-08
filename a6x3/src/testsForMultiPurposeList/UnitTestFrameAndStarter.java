// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testsForMultiPurposeList;
//
//Der JUnit-Abnahme-Test
//======================


//Fuer die Inbetriebnahme:
// 1.)  In Zeile 19   /*  löschen
// 2.)  Ganz am Ende  */  löschen
// 3.)  replace  /**  with  /**
// 4.)  replace  */  with  */
//
//
//Zum Auscodieren:
// 1.)  replace  /**  with  /**
// 2.)  replace  */   with  */
//


//#############################################################################
//###
//###   Bei den nachfolgenden IMPORTs sind vermutlich Anpassungen nötig
//###   ===============================================================
//###
//
//Import von "AUDIO", "CD", "Disc", "DVD". "MOVIE", "NTSC", "PAL", "VIDEO"
import static media.Content.AUDIO;
import static media.Content.MOVIE;
import static media.Content.VIDEO;
import static media.Format.NTSC;
import static media.Format.PAL;

//###
//###   Weiterhin muss multiPurposeList.MultiPurposeList<T> implementiert werden.
//###


import multiPurposeList.*;



//#############################################################################
//###
//###   Ab hier sind keine Änderungen mehr erlaubt
//###   ==========================================
//###


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

//
//
import java.time.Duration;
//
import java.util.HashMap;
import java.util.Map;

//
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.function.Executable;

//
//
import media.CD;
import media.DVD;
import media.Disc;
import multiPurposeList.MultiPurposeList;
import multiPurposeList.MultiPurposeList_I;
import stuffBeginnersDontHaveToUnderstand.EnvironmentAnalyzer;
import stuffBeginnersDontHaveToUnderstand.GivenCodeVersion;
import stuffBeginnersDontHaveToUnderstand.Herald;





/**
 * The VERY TestFrame - the official testframe deciding over acceptance or not.<br />
 * <br />
 *
 * JUnit-Test für die MultiPurposeList.
 * Dies ist ein Abnahmetest, der (ursprünglich) bewusst keine Unterstützung bei der Fehlersuche gibt.
 * Testen ist Aufgabe des Produzenten und NICHT des Kunden.
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
@TestMethodOrder(OrderAnnotation.class)
public class UnitTestFrameAndStarter {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_001___2022_06_11__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    // default timeout
    final private static int commonLimit = 4_000;                               // timeout resp. max. number of ms for test
    
    
    
    //
    //
    // test data
    //
    
    final private static Disc[][] testData = new Disc[][]{
        {   new CD( "Sing mit Heino", AUDIO, "Heino" ),
            new DVD( "Augsburger Puppenkiste: Urmel aus dem Eis – Gold Edition", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Led Zeppelin" ),
            new CD( "Quadrophenia", AUDIO, "Who" ),
            new DVD( "Blade Runner", MOVIE, PAL ),
            new DVD( "Cadillac Man", MOVIE, PAL ),
            new DVD( "Sin City - Uncut", MOVIE, NTSC ),
            new DVD( "Gone with the Wind", MOVIE, PAL ),
            new DVD( "David Bowie: Best of Bowie", VIDEO, PAL ),
            new DVD( "The Good, the Bad and the Ugly", MOVIE, PAL ),
            new DVD( "Guardians of the Galaxy", MOVIE, PAL ),
            new DVD( "John Carter", MOVIE, PAL ),
            new DVD( "Silver Streak", MOVIE, NTSC ),
            new DVD( "After Hours", MOVIE, NTSC ),
            new DVD( "Flesh + Blood", MOVIE, NTSC ),
            new DVD( "The Prestige", MOVIE, PAL ),
            new DVD( "The Last King of Scotland", MOVIE, PAL ),
            new DVD( "The Mexican", MOVIE, PAL ),
            new DVD( "Invasion of the Body Snatchers", MOVIE, PAL ),
            new DVD( "Hotel Rwanda", MOVIE, PAL ),
            new CD( "XX", AUDIO, "XX" ),
            new CD( "If You Wait", AUDIO, "London Grammar" ),
            new CD( "Days of Future Passed", AUDIO, "Moody Blues" ),
            new DVD( "Snatch", MOVIE, PAL ),
            new CD( "Traumstation", AUDIO, "Cosa Rosa" ),
            new DVD( "King Kong", MOVIE, PAL ),
            new DVD( "Plunkett & Macleane", MOVIE, PAL ),
            new DVD( "Shrek", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Toto" ),
            new DVD( "The man who would be King", MOVIE, PAL ),
            new DVD( "Night of the Demon", MOVIE, PAL ),
            new DVD( "Galaxy Quest", MOVIE, PAL ),
            new DVD( "johnny got his gun", MOVIE, PAL ),
            new DVD( "Emperor of the North Pole", MOVIE, NTSC ),
            new CD( "Crime of the Century", AUDIO, "Supertramp" )
        },
        //------------------------------------------------------------------
        {   new CD( "Sing mit Heino", AUDIO, "Heino" ),
            new DVD( "Augsburger Puppenkiste: Urmel aus dem Eis – Gold Edition", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Led Zeppelin" ),
            new CD( "Quadrophenia", AUDIO, "Who" ),
            new DVD( "Blade Runner", MOVIE, PAL ),
            new DVD( "Cadillac Man", MOVIE, PAL ),
            new DVD( "Sin City - Uncut", MOVIE, NTSC ),
            new DVD( "Gone with the Wind", MOVIE, PAL ),
            new DVD( "David Bowie: Best of Bowie", VIDEO, PAL ),
            new DVD( "The Good, the Bad and the Ugly", MOVIE, PAL ),
            new DVD( "Guardians of the Galaxy", MOVIE, PAL ),
            new DVD( "John Carter", MOVIE, PAL ),
            new DVD( "Silver Streak", MOVIE, NTSC ),
            new DVD( "After Hours", MOVIE, NTSC ),
            new DVD( "Flesh + Blood", MOVIE, NTSC ),
            new DVD( "The Prestige", MOVIE, PAL ),
            new DVD( "The Last King of Scotland", MOVIE, PAL ),
            new DVD( "The Mexican", MOVIE, PAL ),
            new DVD( "Invasion of the Body Snatchers", MOVIE, PAL ),
            new DVD( "Hotel Rwanda", MOVIE, PAL ),
            new CD( "XX", AUDIO, "XX" ),
            new CD( "If You Wait", AUDIO, "London Grammar" ),
            new CD( "Days of Future Passed", AUDIO, "Moody Blues" ),
            new DVD( "Snatch", MOVIE, PAL ),
            new CD( "Traumstation", AUDIO, "Cosa Rosa" ),
            new DVD( "King Kong", MOVIE, PAL ),
            new DVD( "Plunkett & Macleane", MOVIE, PAL ),
            new DVD( "Shrek", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Toto" ),
            new DVD( "The man who would be King", MOVIE, PAL ),
            new DVD( "Night of the Demon", MOVIE, PAL ),
            new DVD( "Galaxy Quest", MOVIE, PAL ),
            new DVD( "johnny got his gun", MOVIE, PAL ),
            new DVD( "Emperor of the North Pole", MOVIE, NTSC ),
            new CD( "Crime of the Century", AUDIO, "Supertramp" )
        },
        //------------------------------------------------------------------
        {   new CD( "Sing mit Heino", AUDIO, "Heino" ),
            new DVD( "Augsburger Puppenkiste: Urmel aus dem Eis – Gold Edition", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Led Zeppelin" ),
            new CD( "Quadrophenia", AUDIO, "Who" ),
            new DVD( "Blade Runner", MOVIE, PAL ),
            new DVD( "Cadillac Man", MOVIE, PAL ),
            new DVD( "Sin City - Uncut", MOVIE, NTSC ),
            new DVD( "Gone with the Wind", MOVIE, PAL ),
            new DVD( "David Bowie: Best of Bowie", VIDEO, PAL ),
            new DVD( "The Good, the Bad and the Ugly", MOVIE, PAL ),
            new DVD( "Guardians of the Galaxy", MOVIE, PAL ),
            new DVD( "John Carter", MOVIE, PAL ),
            new DVD( "Silver Streak", MOVIE, NTSC ),
            new DVD( "After Hours", MOVIE, NTSC ),
            new DVD( "Flesh + Blood", MOVIE, NTSC ),
            new DVD( "The Prestige", MOVIE, PAL ),
            new DVD( "The Last King of Scotland", MOVIE, PAL ),
            new DVD( "The Mexican", MOVIE, PAL ),
            new DVD( "Invasion of the Body Snatchers", MOVIE, PAL ),
            new DVD( "Hotel Rwanda", MOVIE, PAL ),
            new CD( "XX", AUDIO, "XX" ),
            new CD( "If You Wait", AUDIO, "London Grammar" ),
            new CD( "Days of Future Passed", AUDIO, "Moody Blues" ),
            new DVD( "Snatch", MOVIE, PAL ),
            new CD( "Traumstation", AUDIO, "Cosa Rosa" ),
            new DVD( "King Kong", MOVIE, PAL ),
            new DVD( "Plunkett & Macleane", MOVIE, PAL ),
            new DVD( "Shrek", MOVIE, PAL ),
            new CD( "IV", AUDIO, "Toto" ),
            new DVD( "The man who would be King", MOVIE, PAL ),
            new DVD( "Night of the Demon", MOVIE, PAL ),
            new DVD( "Galaxy Quest", MOVIE, PAL ),
            new DVD( "johnny got his gun", MOVIE, PAL ),
            new DVD( "Emperor of the North Pole", MOVIE, NTSC ),
            new CD( "Crime of the Century", AUDIO, "Supertramp" )
        }
    };
    //
    final private static int numberOfTestSets = 3;                              // as coded above - the number of test "sets" resp. test arrays resp. testData.length
    
    
    private static Map<Disc,Integer> toStateMap( final MultiPurposeList_I<Disc> list ){
        final Map<Disc,Integer> stateMap = new HashMap<Disc,Integer>();
        for ( int index=list.getSize(); --index>=0; ){
            final Disc disc = list.getNo( index );
            final Integer cnt = stateMap.get( disc );
            stateMap.put( disc, ( null==cnt ) ? 1 : cnt+1 );
        }//for
        return stateMap;
    }//method()
    
    private static void checkListAgainstArray( final MultiPurposeList_I<Disc> list,  final Disc[] refArray,  final String errorExplanation ){
        assertEquals(
            refArray.length,                                                    // expected
            list.getSize(),                                                     // computed by code under test
            String.format( "%s -> reference array and list differ in size %d != %d",  errorExplanation, refArray.length, list.getSize() )
        );
        for( int index=refArray.length; --index>=0; ){
            assertEquals(
                refArray[index],                                                // expected
                list.getNo(index),                                              // computed by code under test
                String.format( "%s -> reference element %s is NOT equal element %s",  errorExplanation, refArray[index], list.getNo(index) )
            );
        }//for
    }//method()
    //
    private static void checkListAgainstList( final MultiPurposeList_I<Disc> list,  final MultiPurposeList_I<Disc> refList,  final String errorExplanation ){
        assertEquals(
            refList.getSize(),                                                  // expected
            list.getSize(),                                                     // computed by code under test
            String.format( "%s -> lists differ in size %d != %d",  errorExplanation, refList.getSize(), list.getSize() )
        );
        for( int index=refList.getSize(); --index>=0; ){
            assertEquals(
                refList.getNo(index),                                           // expected
                list.getNo(index),                                              // computed by code under test
                String.format( "%s -> element %s is NOT equal reference element %s",  errorExplanation, refList.getNo(index), list.getNo(index) )
            );
        }//for
    }//method()
    
    private static void fillListWithTestData( final MultiPurposeList_I<Disc> list,  final int testSetId ){
        list.clear();
        for( int i=0; i<testData[testSetId].length; i++ ){
            list.putNo( i, testData[testSetId][i] );
        }//for
        assertTrue(
            testData[testSetId].length == list.getSize(),
            String.format( "unexpected number of elements in list -> %d != %d",  testData[testSetId].length, list.getSize() )
        );
    }//method()
    
    
    
    
    
    @BeforeAll
    public static void init(){
        System.out.printf( "TestFrame information\n" );
        System.out.printf( "=====================\n" );
        System.out.printf( "\n\n" );
        System.out.printf( "Release:\n" );
        System.out.printf( "    TestFrame version:  %s\n",  version.getDecodedVersion() );
        System.out.printf( "    GivenCode version:  %s\n",  GivenCodeVersion.getDecodedVersion() );
        System.out.printf( "\n\n" );
        System.out.printf( "Environment:\n" );
        System.out.printf( "    Java:               %s\n",  EnvironmentAnalyzer.getJavaVersion() );
        System.out.printf( "    JUnit5/Jupiter:     %s\n",  EnvironmentAnalyzer.getJUnitJupiterVersion() );
        System.out.printf( "    JUnit5/Platform:    %s\n",  EnvironmentAnalyzer.getJUnitPlatformVersion() );
        System.out.printf( "    #Cores:             %d\n",  EnvironmentAnalyzer.getAvailableCores() );
        System.out.printf( "\n\n\n\n" );
        System.out.printf( "Start of actual tests\n" );
        System.out.printf( "=====================\n" );
        System.out.printf( "\n" );
        System.out.flush();
        
        
        //
        //
        // TODO  -> Statt 3x nur 1x und verdreifachen                           __???__<220611>
        //
        // check  of data
        if(     ( numberOfTestSets != 3 )
            ||  ( numberOfTestSets != testData.length )
        ){
            throw new IllegalStateException( String.format( "INTERNAL ERROR : inconsistent test data" ) );
        }//if
        //
        // integrity check -> check if all test sets have same size
        final int testSetSize  = testData[0].length;
        if(     ( testSetSize != testData[1].length )
            ||  ( testSetSize != testData[2].length )
        ){
            throw new IllegalStateException( String.format( "INTERNAL ERROR : inconsistent test data" ) );
        }//if
        
        // enough test data?
        if( 35 > testSetSize ) {
            throw new IllegalStateException( String.format( "INTERNAL ERROR : test data is missing" ) );
        }//if
        
        // integrity check -> check is "equal test sets" are actually equal
        for( int i1=0; i1<numberOfTestSets; i1++ ){
            for( int i2=0; i2<testData[0].length; i2++ ){
                for( int i3=1; i3<numberOfTestSets; i3++ ){
                    if( ! testData[i1][i2].equals( testData[(i1+i3) % numberOfTestSets][i2] ))  throw new IllegalStateException( "INTERNAL ERROR : test set integrity broken [equals()]" );
                    if( testData[i1][i2] == testData[(i1+i3) % numberOfTestSets][i2] )  throw new IllegalStateException( "INTERNAL ERROR : integrity broken [==]" );
                }//for
                for( int i3=1; i3<testData[0].length; i3++ ){
                    if( testData[i1][i2].equals( testData[i1][(i2+i3) % testData[0].length] ))  throw new IllegalStateException( "INTERNAL ERROR : test set integrity broken [equals()]" );
                }//for
            }//for
        }//for
        
    }//method()
    
    
    
    
    
    
    
    
    
    
    
    //##
    //##
    //##    start of actual tests
    //##
    
    
    
    //##########################################################################
    /**
     * basic test : testing isEmpty() primarily,
     * but also using and testing in some way:<br />
     * o) putNo(0)<br />
     * o) removeNo(0)<br />
     *
     * Additional heavy tests of getSize are done in the random based copy around tests
     */
    @Test
    @Order(100_0010)
    public void basicTest_isEmpty(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    assertTrue( list.isEmpty() );                               // isEmpty() main focus
                    
                    list.putNo( 0, 1 );                                         // using "putNo( 0, .. )" and hence, testing it ;  Note -> @First & @Last 
                    assertFalse( list.isEmpty() );                              // isEmpty() main focus
                    
                    list.removeNo( 0 );                                         // using "removeNo( 0 )" and hence, testing it
                    assertTrue( list.isEmpty() );                               // isEmpty() main focus
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing getSize() primarily,
     * but also using and testing in some way:<br />
     * o) putNo(@Last)<br />
     * o) removeNo(@First)<br />
     * o) isEmpty()<br />
     *
     * Additional heavy tests of getSize() are done in the random based copy around tests
     */
    @Test
    @Order(100_0020)
    public void basicTest_getSize(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    int noElem = 0;                                             // Number Of ELEMents
                    assertEquals( noElem,  list.getSize() );                    // getSize() main focus
                    
                    do{
                        list.putNo( noElem, noElem );                           // using "putNo()" and hence, testing it    Note -> @Last, noElem! and not list.getSize()
                        noElem++;
                        assertEquals( noElem,  list.getSize() );                // getSize() main focus
                    }while( noElem<42 );                                        // just any number - and "42" is the answer ;-)
                    //
                    for( int i=0; i < 13; i++ ){
                        list.removeNo( 0 );                                     // using "removeNo(0)" and hence, testing it
                        noElem--;
                        assertEquals( noElem,  list.getSize() );                // getSize() main focus
                    }//for
                    
                    while( ! list.isEmpty() ){                                  // using "isEmpty()" and hence, testing it
                        list.removeNo( 0 );                                     // using "removeNo(0)" and hence, testing it
                        noElem--;
                        assertEquals( noElem,  list.getSize() );                // getSize() main focus
                    }//while
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing contains() primarily,
     * but also using and testing in some way:<br />
     * o) put(@Last)<br />
     */
    @Test
    @Order(100_0030)
    public void basicTest_contains(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    
                    for( int i=1; i<42; i++ ){
                        final Object currentObject = i;
                        list.putNo( list.getSize(), currentObject );            // using "putNo(@Last)" and hence, testing it
                        assertTrue( list.contains( currentObject ) );           // contains() main focus
                    }//for
                    
                    assertFalse( list.contains( 0 ) );                          // contains() main focus
                    
                    for( Integer i=1_000; i<1_042; i++ ){
                        String sOrg = i.toString();
                        String sCpy = i.toString();
                        assert sOrg!=sCpy;
                        list.putNo( list.getSize(), sOrg );                     // using "putNo(@Last)" and hence, testing it
                        assertTrue( list.contains( sCpy ) );                    // contains() main focus
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing clear() primarily,
     * but also using and testing in some way:<br />
     * o) contains()<br />
     * o) getSize()<br />
     * o) isEmpty()<br />
     * o) put(@First)<br />
     */
    @Test
    @Order(100_0040)
    public void basicTest_clear(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    
                    for( int i=0; i<10; i++ ){
                        list.putNo( 0, 1 );                                     // using "putNo()" and hence, testing it ;   Note -> @First
                    }//for
                    
                    list.clear();                                               // clear() main focus 
                    
                    assertTrue( list.isEmpty() );                               // using "isEmpty()" and hence, testing it
                    assertEquals( 0, list.getSize() );                          // using "getSize()" and hence, testing it
                    for( int i=0; i<10; i++ ){
                        assertFalse( list.contains( i ) );                      // using "contains()" and hence, testing it
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing putNo() primarily,
     * but also using and testing in some way:<br />
     * o) contains()<br />
     *
     * Additional heavy tests of putNo() are done in the random based copy around tests
     */
    @Test
    @Order(100_0050)
    public void basicTest_putNo(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    
                    for( int i=0; i<10; i++ ){
                        final Object currentObject = i;
                        list.putNo( list.getSize(), currentObject );            // "putNo(@Last)" main focus
                        assertTrue( list.contains( currentObject ) );           // using "contains()" and hence, testing it
                    }//for
                    
                    for( int i=10; i<20; i++ ){
                        final Object currentObject = i;
                        list.putNo( 5, currentObject );                         // "putNo("@middle")" main focus
                        assertTrue( list.contains( currentObject ) );           // ..... "contains()" ...
                    }//for
                    
                    for( int i=0; i<10; i++ ){
                        final Object currentObject = (20+i);
                        list.putNo( 1+2*i, currentObject );                     // "putNo("@middle")" main focus
                        assertTrue( list.contains( currentObject ) );           // ..... "contains()" ...
                    }//for
                    
                    for( int i=30; i<40; i++ ){
                        final Object currentObject = i;
                        list.putNo( 0, currentObject );                         // "putNo(@First)" main focus
                        assertTrue( list.contains( currentObject ) );           // ..... "contains()" ...
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing getNo() primarily,
     * but also using and testing in some way:<br />
     * o) putNo()<br />
     *
     * Additional heavy tests of getNo() are done in the random based copy around tests
     */
    @Test
    @Order(100_0060)
    public void basicTest_getNo(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    
                    Object currentObject = null;
                    for( int i=0; i<42; i++ ){
                        currentObject = i;
                        list.putNo( list.getSize(), currentObject );            // using "putNo()" and hence, testing it ;  Note -> @Last
                        assertTrue( currentObject.equals( list.getNo( i ) ));   // "getNo()" main focus
                    }//for
                    
                    for( int i=42; --i>=0; ){
                        currentObject = i;
                        assertTrue( currentObject.equals( list.getNo( i ) ));   // "getNo()" main focus
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing removeNo() primarily,
     * but also using and testing in some way:<br />
     * o) contains()<br />
     * o) putNo()<br />
     *
     * Additional heavy tests of removeNo() are done in the random based copy around tests
     */
    @Test
    @Order(100_0070)
    public void basicTest_removeNo(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();
                    
                    Object currentObject = null;
                    for( int i=0; i<42; i++ ){
                        currentObject = i;
                        list.putNo( list.getSize(), currentObject );            // using putNo and hence, testing it ;  Note -> @Last
                    }//for
                    
                    for( int i=40; i>=0; i-=5 ){
                        currentObject = i;
                        assertTrue( list.contains( currentObject ) );           // using "contains()" and hence, testing it
                        list.removeNo( i );                                     // "removeNo()" main focus
                        assertFalse( list.contains( currentObject ) );          // ..... "contains()" ...
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing remove() primarily,
     * but also using and testing in some way:<br />
     * o) contains()<br />
     * o) putNo()<br />
     */
    @Test
    @Order(100_0075)
    public void basicTest_remove(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    {//scope
                        final MultiPurposeList_I<Object> list = new MultiPurposeList<Object>();     // type Object for information object
                        
                        Object currentObject = null;
                        for( int i=0; i<42; i++ ){
                            currentObject = i;
                            list.putNo( list.getSize(), currentObject );        // using "putNo()" and hence, testing it ;  Note -> @Last
                        }//for
                        
                        for( int i=40; i>=0; i-=5 ){
                            currentObject = i;
                            assertTrue( list.contains( currentObject ) );       // using "contains()" and hence, testing it
                            assertTrue( list.remove( currentObject ) );         // "remove()" main focus
                            assertFalse( list.contains( currentObject ) );      // using "contains()" and hence, testing it
                        }//for
                        
                        for( int i=40; i>=0; i-=5 ){
                            currentObject = i;
                            assertFalse( list.remove( currentObject ) );        // "remove()" main focus
                        }//for
                    }//scope
                    
                    
                    {//scope
                        final MultiPurposeList_I<String> list = new MultiPurposeList<String>();     // type String for information object
                        
                        for( Integer i=0; i<42; i++ ){
                            final String currentString = i.toString();
                            list.putNo( list.getSize(), currentString );        // using "putNo()" and hence, testing it ;  Note -> @Last
                        }//for
                        
                        for( Integer i=40; i>=0; i-=5 ){
                            final String currentString = i.toString();
                            assertTrue( list.contains( currentString ) );       // using "contains()" and hence, testing it
                            assertTrue( list.remove( currentString ) );         // "remove()" main focus
                            assertFalse( list.contains( currentString ) );      // using "contains()" and hence, testing it
                        }//for
                        
                        for( Integer i=40; i>=0; i-=5 ){
                            final String currentString = i.toString();
                            assertFalse( list.remove( currentString ) );        // "remove()" main focus
                        }//for
                    }//scope
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing setNo() primarily,
     * but also using and testing in some way:<br />
     * o) contains()<br />
     * o) putNo()<br />
     *
     * Additional heavy tests of setNo() are done in the random based copy around tests
     */
    @Test
    @Order(100_0080)
    public void basicTest_setNo(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Integer> list = new MultiPurposeList<Integer>();
                    
                    for( int i=0; i<10; i++ ){
                        final Integer currentInteger = i;
                        list.putNo( i, currentInteger );                        // using "putNo()" and hence, testing it
                    }//for
                    
                    for( int i=0; i<10; i++ ){
                        final Integer currentOldInteger = i;
                        final Integer currentNewInteger = (i+1000);
                        assertTrue(  list.contains( currentOldInteger ) );      // using "contains()" and hence, testing it
                        assertFalse( list.contains( currentNewInteger ) );      // using "contains()" and hence, testing it.
                        final Integer replacedInteger = list.setNo( i, currentNewInteger ); // "setNo()" main focus
                        assertEquals( currentOldInteger, replacedInteger );
                        assertFalse( list.contains( currentOldInteger ) );      // using "contains()" and hence, testing it
                        assertTrue(  list.contains( currentNewInteger ) );      // using "contains()" and hence, testing it
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * basic test : testing simple access sequence
     * but also using and testing in some way:<br />
     * o) contains()<br />
     * o) putNo()<br />
     * o) removeNo()<br />
     *
     * trying to entrap usage of prev pointer to detect errors related to prev pointer
     * test is from Axel Schmolitzky, since combinedTest_copyAround_randomBased() shall NOT have detected such error
     */
    @Test
    @Order(100_0100)
    public void basicTest_simpleAccessSequence(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Integer> list = new MultiPurposeList<Integer>();
                    list.putNo( 0, 22 );                                        // using "putNo()" and hence, testing it
                    list.putNo( 0, 11 );                                        // using "putNo()" and hence, testing it
                    list.removeNo( 1 );                                         // using "removeNo()" and hence, testing it
                    assertTrue( list.contains( 11 ));                           // using "contains()" and hence, testing it
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * Severe positive test : testing combiations of insert-, remove- and extract- operations.
     * This test is random based - meaning, that it's hard to reproduce an exactly same test.
     * If "numberOfRandomBasedTestRuns" is sufficient big, most
     * respectively probably each implementation error will be detected
     */
    @Test
    @Order(100_0210)
    public void combinedTest_copyAround_randomBased(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    
                    //  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                    // setup everything
                    
                    //
                    final Disc[] refTestData = testData[0];
                    
                    // setup empty list
                    final MultiPurposeList_I<Disc> emptyList = new MultiPurposeList<Disc>();
                    assertEquals(
                        0,
                        emptyList.getSize(),
                        "empty list is not empty"
                    );
                    
                    // setup REFerence/original list
                    final MultiPurposeList_I<Disc> refList = new MultiPurposeList<Disc>();
                    for( int i=0; i<refTestData.length; i++ ){
                        refList.putNo( refList.getSize(), refTestData[i] );     // using "putNo(@Last)" and hence, testing it
                    }//for
                    checkListAgainstArray( refList, refTestData, "test setup: 1st check" );     // check, if setup was ok
                    checkListAgainstArray( refList, refTestData, "test setup: 2nd check" );     // check, just for the case that problems arose out of check just before -> "getNo()" was called first time ;-)
                    
                    // setup two work-lists for testing by copying values between same
                    final MultiPurposeList_I<Disc> list1 = new MultiPurposeList<Disc>();
                    final MultiPurposeList_I<Disc> list2 = new MultiPurposeList<Disc>();
                    //
                    // list1 as copy of original list
                    for ( int index=refList.getSize(); --index>=0; ){           // using "getSize()" and hence, testing it
                        final Disc disc = refList.getNo( index );               // using "getNo()" and hence, testing it
                        list1.putNo( 0, disc );                                 // using "putNo(@First)" and hence, testing it
                    }//for
                    checkListAgainstList(  list1, refList,     "test setup: 1st check" );  // check, if list was copied
                    checkListAgainstArray( list1, refTestData, "test setup: 2nd cheup" );  // unnecessary, but for safety's sake
                    
                    
                    
                    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                    // start actual (non random based) testing
                    
                    // remove at end - insert at front
                    while ( list1.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final int lastPosition = list1.getSize() -1;            // using "getSize()" and hence, testing it
                        final Disc disc = list1.getNo( lastPosition );          // using "getNo(@Last)" and hence, testing it
                        list1.removeNo( lastPosition );                         // using "removeNo(@Last)" and hence, testing it
                        list2.putNo( 0, disc );                                 // using "putNo(@First)" and hence, testing it
                    }//while
                    checkListAgainstList( list2, refList,   "remove at end/insert at front" );
                    checkListAgainstList( list1, emptyList, "remove at end/insert at front" );
                    
                    // remove at front - insert at end
                    while ( list2.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list2.getNo( 0 );                     // using "getNo(@First)" and hence, testing it
                        list2.removeNo( 0 );                                    // using "removeNo(@First)" and hence, testing it
                        final int lastPosition = list1.getSize();               // using "getSize()" and hence, testing it
                        list1.putNo( lastPosition, disc );                      // using "putNo(@Last)" and hence, testing it
                    }//while
                    checkListAgainstList( list1, refList,   "remove at front/insert at end" );
                    checkListAgainstList( list2, emptyList, "remove at front/insert at end" );
                    
                    // remove at end - insert at front
                    while ( list1.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list1.getNo( list1.getSize() -1 );    // using "getNo(@Last)" and hence, testing it
                        final int lastPosition = list1.getSize() -1;            // using "getSize()" and hence, testing it
                        list1.removeNo( lastPosition );                         // using "removeNo(@Last)" and hence, testing it
                        list2.putNo( 0, disc );                                 // using "putNo(@First)" and hence, testing it
                    }//while
                    checkListAgainstList( list2, refList,   "remove at end/insert at front" );
                    checkListAgainstList( list1, emptyList, "remove at end/insert at front" );
                    
                    // remove at front - insert at end
                    while ( list2.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list2.getNo( 0 );                     // using "getNo(@First)" and hence, testing it
                        list2.removeNo( 0 );                                    // using "removeNo(@First)" and hence, testing it
                        list1.putNo( list1.getSize(), disc );                   // using "putNo(@Last)" and hence, testing it
                    }//while
                    checkListAgainstList( list1, refList,   "remove at front/insert at end" );
                    checkListAgainstList( list2, emptyList, "remove at front/insert at end)" );
                    
                    // remove at end - insert at front
                    while ( list1.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final int lastPosition = list1.getSize() -1;            // using "getSize()" and hence, testing it
                        final Disc disc = list1.extractNo( lastPosition );      // using "extractNo(last)" and hence, testing it
                        list2.putNo( 0, disc );                                 // using "putNo(@First)" and hence, testing it
                    }//while
                    checkListAgainstList( list2, refList,   "remove at end/insert at front" );
                    checkListAgainstList( list1, emptyList, "remove at end/insert at front" );
                    
                    // remove at front - insert at end
                    while ( list2.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list2.extractNo( 0 );                 // using "extractNo(@First)" and hence, testing it
                        list1.putNo( list1.getSize(), disc );                   // using "putNo(@Last)" and hence, testing it
                    }//while
                    checkListAgainstList( list1, refList,   "remove at front/insert at end" );
                    checkListAgainstList( list2, emptyList, "remove at front/insert at end" );
                    
                    // remove at end - insert at front
                    while ( list1.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list1.extractNo( list1.getSize() -1 );// using "extractNo(last)" and hence, testing it
                        list2.putNo( 0, disc );                                 // using "putNo(@First)" and hence, testing it
                    }//while
                    checkListAgainstList( list2, refList,   "remove at end/insert at front" );
                    checkListAgainstList( list1, emptyList, "remove at end/insert at front" );
                    
                    // remove at front - insert at end
                    while ( list2.getSize() > 0 ){                              // using "getSize()" and hence, testing it
                        final Disc disc = list2.extractNo( 0 );                 // using "extractNo(@First)" and hence, testing itt
                        list1.putNo( list1.getSize(), disc );                   // using "putNo(@Last)" and hence, testing it
                    }//while
                    checkListAgainstList( list1, refList,   "remove at front/insert at end" );
                    checkListAgainstList( list2, emptyList, "remove at front/insert at end" );
                    
                    
                    
                    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                    // prepare for random based testing
                    // store chracteristic data of reference list in original state map
                    final Map<Disc,Integer> originalStateMap = toStateMap( refList );
                    //
                    Map<Disc,Integer> currentStateMap;
                    
                    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                    // start of random based testing
                    final int numberOfRandomBasedTestRuns = 19;
                    for ( int stillToDo=numberOfRandomBasedTestRuns; --stillToDo>=0; ){
                        // copy random based from list1 to list2
                        while ( list1.getSize() > 0 ){
                            final int randomPositionSrc = (int)( Math.random()*(list1.getSize() ));
                            final int randomPositionDst = (int)( Math.random()*(1+list2.getSize() ));
                            final Disc disc = list1.getNo( randomPositionSrc );
                            list1.removeNo( randomPositionSrc );
                            list2.putNo( randomPositionDst, disc );
                        }//while
                        currentStateMap = toStateMap( list2 );
                        assertEquals(
                            originalStateMap,
                            currentStateMap,
                            String.format( "random based \"copy\": getNo(),removeNo(),putNo() -> %s differs from %s",  originalStateMap, currentStateMap )
                        );
                        //
                        // copy random based from list2 to list1
                        while ( list2.getSize() > 0 ){
                            final int randomPositionSrc = (int)( Math.random()*(list2.getSize() ));
                            final int randomPositionDst = (int)( Math.random()*(1+list1.getSize() ));
                            final Disc disc = list2.extractNo( randomPositionSrc );
                            list1.putNo( randomPositionDst, disc );
                        }//while
                        currentStateMap = toStateMap( list1 );
                        assertEquals(
                            originalStateMap,
                            currentStateMap,
                            String.format( "random based \"copy\": extractNo(),putNo() -> %s differs from %s",  originalStateMap, currentStateMap )
                        );
                    }//for
                    
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * Severe positive test : testing setNo() primarily,
     * ...
     * ??? random based ???
     */
    @Test
    @Order(100_0220)
    public void test_setNo_randomBased(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    // integrity checks have been executed @Before ;-)
                    
                    int testSetId = 0;
                    final MultiPurposeList_I<Disc> list = new MultiPurposeList<Disc>();
                    fillListWithTestData( list, testSetId );
                    for( int stillToDo_OuterLoop=3; --stillToDo_OuterLoop>=0; ){
                        //
                        for( int stillToDo_InnerLoop=2; --stillToDo_InnerLoop>=0; ){
                            testSetId = (testSetId+1) % numberOfTestSets;
                            for( int index=testData[testSetId].length; --index>=0; ){   // from rear to front
                                final Disc newDisc = testData[testSetId][index];
                                final Disc oldDisc = list.setNo( index, newDisc );
                                assertEquals(
                                    newDisc,
                                    oldDisc,
                                    String.format( "expectation NOT met -> %s differs from %s",  newDisc, oldDisc )
                                );
                                assertTrue(
                                    newDisc != oldDisc,
                                    String.format( "expectation NOT met -> %s == %s",  newDisc, oldDisc )
                                );
                            }//for  
                        }//for
                        //
                        for( int stillToDo_InnerLoop=2; --stillToDo_InnerLoop>=0; ){
                            testSetId = (testSetId+1) % numberOfTestSets;
                            for( int index=0; index<testData[testSetId].length; index++ ){  // from front to rear
                                final Disc newDisc = testData[testSetId][index];
                                final Disc oldDisc = list.setNo( index, newDisc );
                                assertEquals(
                                    newDisc,
                                    oldDisc,
                                    String.format( "expectation NOT met -> %s differs from %s",  newDisc, oldDisc )
                                );
                                assertTrue(
                                    newDisc != oldDisc,
                                    String.format( "expectation NOT met -> %s == %s",  newDisc, oldDisc )
                                );
                            }//for
                        }//for
                        //
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * Severe positive test : replacing disc by equal but NOT identical discs
     */
    @Test
    @Order(100_0230)
    public void test_replacingElementsByEqualElements_randomBased(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    // integrity checks have been executed @Before ;-)
                    final int testSetSize = testData[0].length;
                    
                    final MultiPurposeList_I<Disc> listA = new MultiPurposeList<Disc>();        // list in which replacements are done
                    final MultiPurposeList_I<Disc> listB = new MultiPurposeList<Disc>();        // work list containing new elements
                    int testSetId = 0;                                          // start/current test set ID
                    fillListWithTestData( listA, testSetId );
                    final int numberOfRandomBasedTestRuns = 19;
                    for( int stillToDo=numberOfRandomBasedTestRuns; --stillToDo>=0; ){
                        testSetId = (testSetId+1) % numberOfTestSets;           // next test set ID  pointing to differnet test set with equal but NOT identical elements
                        fillListWithTestData( listB, testSetId );
                        
                        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                        // replace all elements in old list by equal but NOT identical elements
                        //
                        while ( listB.getSize() > 0 ){
                            final int randomPositionB = (int)( Math.random()*listB.getSize() ); // just some valid position in new list
                            final Disc disc = listB.extractNo( randomPositionB );               // get new element from new list
                            assertTrue(
                                listA.contains( disc ),                         // equal element has to be in old list
                                String.format( "disc NOT found in list -> %s NOT in %s",  disc, listA )
                            );
                            //
                            assertTrue(
                                listA.remove( disc ),                           // removing equal (old) element in old list
                                String.format( "disc NOT removed from list -> %s still in %s",  disc, listA )
                            );
                            //=> (old) disc was removed from old list - at least success was reported
                            //
                            // cross check
                            assertTrue(
                                1+listA.getSize() == testSetSize,               // removed element has to be gone
                                String.format( "disc is NOT missing -> %s (%d>=%d)",  disc, listA.getSize(), testSetSize )
                            );
                            //=> removed element is missing - at least list size shrinked by one
                            // NOW it is checked TWICE -> old element was removed
                            //
                            final int randomPositionA = (int)( 1+Math.random()*listA.getSize() );   // just some valid position in new list
                            listA.putNo( randomPositionA, disc );                                   // inserting equal (new) element in old list
                            assertTrue(
                                listA.getSize() == testSetSize,                 // added element has to increase list size
                                String.format( "disc NOT added -> %s (%d<%d)",  disc, listA.getSize(), testSetSize )
                            );
                            //=> at least list size grew by one
                        }//while
                        //=> listB empty (and all elements replaced in listA)
                        
                        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                        // check replacement
                        //
                        // check if number of elements differ
                        assertTrue(
                            testSetSize == listA.getSize(),                     // number of elements has to be unchanged
                            String.format( "expectation NOT met -> %d != %d",  testSetSize, listA.getSize() )
                        );
                        //=> number of elements unchanged
                        //
                        // check each element if it was replaced
                        for( final Disc disc : testData[testSetId] ){           // check for each new element
                            // search element in old list
                            int index=0;
                            while(( index < listA.getSize() )  &&  ( ! disc.equals( listA.getNo(index)))){ index++; }
                            assertTrue(
                                index < listA.getSize(),                        // element has to be still there
                                String.format( "disc NOT found in list -> %d => %s NOT in (%d : %s)",  index, disc, listA.getSize(), listA )
                            );
                            //=> index points at element found
                            //
                            assertTrue(
                                disc == listA.getNo(index),                     // element is the new one
                                String.format( "same identity expected (%d), but %s != %s",  index, disc, listA.getNo(index) )
                            );
                            //=> element in listA is from listB respectively new test set
                        }//for
                        //=> all elements replaced in listA
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /**
     * ...
     * 
     */
    @Test
    @Order(200_0110)
    public void testSubList1(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Long> list = new MultiPurposeList<Long>();
                    final int listSize = 13;
                    assert listSize <= Integer.MAX_VALUE : "Uuuupppss : Internal setup error";
                    for( long l=0; l<listSize; l++ ) list.putNo( list.getSize(), l );
                    //
                    for( long i=0;  i<listSize; i++ ){
                        final MultiPurposeList_I<Long> computedList = list.subList( i );
                        final int first = (int)( i );
                        for( int x=first; x<listSize; x++ ){
                            assertEquals( x*1L, computedList.getNo( x-first ));
                        }//for
                    }//for
                    
                    assertEquals( 0, list.subList( 1L * -1 ).getSize() );
                    assertEquals( 0, list.subList( 1L * listSize ).getSize() );
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()    
    
    
    //##########################################################################
    /**
     * ...
     * 
     */
    @Test
    @Order(200_0120)
    public void testSubList2(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Long> list = new MultiPurposeList<Long>();
                    final int listSize = 13;
                    assert listSize <= Integer.MAX_VALUE : "Uuuupppss : Internal setup error";
                    for( long l=0; l<listSize; l++ ) list.putNo( list.getSize(), l );
                    //
                    for( long i=0;  i<listSize; i++ ){
                        for( long j=0; j<listSize; j++ ){
                            final MultiPurposeList_I<Long> computedList = list.subList( i, j );
                            final int first = (int)( i < j ? i : j );
                            final int last  = (int)( i > j ? i : j );
                            for( int x=first; x<=last; x++ ){
                                assertEquals( x*1L, computedList.getNo( x-first ) );
                            }//for
                        }//for
                    }//for
                    
                    for( long i=0;  i<listSize; i++ ){
                        final MultiPurposeList_I<Long> computedList = list.subList( i, 1L*listSize );
                        final int first = (int)( i );
                        for( int x=first; x<listSize; x++ ){
                            assertEquals( x*1L, computedList.getNo( x-first ));
                        }//for
                    }//for
                    //
                    for( long i=0;  i<listSize; i++ ){
                        final MultiPurposeList_I<Long> computedList = list.subList( 1L*listSize, i );
                        final int first = (int)( i );
                        for( int x=first; x<listSize; x++ ){
                            assertEquals( x*1L, computedList.getNo( x-first ));
                        }//for
                    }//for
                    
                    assertEquals( 0, list.subList( 1L * -1, 1L * listSize ).getSize() );
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
    
    
    //##########################################################################
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    //@Test
    //@Order(999_0110)
    public void testReverse(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    final MultiPurposeList_I<Long> list = new MultiPurposeList<Long>();
                    for( final int magicBound : new int[]{ 19, 17, 13, 11, 7, 5, 3, 2, 1, 0, 16 } ){
                        
                        for( int i=0;  i<magicBound;  i++ ){
                            list.putNo( i, (long)( i ) );
                        }//for
                        for( int i=0;  i<magicBound;  i++ ){
                            final long expectedValue = i;
                            final long actualValue = list.getNo( i );
                            assertEquals( expectedValue, actualValue );
                        }//for
                        
                        list.reverse();
                        for( int i=0;  i<magicBound;  i++ ){
                            final long expectedValue = magicBound - i -1;
                            final long actualValue = list.getNo( i );
                            assertEquals( expectedValue, actualValue );
                        }//for
                        
                        list.reverse();
                        for( int i=0;  i<magicBound;  i++ ){
                            final long expectedValue = i;
                            final long actualValue = list.getNo( i );
                            assertEquals( expectedValue, actualValue );
                        }//for
                        
                        list.clear();
                    }//for
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    */
    
    
    
    //##########################################################################
    /**
     * ...
     * 
     */
    @Test
    @Order(999_0910)
    public void multipleObjects(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        assertTimeoutPreemptively(
            Duration.ofMillis( commonLimit ),
            new Executable(){                                                   // Executable is executed in a different thread
                @Override
                public void execute() throws Throwable {
                    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    Herald.proclaimTestStart( testName );
                    
                    //
                    //
                    // chapter: test basic/main stuff (ping pong)
                    //
                    /*scope*/{
                        final int objCnt = 3;
                        @SuppressWarnings("unchecked")
                        final MultiPurposeList_I<Long>[] list = (MultiPurposeList_I<Long>[])( new MultiPurposeList_I[objCnt] );
                        // TODO ...
                    }//scope
                    
                    
                    
                    //
                    //
                    // chapter: test reverse()
                    //
                    /*scope*/{
                        final int objCnt = 3;
                        @SuppressWarnings("unchecked")
                        final MultiPurposeList_I<Long>[] list = (MultiPurposeList_I<Long>[])( new MultiPurposeList_I[objCnt] );
                        for( final int magicBound : new int[]{ 13, 7, 2, 1, 0 } ){
                            
                            // setup lists
                            for( int i=0;  i<objCnt;  i++ ){
                                list[i] = new MultiPurposeList<Long>();
                            }//for
                            for( int objId = 0;  objId<objCnt;  objId++ ){
                                for( int i=0;  i<magicBound;  i++ ){
                                    list[objId].putNo( i, (long)( i ) );
                                }//for
                                for( int i=0;  i<magicBound;  i++ ){
                                    final long expectedValue = i;
                                    final long actualValue = list[objId].getNo( i );
                                    assertEquals( expectedValue, actualValue );
                                }//for
                            }//for
                            
                            /*###-----------------------------------------------------------------------
                             *###
                             *### NICHT Teil der Aufgabenstellung
                             *###
                            // test reverse() actually
                            for( int objId = 0;  objId<objCnt;  objId++ ){
                                // reverse one(!) list
                                list[objId].reverse();
                                //
                                // test all lists if still correct
                                for( int localObjId = 0;  localObjId<objCnt;  localObjId++ ){
                                    for( int i=0;  i<magicBound;  i++ ){
                                        final long expectedValue = (localObjId>objId)  ?  i  :  magicBound - i -1;
                                        final long actualValue = list[localObjId].getNo( i );
                                    }//for
                                }//for
                            }//for
                            */
                            
                            for( int objId = 0;  objId<objCnt;  objId++ ){
                                list[objId].clear();
                            }//for
                            
                        }//for
                    }//scope
                    
                    Herald.proclaimTestEnd( testName );
                    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                }//method()
            },                                                                  // end of Executable
            "computation took too long"
        );
    }//method()
    
}//class
