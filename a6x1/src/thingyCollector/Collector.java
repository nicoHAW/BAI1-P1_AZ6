package thingyCollector;

import java.util.Collection;
import java.util.*;

import _untouchable_.thingy.Item;

public class Collector implements Collector_I {
    final private List<Item> memoryThingyList = new LinkedList<Item>();
    final private Set<Item> thingySet = new HashSet<Item>();




    @Override
    public Collection<Item> process(Item item) {

        this.memoryThingyList.add(item);


        /*      TEST PRINT: What do we get?
         *       for ( Item temp : this.memoryThingyList )
         *           System.out.printf("BEKOMMEN: %7s  %7s  %7s  %5d  %14d\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
         */      

        /*
         * Put Cards in a Memory. 
         * Check if thingys in memory are already in HashSet (use equals() method from HashSet).
         * If not: put in set, remove from memory. 
         * If yes: keep in Memory.
         * Deliver Set if Set has five thingys.
         * 
         */
        for ( Item tempItem : this.memoryThingyList) {
            if (!thingySet.contains(tempItem)) {
                thingySet.add(tempItem);
                memoryThingyList.remove(tempItem);

                if (thingySet.size() == 5) { 
                    
                    if (false) schmuddelPrint(); // Dirty Print - what is in Memory - What is in List? 
                    
                    return thingySet;
                }

            } //if
        } //if
        return null;

    } // method process

    @Override
    public void reset() {
        this.memoryThingyList.clear();

    }

    private void schmuddelPrint() {
        System.out.printf("----- RETURN LIST -----\n");
        System.out.printf("Color       Size     Weight  Value     Hash \n");
        for ( Item temp : this.thingySet )
            System.out.printf("%7s  %7s  %7s  %5d  %14d\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
        System.out.printf("\n\n\n");

        System.out.printf("----- IN MEMORY -----\n");
        System.out.printf("Color       Size     Weight  Value     Hash \n");
        for ( Item temp : this.memoryThingyList )
            System.out.printf("%7s  %7s  %7s  %5d  %14d\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
        System.out.printf("\n\n\n");
    }



}
