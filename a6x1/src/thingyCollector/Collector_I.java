package thingyCollector;


import java.util.*;
import _untouchable_.thingy.*;


/**
 * Das Interface Collector_I
 * <ul>
 *     <li>beschreibt einen Collector, der Datensaetze vom Typ Item aufnehmen kann und</li>
 *     <li>definiert die zu unterstuetzenden Operationen.
 *     </li>
 * </ul>
 * Die von Ihnen zu implementierenden Klassen muessen einen oeffentlichen parameterlosen
 * Konstruktor aufweisen.
 *<br />
 *<br />
 * Eine genaue Auflistung der Anforderungen an die zu implementierende Klasse
 * findet sich auf dem Aufgabenzettel.<br />
 *<br />
 *
 * @author   Michael Schaefers ; P1@Hamburg-UAS.eu 
 * @version  2021_06_07__001
 */
public interface Collector_I {
    
    /**
     * requestedNumberOfDifferentItems definiert die Anzahl der unterschiedlichen Items,
     * die fuer eine Ergebnis-Collection vorliegen muessen. (Siehe process()-Operation).
     */
    final int requestedNumberOfDifferentItems = 5;
    
    
    
    /**
     * Diese Operation verarbeitet ein Item.<br />
     * Der von Ihnen zu implementierende Collector reagiert auf das jeweils (neu) erscheinende
     * Item. Das jeweils neu erscheinende Item wird konkret als Parameter an die Operation process
     * uebergeben und muss geeignet intern verabeitet werden.<br />
     * Immer sobald fuenf ungleiche(!) Items vorliegen (siehe requestedNumberOfDifferentItems),
     * sollen diese als Rueckgabewert der Operation (in Form einer geeigneten Collection) abgeliefert
     * und aus einem moeglichen internen "Gedaechtnis" entfernt werden,
     * <br />
     * andernfalls soll null zurueckgegeben werden.
     * <br />
     *<br />
     * Bemerkungen:
     * <ul>
     *     <li>Ein Item, das bereits Teil einer abgelieferten (Ergebnis-)Collection war,
     *         darf nicht fuer die Bildung einer anderen (Ergebnis-)Collection verwendet werden.
     *         Diese Aussage betrifft die Identitaet - "Gleiche"   bzw. moegliche Doppelte
     *         sind unbetroffen.
     *         <br />
     *         (<i>Moegliche interne Collections sind hiervon ausgenommen.</i>)
     *     </li>
     *     <li>Dasselbe Item erscheint nur einmal. Gleiche Items koennen mehrfach erscheinen.
     *     </li>
     * </ul>
     *<br />
     *
     *
     * @param item bestimmt das (neue) Item, das zu verarbeiten ist.
     * @return  der jeweils geforderte Collection unmittelbar nachdem sie gebildet werden kann<br />
     *          und sonst null.
     */
    Collection<Item> process( Item item );
    
    /**
     * Diese Operation setzt einen moeglichen (internen) Zustand auf die Starteinstellung
     * bzw. den Startzustand zurueck.<br />
     * (<i>reset macht halt einen reset. Der Name sollte selbsterklaerend sein.</i>)
     */
    void reset();
    
}//interface
