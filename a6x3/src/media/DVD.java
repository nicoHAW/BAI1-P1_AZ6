package media;

import java.util.Objects;

import org.junit.jupiter.api.DisplayNameGenerator.Simple;

public class DVD extends Disc {

    //----- VARIABLES -----
    private Format format;

    
    //----- CONSTRUCTOR -----

    public DVD(String titel, Content media, Format format ) {
        super(titel, media);
        this.format = format;
    }  


    @Override
    public int hashCode() {
        return Objects.hash(titel, format, media);
    }
    
    
    
    
    @Override
    public String toString() {
       return String.format("[<%s> : Titel: %s   Format: %s   Medientyp: %s]", DVD.class.getSimpleName(), this.titel, this.format, this.media);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        
        if (obj == null)
            return false;
        
        
        if (getClass() != obj.getClass())
            return false;
        DVD other = (DVD) obj;
        
        return (media == other.media) && (titel.equals(other.titel) && format.equals(other.format));
    }
}