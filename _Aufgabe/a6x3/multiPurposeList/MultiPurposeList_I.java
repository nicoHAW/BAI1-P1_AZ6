// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package multiPurposeList;


import stuffBeginnersDontHaveToUnderstand.Version;


/**
 * Multi Purpose List - see task
 *
 * @author  Michael Schaefers  ([UTF-8]:"Michael Schäfers");
 *          P1@Hamburg-UAS.eu 
 * @version {@value #encodedVersion} 
 */
public interface MultiPurposeList_I<T> {
    //
    //--VERSION:-----------------------#---vvvvvvvvv---vvvv-vv-vv--vv
    //  ========                       #___~version~___YYYY_MM_DD__dd_
    final static long encodedVersion = 2___00001_001___2022_06_10__01L;
    //---------------------------------#---^^^^^-^^^---^^^^-^^-^^--^^
    final static Version MultiPurposeListInterfaceVersion = new Version( encodedVersion );
    static String getDecodedVersion(){ return MultiPurposeListInterfaceVersion.getDecodedVersion(); }
    // Obiges (ab VERSION) dient nur der Versionierung
    
    
    
    
    
    // default constructor resp. constructor without any parameter is requested
  //public MultiPurposeList();
    
    
    
    
    
    /**
     * ...
     * 
     * @param info ...
     * @return ...
     */
    boolean contains( final T info );
    
    
    
    /**
     * ...
     * 
     * @param requestedPosition ...
     * @return ...
     */
    T getNo( final int requestedPosition );
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    T getFirst();
    */
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    T getLast();
    */
    
    
    /**
     * ...
     * 
     * @param requestedPosition ...
     * @return ...
     */
    T extractNo( final int requestedPosition );
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    T extractFirst();
    */
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    T extractLast();
    */
    
    
    /**
     * ...
     * 
     * @param requestedPosition ...
     * @param info ...
     * @return ...
     */
    T setNo( final int requestedPosition,  final T info );
    
    
    
    /**
     * ...
     * 
     * @param requestedPosition ...
     * @param info ...
     * @return ...
     */
    void putNo( final int requestedPosition,  final T info );
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    void putFirst( final T info );
    */
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    void putLast( final T info );
    */
    
    
    /**
     * ...
     * 
     * @param info ...
     * @return ...
     */
    boolean remove( final T info );
    
    
    /**
     * ...
     * 
     * @param requstedPosition ...
     */
    void removeNo( final int requstedPosition );
    
    
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    /**
     * ...
     * 
     * @param info ...
     * @return ...
     * /
    MultiPurposeList_I<T> subList( final T info );
    */
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    /**
     * ...
     * 
     * @param info1st ...
     * @param info2nd ...
     * @return ...
     * /
    MultiPurposeList_I<T> subList( final T info1st, final T info2nd );
    */
    
    
    
    /*###-----------------------------------------------------------------------
     *###
     *### NICHT Teil der Aufgabenstellung
     *###
    void reverse();
    */
    
    
    /**
     * ...
     * 
     * @return ...
     */
    int getSize();
   
    /**
     * ...
     * 
     * @return ...
     */
    boolean isEmpty();
    
    
    
    /**
     * ...
     */
    void clear();
    
}//interface
