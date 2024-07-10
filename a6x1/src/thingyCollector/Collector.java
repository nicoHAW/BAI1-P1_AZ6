package thingyCollector;

import java.util.Collection;
import java.util.*;

import _untouchable_.thingy.Item;

public class Collector implements Collector_I {

    //----- VARIABLES -----
    final private List<Item> memoryThingyList;     //stores double Items
    final private Set<Item> uniqueThingysSet;         //stores unique Items

    //CONSTRUCTOR
    public Collector() {
        memoryThingyList = new LinkedList<Item>();     //stores double Items
        uniqueThingysSet = new HashSet<Item>();         //stores unique Items
    }


    //----- METHODS -----
    @Override
    public Collection<Item> process(Item item) {
        //--Asserts
        assert item != null : "Item can't be null";
        
        //--TestPrint 
        boolean test = true; //activate of deactive all Testprints
        iPrintItem(test, item);   //printsWhat you got -> Check how List Sizes change
        iPrintAll(test);            //prints Status of Lists (Size and content)


        //--CheckMemory
        //If memory is not empty process Items in Memory first
        if (!this.memoryThingyList.isEmpty()) {
            iCheckMemory();
        }//if


        //--ChekDouble
        //if same item in uniqueSet put in memory
        if( uniqueThingysSet.contains(item) ) {
            this.memoryThingyList.add(item);
        } else {
            this.uniqueThingysSet.add(item);
        }//ifelse
        iPrintAll(test);



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
            iPrintAll(test);
            
            return uniqueThingysSet;
        }//if

        return null;
    }//method process




    private void iCheckMemory() {
        Iterator<Item> listIterator = this.memoryThingyList.iterator();
        while (listIterator.hasNext()) {

            Item tempItem = listIterator.next();

            if (!uniqueThingysSet.contains(tempItem)) {
                uniqueThingysSet.add(tempItem);
                memoryThingyList.remove(tempItem); 
            }//if
        }//while
    }//method: iCheckMemory






    //--- RESET ---
    @Override
    public void reset() {
        this.memoryThingyList.clear();
        this.uniqueThingysSet.clear();

    }//method reset





    private void iPrintItem(boolean test, Item item) {
        //part that prints set
        System.out.printf("----- WHAT YOU GOT -----\n");
        System.out.printf("%7s  %7s  %7s  %5d  %14d\n\n", item.getColor(), item.getSize(), item.getWeight(), item.getValue(), item.hashCode());
    }//iPrintItem



    private void iPrintMemory(boolean test) {
        //part that prints set
        System.out.printf("----- STATUS LISTS -----\n");
        System.out.printf("MEMORY-SIZE: %d\n\n", this.memoryThingyList.size());
        System.out.printf("----- Memory Contains -----\n");
        System.out.printf("%s\n\n", this.memoryThingyList.toString());
    }//iPrintItem



    private void iPrintUnique(boolean test) {
        //part that prints set
        System.out.printf("----- STATUS LISTS -----\n");
        System.out.printf("THINGY-SET-SIZE: %d\n\n", this.uniqueThingysSet.size());
        System.out.printf("----- Thingy-Set-Contains -----\n");
        System.out.printf("%s\n\n", this.uniqueThingysSet.toString());
    }//iPrintItem

    private void iPrintAll(boolean test) {
        iPrintMemory(test);
        iPrintUnique(test);
    }

    public void iPrintMyTest(boolean test) {
        if (test) {
            System.out.printf("\n\n\n\n\n\n----- MEIN TEST AB HIER -----\n\n\n");
        }
    }



    //----- GETTER -----
    public int getMemorySize() {
        return this.memoryThingyList.size();
    }//getMemorySize

    public int getThingySize() {
        return this.uniqueThingysSet.size();
    }//getMemorySet




}//class
