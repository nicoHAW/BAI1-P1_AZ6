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

        iCheckMemory();

        //-- put in Set if already in Memory
        if( uniqueThingysSet.contains(item) ) {
            this.memoryThingyList.add(item);
        } else {
            this.uniqueThingysSet.add(item);
        }//ifelse




        // --- TEST PRINT ---
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

        if (uniqueThingysSet.size() == 5) { 
            iSchmuddelPrint(true); // Dirty Print - what is in Memory - What is in List? 
            return uniqueThingysSet;
        }//if

        return null;
    }//method process




    //--- RESET ---
    @Override
    public void reset() {
        this.memoryThingyList.clear();
        this.uniqueThingysSet.clear();

    }//method reset




    // --- TEST METHOD ---
    private void iSchmuddelPrint(boolean test) {
        if(test) {
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
        }//if
    }//method: schmuddelPrint



    private void iCheckMemory() {
        for ( Item tempItem : this.memoryThingyList) {
            if (!uniqueThingysSet.contains(tempItem)) {

                uniqueThingysSet.add(tempItem);

                iSchmuddelPrint(true); // Dirty Print - what is in Memory - What is in List?
                memoryThingyList.remove(tempItem);

                iSchmuddelPrint(true); // Dirty Print - what is in Memory - What is in List?
            }//if
        } //if
    }//for


//----- GETTER -----
public int getMemorySize() {
    return this.memoryThingyList.size();
}//getMemorySize

public int getThingySet() {
    return this.uniqueThingysSet.size();
}//getMemorySet

}//class
