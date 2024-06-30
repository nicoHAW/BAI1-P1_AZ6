package listAnalyzer;

import java.util.Set;

/**
 * Ein FrequencyReporter wird genutzt um "Ergebnisse von Berechnungen" 
 * (wie sie z.B. der ListAnalyzer ausführt) in einem Objekt zusammenzufassen.
 * Diese Ergebnisse beziehen sich auf Elemente.
 * Der FrequencyReporter fasst die folgenden Ergebnisse zusammen:<br />
 * &bull; für die einzelnen Elemente, die Anzahl ihres jeweiligen Vorkommens
 * &bull; eine Menge der unterschiedlichen Elemente
 * &bull; die Anzahl unterschiedlicher Elemente
 * 
 * @author Michael Schäfers
 *
 * @param <T>  (Daten-)Typ der Elemente
 */
public interface FrequencyReporter_I<T> {
    
    /**
     * Liefert das Berechnungsergebnis:
     * Die Anzahl des Vorkommens des jeweiligen Elements.
     *  
     * @return
     */
    int getfrequency( final T element );
    
    
    /**
     * Liefert das Berechnungsergebnis:
     * Die Menge von unterschiedlichen Elementen.
     * 
     * @return Menge unterschiedlicher Elemente.
     */
    Set<T> knownElements();
    
    
    /**
     * Liefert das Berechnungsergebnis:
     * Die Anzahl des Vorkommens des jeweiligen Elements.
     *  
     * @return
     */
    int getAmountOfUniqueItems();
    
}//interface
