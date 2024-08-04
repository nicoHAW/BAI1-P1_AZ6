// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package testOfListAnalyzer;


import static org.junit.jupiter.api.Assertions.*;
import static cards.Card.Constant.*;

import cards.Card;
import listAnalyzer.FrequencyReporter_I;
import listAnalyzer.ListAnalyzer_I;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    final static private long encodedVersion = 2___00001_003___2023_05_11__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    /**
     * The method {@link #getDecodedVersion()} delivers the code version as reground/readable String.
     * @return version as decoded/readable String.
     */
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung.
    
    
    
    
    
    final static private String requestedRefTypeQualified = "listAnalyzer.ListAnalyzer";
    
    
    
    
    
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
    
    
    
    
    
    @SuppressWarnings("unchecked")
    @Test
    public void testSimple01(){
        // prepare test parameter
        final Card[] cardArray = { CJ, DJ, CK, DT, S2, HQ, SA, C4, S2, SQ };
        final List<Card> cardList = Arrays.asList( cardArray );
        //
        // do actual test
        final ListAnalyzer_I<Card> listAnalyzer =
            (ListAnalyzer_I<Card>)( generateRequestedObject(
                requestedRefTypeQualified,
                new Class<?>[]{ List.class },
                new Object[]{ cardList }
            ));
        final FrequencyReporter_I<Card> computedResult = (FrequencyReporter_I<Card>)( callFunction( listAnalyzer, "computeFrequencyReporter", null, null ));
        //
        //check test result
        assertEquals( 9, computedResult.getAmountOfUniqueItems() );
        for( final Card key : computedResult.knownElements() ){
            if( S2==key ){
                assertEquals( 2, computedResult.getfrequency( key ) );
            }else{
                assertEquals( 1, computedResult.getfrequency( key ) );
            }//if
        }//for
    }//method()
    
    
    @Test
    public void testSimple02(){
        // prepare test parameter
        final String text = "Hallo";
        final List<Character> characterList = new ArrayList<Character>();
        for( final char c : text.toCharArray() )  characterList.add( c );
        //
        //
        // do actual test
        @SuppressWarnings("unchecked")
        final ListAnalyzer_I<Character> listAnalyzer =
            (ListAnalyzer_I<Character>)( generateRequestedObject(
                requestedRefTypeQualified,
                new Class<?>[]{ List.class },
                new Object[]{ characterList }
            ));
        @SuppressWarnings("unchecked")
        final FrequencyReporter_I<Character> computedResult = (FrequencyReporter_I<Character>)( callFunction( listAnalyzer, "computeFrequencyReporter", null, null ));
        //
        //check test result
        assertEquals( 4, computedResult.getAmountOfUniqueItems() );
        for( final Character key : computedResult.knownElements() ){
            switch( key ){
                case 'l':
                    assertEquals( 2, computedResult.getfrequency( key ) );
                    break;
                default:
                    assertEquals( 1, computedResult.getfrequency( key ) );
            }//switch
        }//for
    }//method()
    
    
    @Test
    public void testSimple03(){
        // prepare test parameter
        final String text = "abcdefcghijcklmnocpppqqqcrstuvwcxyzxkx";
        final List<Character> characterList = new ArrayList<Character>();
        for( final char c : text.toCharArray() )  characterList.add( c );
        //
        //
        // do actual test
        @SuppressWarnings("unchecked")
        final ListAnalyzer_I<Character> listAnalyzer =
                (ListAnalyzer_I<Character>)( generateRequestedObject(
                requestedRefTypeQualified,
                new Class<?>[]{ List.class },
                new Object[]{ characterList }
            ));
        @SuppressWarnings("unchecked")
        final FrequencyReporter_I<Character> computedResult = (FrequencyReporter_I<Character>)( callFunction( listAnalyzer, "computeFrequencyReporter", null, null ));
        //
        //check test result
        assertEquals( 26, computedResult.getAmountOfUniqueItems() );
        for( final Character currentKey : computedResult.knownElements() ){
            System.out.printf( "%3d *  %s\n",  computedResult.getfrequency( currentKey ), currentKey );
        }//for
        for( final Character key : computedResult.knownElements() ){
            final int count = computedResult.getfrequency( key );
            /*
            if( 'c'==key ){
                assertEquals( 6, count, String.format( "false count for %c",  key) );
            }else if( 'p'==key || 'q'==key || 'x'==key ){
                assertEquals( 3, count, computedResult.getfrequency( key ), String.format( "false count for %c",  key) );
            }else if( 'k'==key ){
                assertEquals( 2, count, computedResult.getfrequency( key ), String.format( "false count for %c",  key) );
            }else {
                assertEquals( 1, count, computedResult.getfrequency( key ), String.format( "false count for %c",  key) );
            }//if
            */
            switch( key ){
                case 'c':
                    assertEquals( 6, count, String.format( "false count for %c",  key) );
                    break;
                case 'p','q','x':
                    assertEquals( 3, count, String.format( "false count for %c",  key) );
                    break;
                case 'k':
                    assertEquals( 2, count, String.format( "false count for %c",  key) );
                    break;
                default:
                    assertEquals( 1, count, String.format( "false count for %c",  key) );
            }//switch
        }//for
    }//method()
    
    
    
    @Test
    public void test01(){
        // prepare test parameter
        final String text = "";
        final List<Character> characterList = new ArrayList<Character>();
        for( final char c : text.toCharArray() )  characterList.add( c );
        //
        //
        // do actual test
        @SuppressWarnings("unchecked")
        final ListAnalyzer_I<Character> listAnalyzer =
            (ListAnalyzer_I<Character>)( generateRequestedObject(
                requestedRefTypeQualified,
                new Class<?>[]{ List.class },
                new Object[]{ characterList }
            ));
        @SuppressWarnings("unchecked")
        final FrequencyReporter_I<Character> computedResult = (FrequencyReporter_I<Character>)( callFunction( listAnalyzer, "computeFrequencyReporter", null, null ));
        //
        //check test result
        assertEquals( 0, computedResult.getAmountOfUniqueItems() );
    }//method()
    
    
    @Test
    public void test02(){
        boolean expectedExceptionDetected = false;
        try{
            // do actual test
            @SuppressWarnings({ "unchecked", "unused" })
            final ListAnalyzer_I<Character> listAnalyzer =
                (ListAnalyzer_I<Character>)( generateRequestedObject(
                    requestedRefTypeQualified,
                    new Class<?>[]{ List.class },
                    new Object[]{ null }
                ));
        }catch( final IllegalArgumentException | AssertionError ex ){
            expectedExceptionDetected = true;
        }catch( final TestSupportException ex ){
            // -> TS.examineInternallyRaisedTestSupportExceptionForIllegalArgumentCauseAndReact()
            final Throwable causingThrowable = ex.getCause();
            if( null != causingThrowable ){
                if( causingThrowable instanceof InvocationTargetException ){
                    final Throwable actualCausingThrowable = ((InvocationTargetException)causingThrowable ).getCause();
                    if(     actualCausingThrowable instanceof AssertionError
                        ||  actualCausingThrowable instanceof IllegalArgumentException
                    ){
                        expectedExceptionDetected = true;
                    }//if
                }//if
            }//if
        }finally{
            //check test result
            if( ! expectedExceptionDetected )  fail();
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
    
}//class
