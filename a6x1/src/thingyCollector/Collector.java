package thingyCollector;

import java.util.Collection;
import java.util.*;

import _untouchable_.thingy.Item;

public class Collector implements Collector_I {

    //----- VARIABLES -----
    final private List<Item> memoryThingyList = new LinkedList<Item>();
    final private Set<Item> uniqueThingysSet = new HashSet<Item>();



    //----- METHODS -----
    @Override
    public Collection<Item> process(Item item) {
        //puts all incoming items in the memory 
        this.memoryThingyList.add(item);



        // --- TEST PRINT ---
        // what do we get?

        boolean filthyTest = true;

        if (filthyTest) {
            System.out.printf("----- BEKOMMEN -----\n");
            for ( Item temp : this.memoryThingyList ) {//gets every single itzem in memory and prints int.
                System.out.printf("%7s  %7s  %7s  %5d  %14d\n\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
            }//for
        }//if



        // --- Method to put cars in Memory
        /*
         * Put Cards in a Memory. 
         * Check if thingys in memory are already in HashSet (use equals() method from HashSet).
         * If not: put in set, remove from memory. 
         * If yes: keep in Memory.
         * Deliver Set if Set has five thingys.
         * 
         */
        
        
        
        for ( Item tempItem : this.memoryThingyList) {
            if (!uniqueThingysSet.contains(tempItem)) {
                
                uniqueThingysSet.add(tempItem);
                if (filthyTest) schmuddelPrint(); // Dirty Print - what is in Memory - What is in List?
               
                memoryThingyList.remove(tempItem);
                if (filthyTest) schmuddelPrint(); // Dirty Print - what is in Memory - What is in List?

                if (uniqueThingysSet.size() == 5) { 

                    Set<Item> copyUniqueThingy = new HashSet<Item>(uniqueThingysSet);
                    if (filthyTest) schmuddelPrint(); // Dirty Print - what is in Memory - What is in List? 
                    this.uniqueThingysSet.clear();

                    return copyUniqueThingy;
                }

            } //if
        } //if
        return null;

    } // method process

    @Override
    public void reset() {
        this.memoryThingyList.clear();

    }


    // --- Method to print for Test ---
    private void schmuddelPrint() {
        //part that prints set
        System.out.printf("----- RETURN LIST -----\n");
        System.out.printf("Color       Size     Weight  Value     Hash \n");
        for ( Item temp : this.uniqueThingysSet )
            System.out.printf("%7s  %7s  %7s  %5d  %14d\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
        System.out.printf("\n\n\n");

        //part that prints what's in memory
        System.out.printf("----- IN MEMORY -----\n");
        System.out.printf("Color       Size     Weight  Value     Hash \n");
        for ( Item temp : this.memoryThingyList )
            System.out.printf("%7s  %7s  %7s  %5d  %14d\n", temp.getColor(), temp.getSize(), temp.getWeight(), temp.getValue(), temp.hashCode());
        System.out.printf("\n\n\n");
    } //method: schmuddelPrint



    //----- GETTER -----
    public int getMemorySize() {
        return this.memoryThingyList.size();
    }

    public int getThingySet() {
        return this.uniqueThingysSet.size();
    }
}
