package media;

import java.util.Objects;

abstract class Disc {

    //----- VARIABLES -----
   String titel;
   DiscType disc;
   MediaType media;
    
    
    
    
    //----- CONSTRUCTOR -----
    public abstract void Disc();
    
    
    
    
    //----- ENUM -----
    enum DiscType {
        CD, DVD;
    }
    enum MediaType {
        AUDIO, VIDEO, MOVIE;
    }
 
 
    
    
    // ----- METHODS -----
    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
    
    
    @Override
    public abstract String toString();
    
    
    public String getTitel(){
    return this.titel;    
    }
    
    public DiscType getDiscType() {
        return this.disc;
    }
    
    public MediaType getMediaType() {
        return this.media;
    };

    
}//class
