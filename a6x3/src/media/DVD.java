package media;

import java.util.Objects;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;



public class DVD extends Disc {

    //----- VARIABLES -----
    private final Format format;

    
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
       return String.format("[<%s> : Titel: %s   Medientyp: %s   Format: %s]", DVD.class.getSimpleName(), this.titel, this.media, this.format);
    }



    @Override
    public boolean equals(Object obj) {
        //same object?
        if (this == obj)
            return true;
        
        //object null?
        if (obj == null)
            return false;
        
        
        //same class?
        if (getClass() != obj.getClass())
            return false;
        
        //convert and check if same
        DVD other = (DVD) obj;
        return (media == other.media) && (titel.equals(other.titel) && format.equals(other.format));
    }
}