package nicoTestFrame;

import thingyCollector.Collector;
import thingyCollector.Collector_I;
import _untouchable_.thingy.*;
import java.util.*;

public class nicoTestFrame {

    public static void main(String[] args) {


        Collector testCollector = new Collector();

        Item itemEins = new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L );
        Item itemZwei = new Item( Color.BLUE,  Size.MEDIUM, Weight.MEDIUM, 2L );
        Item itemDrei =  new Item( Color.BROWN, Size.SMALL,  Weight.LIGHT,  3L );
        Item itemVier =  new Item( Color.CYAN,  Size.SMALL,  Weight.HEAVY,  4L );
        Item itemFunf = new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  5L );
        Item itemSechs = new Item( Color.GOLD,  Size.MEDIUM, Weight.LIGHT,  2L );


        testCollector.process(itemEins);
        testCollector.process(itemZwei);
        testCollector.process(itemEins);
        testCollector.process(itemDrei);
        testCollector.process(itemVier);
        testCollector.process(itemFunf);
        testCollector.process(itemSechs);
        
        testCollector.reset();
        
        System.out.printf("Memory Size: %d, ThingySize: %d", testCollector.getMemorySize(), testCollector.getThingySize() );
        




    }

}
