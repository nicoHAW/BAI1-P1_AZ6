package collectionConverter;


import java.util.List;
import java.util.Map;


public interface Converter_I {
    
    /**
     * flattens map
     * 
     * @param  exteriorMap  nested map that contains an interior map as datavalue
     * @return  flattened nested map as list
     */
    List<Object> toList( final Map<Object,Map<Object,Object>> exteriorMap );
    
    /**
     * createsListout of map
     * 
     * @param list  list containing flattened nested map
     * @return  nested map
     */
    Map<Object,Map<Object,Object>> toNestedMap( final List<Object> list );
    
}//interface
