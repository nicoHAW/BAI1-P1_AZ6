package media;

import java.util.Objects;

public class Disc {

    //----- VARIABLES -----
   private final String titel;
   private final Content media;
    
    
    
    
    //----- CONSTRUCTOR -----
    public Disc(String titel, Content media) {
        this.titel = titel;
        this.media = media;
    }
    
    
    
    // ----- METHODS -----
    public String getTitel(){
    return this.titel;    
    }
    
    
    
    public Content getMediaType() {
        return this.media;
    };

    
}//class
