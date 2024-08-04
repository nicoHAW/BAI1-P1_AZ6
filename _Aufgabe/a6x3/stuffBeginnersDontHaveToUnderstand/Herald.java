// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
// "Home"-VCS:  git@git.HAW-Hamburg.de:shf/Px/LabExercise/ZZZ_SupportStuff[.git]
package stuffBeginnersDontHaveToUnderstand;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * This is an INTERNAL support class.<br />
 * <br />
 * 
 * The class {@link Herald} implements a Herald (@see <a href="https://en.wikipedia.org/wiki/Herald">Herald</a>).
 * The Herald is sent by you (the programmer) to convey messages or proclamations to the user ;-)
 * 
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          Px@Hamburg-UAS.eu
 * @version {@value #encodedVersion}
 */
public class Herald implements Serializable {
    //
    //--VERSION:-------------------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                               #___~version~___YYYY_MM_DD__dd_
    final static private long encodedVersion = 2___00001_005___2024_06_15__01L;
    //-----------------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static private Version version = new Version( encodedVersion );
    static public String getDecodedVersion(){ return version.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    private static final long serialVersionUID = version.getEncodedVersion();
    
    
    
    
    
    public static void proclaimError( final String message ){
        System.out.flush();
        System.err.flush();
        System.err.print( message );
        System.err.flush();
    }//method()
    //
    public static void proclaimError( final StringBuilder message ){
        proclaimError( message.toString() );
    }//method()
    //
    public static void proclaimError( final StringBuffer message ){
        proclaimError( message.toString() );
    }//method()
    
    
    
    public static void proclaimMessage( final String message ){
        System.err.flush();
        System.out.flush();
        System.out.print( message );
        System.out.flush();
    }//method()
    //
    public static void proclaimMessage( final StringBuilder message ){
        proclaimMessage( message.toString() );
    }//method()
    //
    public static void proclaimMessage( final StringBuffer message ){
        proclaimMessage( message.toString() );
    }//method()
    
    
    
    public static void proclaimComingDeathOfExecutingThread(){
        proclaimExecutingThreadInformation( "is going down" );
    }//method()
    //
    public static void proclaimExecutingThreadInformation( final String information ){
        final Thread executingThread = Thread.currentThread();                  // thread that executes this very code
        final StringBuilder sb = new StringBuilder();                           // (thread) local -> hence StringBuffer is NOT required
        sb.append(
            String.format(
                "%d:%s %s\n",
                executingThread.threadId(),
                executingThread.getName(),
                information
            )
        );
        proclaimMessage( sb );
    }//method()
    
    
    
    public static void proclaimTestStart( final String testName ){
        final StringBuffer sb = new StringBuffer( "" );
        sb.append( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        sb.append( String.format( ">>> Start of %s  @ %s ~~~ %s\n",  testName, LocalDate.now(), LocalTime.now() ));
        sb.append( "\n" );
        proclaimMessage( sb.toString() );
    }//method()
    //
    public static void proclaimTestEnd( final String testName ){
        final StringBuffer sb = new StringBuffer( "" );
        sb.append( "\n" );
        sb.append( String.format( "<<<<< End of %s  @ %s ~~~ %s\n",  testName, LocalDate.now(), LocalTime.now() ));
        sb.append( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        proclaimMessage( sb.toString() );
    }//method()
    
}//class
