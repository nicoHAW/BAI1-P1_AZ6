package testsForThingyCollector;
//
//Der JUnit-Abnahme-Test
//
//Fur die Inbetriebnahme des TestFrames ersetzen Sie:
// am Anfang - etwa Zeile 13
//   /*         durch    //##/*
// dann
//   //##* /    durch    */
// und schließlich (etwa Zeile 122):
//   */         durch    //*##/
//


//##/*
import static org.junit.jupiter.api.Assertions.*;
import static thingyCollector.Collector_I.*;
//
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import thingyCollector.Collector;
import thingyCollector.Collector_I;
import _untouchable_.thingy.*;


public class UnitTestFrameAndStarter {

    @BeforeAll
    public static void runSetupBeforeAnyUnitTestStarts(){
        assert requestedNumberOfDifferentItems == 5 : "Configuration ERROR - 5 was expected as requested number of different items";
        //\=> Collector_I.requestedNumberOfDifferentItems constant has expected value
    }//method()





    /**
     * Ganz einfache Testcase mit 5 unterschiedlichen Items
     */
    @Test
    public void testFiveDifferentItemsSimple(){

        final Collector collector = new Collector();

        final Item[] ia = {
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.BLUE,  Size.MEDIUM, Weight.MEDIUM, 2L ),
                new Item( Color.BROWN, Size.SMALL,  Weight.LIGHT,  3L ),
                new Item( Color.CYAN,  Size.SMALL,  Weight.HEAVY,  4L ),
                new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  5L )
        };
        for( int i=0; i<requestedNumberOfDifferentItems-1; i++ ){
            final Collection<Item> actualResult = collector.process( ia[i] );
            assertNull( actualResult );
        }//for
        final Collection<Item> computedResult = collector.process( ia[requestedNumberOfDifferentItems-1] );
        assertTrue( computedResult.size() == requestedNumberOfDifferentItems );
        for( final Item item : ia ) {
            assertTrue( computedResult.remove( item ));
        }//for
        assertTrue( computedResult.isEmpty() );
    }//method()


    /**
     * Erzeuge alle Kombination von Color x Size x Weight
     * Jedes 5.Mal gibt es 5 unterschiedliche Items
     */
    @Test
    public void testFiveDifferentItemsWithoutDuplicates(){

        final Collector collector = new Collector();

        // prepare for test loop
        Collection<Item> expectedResult = new ArrayList<Item>();
        long value = 1;
        //
        // test loop
        for( final Color color : Color.values() ){
            for( final Size size : Size.values() ){
                for( final Weight weight : Weight.values() ) {
                    final Item item = new Item( color, size, weight, value );
                    expectedResult.add( item );
                    final Collection<Item> computedResult = collector.process( item );
                    if( value%requestedNumberOfDifferentItems == 0 ){
                        assertTrue(
                                isEqualCollection( expectedResult, computedResult ),
                                String.format( "expected: <%s> but was: <%s>", expectedResult, computedResult )
                                );
                        expectedResult.clear();
                    }else{
                        assertNull( computedResult );
                    }//if
                    value++;
                }//for
            }//for
        }//for

    }//method()
    //
    public static boolean isEqualCollection( final Collection<?> coll1,  final Collection<?> coll2 ){
        if( coll1.size() != coll2.size() )  return false;
        for( final Object obj : coll1 ) {
            if( ! coll2.remove( obj ))  return false;
        }//for
        return coll2.isEmpty();
    }//method()



    // Vorschläge fuer weitere Tests
    // ==============================
    // o) Funktioniert reset()?
    // o) Funktioniert Implementierung, wenn sich Items nur in einer Eigenschaft unterscheiden?
    // o) Funktioniert Implementierung, wenn Doppelte auftreten? -> Achtung! (Nicht nur) wegen Aufgabenstellung  DOPPELT ::="Gleich aber NICHT dasselbe (Objekt)"
    // o) Ist Collection, die als Ergebnis von process() abgeliefert wird, geeignet?
    // ...

    //----- Eigene Tests -----

    @Test
    public void testDeliverSameObjects(){

        final Collector collector = new Collector();
        collector.iPrintMyTest(true);

        final Item[] ia = {
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.BROWN, Size.SMALL,  Weight.LIGHT,  3L ),
                new Item( Color.CYAN,  Size.SMALL,  Weight.HEAVY,  4L ),
                new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  5L )
        };
        for( int i=0; i<ia.length; i++ ){
            collector.process( ia[i] );  
        }//for

        int memorySize = collector.getMemorySize();
        assertEquals(1, memorySize); //Memory should be one because double stays in Memory

        int thingySet = collector.getThingySize();
        assertEquals(4, thingySet); //thingy Set should be 4 because 1 is in memory 
        collector.iPrintMyTest(true);

        final Collection<Item> computedResultEins = collector.process( ia[ia.length-1] );
        assertTrue( computedResultEins == null );

    }//method()


    @Test
    public void testDeliverSameObjectsandMore(){

        final Collector collector = new Collector();
        collector.iPrintMyTest(true);

        final Item[] ia = {
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.BROWN, Size.SMALL,  Weight.LIGHT,  3L ),
                new Item( Color.CYAN,  Size.SMALL,  Weight.HEAVY,  4L ),
                new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  5L ),
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.ALABASTER, Size.LARGE,  Weight.HEAVY,  1L ),
        };
        
        Collection<Item> computedResultZwei = null;
        for( int i=0; i<ia.length; i++ ){
            computedResultZwei = collector.process( ia[i] );  
        }//for

        int memorySizeb = collector.getMemorySize();
        assertEquals(1, memorySizeb); //Memory should be one because double stays in Memory

        int thingySetb = collector.getThingySize();
        assertEquals(5, thingySetb); //thingy Set should be 5 because 1 is in memory 

        for (Item tempItem : ia) {
            computedResultZwei.remove(tempItem); 
        }
        
        //deliver 1 more
        collector.process( new Item( Color.AQUA, Size.LARGE,  Weight.HEAVY,  1L ) );
        collector.process( new Item( Color.BEIGE, Size.SMALL,  Weight.HEAVY,  8L ) );
        collector.process( new Item( Color.WHITE, Size.MEDIUM,  Weight.HEAVY,  2L ) );
        collector.process( new Item( Color.AVOCADO, Size.LARGE,  Weight.HEAVY,  4L ) );

        int memorySizec = collector.getMemorySize();
        assertEquals(0, memorySizec); //Memory should be one because double stays in Memory

        int thingySetc = collector.getThingySize();
        assertEquals(5, thingySetc); //thingy Set should be 5 because 1 is in memory 
    }
        
        @Test
        public void testClear(){

            final Collector collector = new Collector();
            collector.iPrintMyTest(true);

            final Item[] ia = {
                    new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                    new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                    new Item( Color.BROWN, Size.SMALL,  Weight.LIGHT,  3L ),
                    new Item( Color.CYAN,  Size.SMALL,  Weight.HEAVY,  4L ),
                    new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  5L )
            };
            for( int i=0; i<ia.length; i++ ){
                collector.process( ia[i] );  
            }//for

            int memorySize = collector.getMemorySize();
            assertEquals(1, memorySize); //Memory should be one because double stays in Memory

            int thingySet = collector.getThingySize();
            assertEquals(4, thingySet); //thingy Set should be 4 because 1 is in memory 
            collector.iPrintMyTest(true);
            
            
            //reset Collector
            collector.reset();
            
            memorySize = collector.getMemorySize();
            assertEquals(0, memorySize); //Memory should be one because double stays in Memory

            thingySet = collector.getThingySize();
            assertEquals(0, thingySet); //thingy Set should be 4 because 1 is in memory 
            collector.iPrintMyTest(true);
            
            


            }//method


}//class
//*##/

