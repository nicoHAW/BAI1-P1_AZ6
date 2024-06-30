package listAnalyzer;


import java.util.List;


/**
 * Die grundsätzliche Aufgabe eines ListAnalyzers ist es
 * für eine (als Konstruktor-Parameter) gegebene Liste, die Mehrfach-Einträge enthalten kann,
 * für ihre jeweiligen (Listen-)Elemente
 * die Anzahl ihres jeweiligen Vorkommens in der Liste zu bestimmen
 * Darüber hinaus sollen die Anzahl unterschiedlicher Elemente
 * sowie eine Menge, die alle unterschiedliche Elements enthält, bestimmt werden
 * Diese Informationen/"Ergebnisse" sollen in geeigneter Form in einem FrequencyReporter-Objekt
 * zusammengefasst werden.
 * 
 * @author  Michael Schäfers
 *
 * @param <T>  (Daten-)Typ der (Listen-)Elemente
 */
public interface ListAnalyzer_I<T> {
    
    /*
     * constructor()
     * =============
    ListAnalyzer( final List<T> list )
    */
    
    
    
    /**
     * Die Methode bestimmt für eine (als Konstruktor-Parameter) gegebene Liste:<br />
     * &bull; für die jeweiligen (Listen-)Elements die Anzahl des Vorkommenens in der Liste<br />
     * &bull; die Anzahl unterschiedlicher (Listen-)Elemente<br />
     * &bull; eine Menge aller unterschiedlichen (Listen-)Elemente<br />
     * In geeigneter Form sollen die eingeforderten Informationen/"Ergebnisse"
     * in einem FrequencyReporter-Objekt zusammengefasst werden.
     * 
     * @return  ein FrequencyReporter-Objekt in dem die eingeforderten nformationen/"Ergebnisse" zusammengefasst sind.
     */
    FrequencyReporter_I<T> computeFrequencyReporter();
    
    /**
     * Diese Methode liefert ide Original-Liste, die als Konstruktor-Parameter übergeben wurde.
     * 
     * @return  Original-Liste
     */
    List<T> getList();
    
}//interface
