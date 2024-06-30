// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testOfCollectionConverter;


import static org.junit.jupiter.api.Assertions.*;
//
import collectionConverter.Converter_I;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stuffBeginnersDontHaveToUnderstand.EnvironmentAnalyzer;
import stuffBeginnersDontHaveToUnderstand.GivenCodeVersion;
import stuffBeginnersDontHaveToUnderstand.Herald;
import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * (Unit-)TestFrame for Palindrome Tester
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class UnitTestFrameAndStarter{
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_009___2023_05_31__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    final static private String requestedRefTypeQualified = "collectionConverter.Converter";
    
    
    
    
    
    //##########################################################################
    //###
    //###   the TEST itself
    //###
    
    @BeforeAll
    public static void runSetupBeforeAnyUnitTestStarts(){
        
        // print some information at start
        System.out.printf( "TestFrame information\n" );
        System.out.printf( "=====================\n" );
        System.out.printf( "\n\n" );
        //
        System.out.printf( "Release:\n" );
        System.out.printf( "    GivenCode version:      %s\n",  GivenCodeVersion.getDecodedVersion() );
        System.out.printf( "    TestFrame version:      %s\n",  version.getDecodedVersion() );
        System.out.printf( "\n\n" );
        //
        System.out.printf( "Environment:\n" );
        System.out.printf( "    #Cores:                 %d\n",  EnvironmentAnalyzer.getAvailableCores() );
        System.out.printf( "    Java:                   %s\n",  EnvironmentAnalyzer.getJavaVersion() );
        System.out.printf( "    JUnit5/Jupiter:         %s\n",  EnvironmentAnalyzer.getJUnitJupiterVersion() );
        System.out.printf( "    JUnit5/Platform:        %s\n",  EnvironmentAnalyzer.getJUnitPlatformVersion() );
        System.out.printf( "    assert enabled?:        %s\n",  EnvironmentAnalyzer.isAssertEnabled() );
        System.out.printf( "    UTF-8 configured?:      %s      <- check output\n",  "[ÄËÏÖÜẞäëïöüß␣🙂😉🙁😟😓😎☠]" );
        System.out.printf( "\n\n\n\n" );
        //
        System.out.printf( "################################################################################" );
        System.out.printf( "\n" );
        System.out.printf( "Start of actual tests\n" );
        System.out.printf( "=====================\n" );
        System.out.printf( "Remember: The main point is the \"green bar\" (in the JUnit-window).\n" );
        System.out.printf( "\n" );
        //
        System.out.flush();
    }//method()    
    
    
    
    
    
    /** simple test: just a simple map as actual parameter for toList() */
    @Test
    public void testSimple01(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test input/parameter
        final Map<Object,Map<Object,Object>> tmpOuterMap = new HashMap<Object,Map<Object,Object>>();
        final Map<Object,Object> tmpInnerMap = new HashMap<Object,Object>();
        tmpInnerMap.put( 11, 110 );
        tmpOuterMap.put( 1, tmpInnerMap );
        final Map<Object,Map<Object,Object>> stimulus = tmpOuterMap;
        //
        // prepare expected result
        final List<Object> expectedResult = new ArrayList<Object>( Arrays.asList( 1, 11, 110 ));
        //
        // do actual test
        final List<Object> computedResult = converter.toList( stimulus );
        //
        // check test result
        assertEquals( expectedResult, computedResult );
    }//method()
    
    
    /** simple test: just a simple list as actual parameter for toNestedMap() - map&list from test01 are used */
    @Test
    public void testSimple11(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test input/parameter
        final List<Object> stimulus = new ArrayList<Object>( Arrays.asList( 1, 11, 110 ));
        //
        // prepare expected result
        final Map<Object,Map<Object,Object>> tmpOuterMap = new HashMap<Object,Map<Object,Object>>();
        final Map<Object,Object> tmpInnerMap = new HashMap<Object,Object>();
        tmpInnerMap.put( 11, 110 );
        tmpOuterMap.put( 1, tmpInnerMap );
        final Map<Object,Map<Object,Object>> expectedResult = tmpOuterMap;
        //
        // do actual test
        final Map<Object,Map<Object,Object>> computedResult = converter.toNestedMap( stimulus );
        //
        // check test result
        assertEquals( expectedResult, computedResult );
    }//method()
    
    
    /** simple test: just a simple list as actual parameter for toNestedMap() */
    @Test
    public void testSimple12(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test parameter
        final Integer[] tmpTestInputRaw = {
            1, 11, 110,
            2, 21, 210,
            2, 22, 220
        };
        final List<Integer> tmpListOfInteger = Arrays.asList( tmpTestInputRaw );
        final List<Object> stimulus = new ArrayList<Object>( tmpListOfInteger );
        //
        // do actual test
        final Map<Object,Map<Object,Object>> computedResult = converter.toNestedMap( stimulus );
        //
        //check test result
        assertEquals( 2, computedResult.size() );
        for( final Object exteriorKey : computedResult.keySet() ){
            final Map<Object,Object> interiorMap = computedResult.get( exteriorKey );
            assertEquals( exteriorKey, interiorMap.size() );
            for( final Object interiorKey : interiorMap.keySet() ){
                final Object interiorData = interiorMap.get( interiorKey );
                assertEquals( interiorKey, (int)( interiorData )/10 );
                assertEquals( exteriorKey, (int)( interiorKey )/10 );
            }//for
        }//for
    }//method()
    
    
    /** simple test: just a simple list as actual parameter for toNestedMap() */
    @Test
    public void testSimple13(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test input/parameter
        final Integer[] tmpTestInputRaw = {
            3, 31, 310,
            3, 32, 320,
            3, 33, 330,
            1, 11, 110,
            4, 41, 410,
            4, 42, 420,
            4, 43, 430,
            4, 44, 440,
            2, 21, 210,
            2, 22, 220
        };
        final List<Integer> tmpListOfInteger = Arrays.asList( tmpTestInputRaw );
        final List<Object> stimulus = new ArrayList<Object>( tmpListOfInteger );
        //
        // do actual test
        final Map<Object,Map<Object,Object>> computedResult = converter.toNestedMap( stimulus );
        //
        // check test result
        assertEquals( 4, computedResult.size() );
        for( final Object exteriorKey : computedResult.keySet() ){
            final Map<Object,Object> interiorMap = computedResult.get( exteriorKey );
            assertEquals( exteriorKey, interiorMap.size() );
            for( final Object interiorKey : interiorMap.keySet() ){
                final Object interiorData = interiorMap.get( interiorKey );
                assertEquals( interiorKey, (int)( interiorData )/10 );
                assertEquals( exteriorKey, (int)( interiorKey )/10 );
            }//for
        }//for
    }//method()
    
    
    
    
    
    /** test with bigger map as actual parameter for toList() */
    @Test
    public void test01(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test input/parameter
        final Map<Object,Map<Object,Object>> tmpOuterMap = new HashMap<Object,Map<Object,Object>>();
        for( int i=1; i<10; i++ ){
            final Map<Object,Object> tmpInnerMap = new HashMap<Object,Object>();
            for( int j=1; j<=i; j++ ){
                final int key = j*10 +j;
                final int data = key*10 +j; 
                tmpInnerMap.put( key, data );
            }//for
            tmpOuterMap.put( i, tmpInnerMap );
        }//for
        final Map<Object,Map<Object,Object>> stimulus = tmpOuterMap;
        //
        // do actual test
        final List<Object> computedResultList = converter.toList( stimulus );
        //
        // check test result
        assertEquals( 135, computedResultList.size() );
    }//method()
    
    
    /** test with bigger list as actual parameter for toNested() - map&list from test01 are used */
    @Test
    public void test02(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test input/parameter
        final Map<Object,Map<Object,Object>> tmpOuterMap = new HashMap<Object,Map<Object,Object>>();
        //
        for( int i=9; i>0; i-- ){
            final Map<Object,Object> tmpInnerMap = new HashMap<Object,Object>();
            for( int j=1; j<=i; j++ ){
                final int key = j*10 +j;
                final int data = key*10 +j; 
                tmpInnerMap.put( key, data );
            }//for
            tmpOuterMap.put( i, tmpInnerMap );
        }//for
        final Map<Object,Map<Object,Object>> stimulus = tmpOuterMap;
        //
        // do actual test
        final List<Object> computedResultList = converter.toList( stimulus );
        //
        // check test result
        assertEquals( 135, computedResultList.size() );
        //
        // and back again
        final Map<Object,Map<Object,Object>> computedResultMap = converter.toNestedMap( computedResultList );
        assertEquals( stimulus, computedResultMap );
    }//method()
    
    
    /**
     * Test with different random generated maps as actual parameter for toNestedMap(toList())
     * and checks, if map equal to original map, is reproduced again.<br />
     * <br />
     * <br />
     * Achtung! Dies ist ein zufallsbasierter Test.<br />
     * Zufallsbasierte Tests sind NICHT unumstritten bzw. sehr umstritten.
     * Richtig eingesetzt und gedeutet sind sie jedoch sehr wertvoll.<br />
     * <br />
     * 1) Es gibt unzählig viele Testmöglichkeiten.
     * Selbst wenn Sie diesen Test nach einer Fehlermeldung mehr als tausend Mal auführen und dieser Test keine Fehler mehr findet,
     * können Sie trotzdem nicht sicher sein, dass Sie "den Fehler" behoben haben.<br />
     * <br />
     * 2) Dieser Test sollte/darf nicht allein anschlagen. Min. ein Test ohne "random"-Markierung sollte/muss ebenfalls angeschlagen haben.
     * Konzentrieren Sie sich (zunächst) darauf, dass diese(r) Test(s) keine Fehler mehr findet.<br />
     * <br />
     * 3) Sollte nur dieser Test bzw. nur Tests mit "random"-Markierung anschlagen, dann haben Sie eine "Testlücke" entdeckt.
     * Machen Sie bitte einen Screenshot von JUnit (bzw. den JUnit-Tests) und von der Fehlermeldung dieses Tests und geben Sie bitte Rückmeldung
     * mit dem Ziel, dass die TestLücke geschlossen wird.<br />
     * Und bedenken Sie, dass dieser Test einen Fehler in Ihrer Implementierung aufgezeigt hat 😉
     */
    @Test
    public void randomBasedTest01(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        for( int runsStillToDo = 42; --runsStillToDo>0; ){                      // foreach random based test
            int innerEntryCnt = 0;
            //
            // prepare test input/parameter
            final List<Integer> li = new ArrayList<Integer>( Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 ));
            final Map<Object,Map<Object,Object>> outerMap = new HashMap<Object,Map<Object,Object>>();
            for( int stillToDo=7; --stillToDo>0; ){
                final int index =  (int)( li.size() * Math.random() );
                final Map<Object,Object> innerMap = new HashMap<Object,Object>();
                final int leadInt = li.remove( index );
                final int max = (int)( 9 * Math.random() +1 );
                innerEntryCnt += max;
                for( int i= max; --i>=0; ){
                    final int key = leadInt*10 +i;
                    final int data = key*10 +i; 
                    innerMap.put( key, data );
                }//for
                outerMap.put( leadInt, innerMap );
            }//for
            final Map<Object,Map<Object,Object>> stimulus = outerMap;
            //
            // do actual test
            List<Object> computedResultList = converter.toList( stimulus );
            for( int stillToDo=5; --stillToDo>0; ){
                assertEquals( 3*innerEntryCnt, computedResultList.size() );     // check test result
                computedResultList = converter.toList( converter.toNestedMap( computedResultList ));
            }//for
            //
            // and back again
            final Map<Object,Map<Object,Object>> computedResultMap = converter.toNestedMap( computedResultList );
            assertEquals( stimulus, computedResultMap );
        }//for
    }//method()
    
    
    
    
    
    /** extreme test: list with wrong number of elements as actual parameter for toNestedMap() */
    @Test
    public void extremeTest01(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        int elemCnt = 1;
        while( 42 > elemCnt ){
            //
            // prepare test        
            boolean expectedExceptionDetected = false;
            final List<Object> stimulus = new ArrayList<Object>();
            for( int elem=0;  elem<elemCnt;  elem++ )  stimulus.add( elem );
            //
            // do actual test
            try{
                @SuppressWarnings("unused")
                final Map<Object,Map<Object,Object>> throwAwayComputedResult = converter.toNestedMap( stimulus );
            }catch( final IllegalArgumentException | AssertionError ex ){
                expectedExceptionDetected = true;
            }finally{
                //check test result
                if( ! expectedExceptionDetected ){
                    Herald.proclaimError( String.format(
                        "ERROR in %s expected reaction did NOT occur\n",
                        testName
                    ));
                    fail();
                }//if
            }//try
            //
            elemCnt +=  (2==elemCnt%3) ? 2 : 1;                                 // skip multiples of 3
        }//while
    }//method()
    
    
    /** extreme test: empty list as actual parameter for toNestedMap() */
    @Test
    public void extremeTest11(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // do actual test
        final Map<Object,Map<Object,Object>> computedResult = converter.toNestedMap( new ArrayList<Object>() );
        //
        //check test result
        assertTrue( computedResult.isEmpty() );
    }//method()
    
    
    /** extreme test: empty map as actual parameter for toList() */
    @Test
    public void extremeTest12(){
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // do actual test
        final List<Object> computedResult = converter.toList( new HashMap<Object,Map<Object,Object>>() );
        //
        //check test result
        assertTrue( computedResult.isEmpty() );
    }//method()
    
    
    
    /** extreme test: list is null */
    @Test
    public void extremeTest21(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test        
        boolean expectedExceptionDetected = false;
        //
        // do actual test
        try{
            @SuppressWarnings("unused")
            final Map<Object,Map<Object,Object>> throwAwayComputedResult = converter.toNestedMap( null );
        }catch( final IllegalArgumentException | AssertionError ex ){
            expectedExceptionDetected = true;
        }finally{
            //check test result
            if( ! expectedExceptionDetected ){
                Herald.proclaimError( String.format(
                    "ERROR in %s expected reaction did NOT occur\n",
                    testName
                ));
                fail();
            }//if
        }//try
    }//method()    
    
    
    /** extreme test: list element is null */
    @Test
    public void extremeTest22(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        int elemCnt = 3;
        while( 42 > elemCnt ){
            for( int indexOfNull=elemCnt; --indexOfNull>=0; ){
                //
                // prepare test        
                final List<Object> stimulus = new ArrayList<Object>();
                for( int elem=0;  elem<elemCnt;  elem++ ){                      // elem is both: list element
                    if( indexOfNull==elem ){                                    //...and index of list element
                        stimulus.add( null );
                    }else {
                        stimulus.add( elem );
                    }//if
                }//for
                //
                boolean expectedExceptionDetected = false;
                //
                // do actual test
                try{
                    @SuppressWarnings("unused")
                    final Map<Object,Map<Object,Object>> throwAwayComputedResult = converter.toNestedMap( stimulus );
                }catch( final IllegalArgumentException | AssertionError ex ){
                    expectedExceptionDetected = true;
                }finally{
                    //check test result
                    if( ! expectedExceptionDetected ){
                        Herald.proclaimError( String.format(
                            "ERROR in %s expected reaction did NOT occur\n",
                            testName
                        ));
                        fail();
                    }//if
                }//try
            }//for
            //
        elemCnt += 3;
        }//while
    }//method()    
    
    
    
    /** extreme test: map is null */
    @Test
    public void extremeTest31(){
        final String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        final Converter_I converter = (Converter_I)( generateRequestedObject( requestedRefTypeQualified ));
        //
        // prepare test        
        boolean expectedExceptionDetected = false;
        //
        // do actual test
        try{
            @SuppressWarnings("unused")
            final List<Object> throwAwayComputedResult = converter.toList( null );
        }catch( final IllegalArgumentException | AssertionError ex ){
            expectedExceptionDetected = true;
        }finally{
            //check test result
            if( ! expectedExceptionDetected ){
                Herald.proclaimError( String.format(
                    "ERROR in %s expected reaction did NOT occur\n",
                    testName
                ));
                fail();
            }//if
        }//try
    }//method()
    
    
    
    
    
    @AfterAll
    public static void tearDownAfterAllUnitTestsHaveFinished(){
        System.out.printf( "\n" );
        System.out.printf( "################################################################################\n" );
        System.out.printf( "THE END" );
        System.out.flush();
    }//method()
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
    
    
    
    
    
    //###
    //###
    //### support stuff
    //###
    
    
    //##########################################################################
    //###
    //###   taken from "TS class"
    //###
    
    private static class TestSupportException extends RuntimeException {
        
        final private String errorMessage;
        final private Throwable causingThrowable;
        final static private long serialVersionUID = 2017_11_05_001L;
        
        private TestSupportException( final String message,  final Throwable throwable ){   // package scope on purpose
            super( message );
            causingThrowable = throwable;
            if( null!=causingThrowable ){
                errorMessage = " (caused by: \"" + causingThrowable.toString() + "\")";
            }else{
                errorMessage = message;
            }//if
        }//constructor()
        private TestSupportException( final String message ){
            this( message, new Throwable( "NO causing throwable existent - directly thrown : "+message ));
        }//constructor()
        private TestSupportException(){
            this( "test support functionality broken" );
        }//constructor()
        
        @Override
        public Throwable getCause(){
            return causingThrowable;
        }//method()
        
        @Override
        public String getMessage(){
            return errorMessage;
        }//method()
        
    }//class
    
    
    
    
    
    private static Object generateRequestedObject (
        final String      requestedClassName,
        final Class<?>[]  requestedParameterTypes,
        final Object[]    actualParameter
    ) throws TestSupportException {
        try{
            final Class<?> requestedClass = Class.forName( requestedClassName );
            final Object constructedObject = callConstructor( requestedClass, requestedParameterTypes, actualParameter );
            return constructedObject;
        }catch( final ClassNotFoundException ex ){
            Herald.proclaimError( String.format(
                "ERROR : Can NOT create object from %s\n",
                requestedClassName
            ));
            throw new TestSupportException( String.format( "object of \"%s\" can NOT be generated properly", requestedClassName ),  ex );
        }//try
    }//method()
    //
    private static Object generateRequestedObject(
        final String  requestedClassName
    ) throws TestSupportException {
        return generateRequestedObject( requestedClassName, null, null );
    }//method()
    
    private static Object callConstructor (
        final Class<?>    classUnderTest,
        final Class<?>[]  requestedParameterTypes,
        final Object[]    actualParameter
    ) throws TestSupportException {
        try{
            final Constructor<?> constructor = classUnderTest.getConstructor( requestedParameterTypes );
            final Object constructedObject = constructor.newInstance( actualParameter );
            return constructedObject;
        }catch( final NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex ){
            throw new TestSupportException( String.format( "constructor for \"%s\" can NOT be called properly", classUnderTest.getSimpleName() ),  ex );
        }//try 
    }//method()
    
    private static Object callFunction(
        final Object objectUnderTest,
        final String requestedMethodName,
        final Class<?>[] requestedParameterTypes,
        final Object[] actualParameter
    ){
        try{
            final Class<?> classOfObjectUnderTest = objectUnderTest.getClass();
            final Method method = classOfObjectUnderTest.getMethod( requestedMethodName, requestedParameterTypes );
            final Object result = method.invoke( objectUnderTest, actualParameter );
            return result;
        }catch( final NoSuchMethodException | IllegalAccessException ex ){
            throw new TestSupportException( String.format( "method \"%s\" can NOT be called properly", requestedMethodName ),  ex );
        }catch( final InvocationTargetException ex ){
            throw new TestSupportException( String.format( "method \"%s\" can NOT be called properly", requestedMethodName ),  ex.getCause() );
        }//try 
    }//method()
    
    
    
    //##########################################################################
    //###
    //###   other stuff
    //###
    
    private static void prettyPrintMap( final Map<Object,Map<Object,Object>> outerMap ){
        for( final Object outerKey : outerMap.keySet() ){
            final Map<Object,Object> innerMap = outerMap.get( outerKey );
            for( final Object innerKey : innerMap.keySet() ){
                final Object innerValue = innerMap.get( innerKey );
                System.out.printf( "%5s  =>%5s  ->%5s\n",  outerKey, innerKey, innerValue );
            }//for
        }//for
    }//method()
    
}//class
