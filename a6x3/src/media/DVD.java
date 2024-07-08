package media;

import java.util.Objects;

import org.junit.jupiter.api.DisplayNameGenerator.Simple;

import media.Disc.MediaType;

public class DVD extends Disc {

    //----- VARIABLES -----
    private VideoFormat format;


    // ----- ENUM -----
    public enum VideoFormat {
        PAL, NTSC;
    }
    
    //----- CONSTRUCTOR -----
    @Override
    public void Disc() {
        disc = DiscType.DVD;
    }

    
    
    public void Disc(String titel) {
        Disc();
        this.titel = titel;
    }
    
    
    public void Disc(String titel, MediaType media, VideoFormat format ) {
        //--- assert ---
        assert media.equals(MediaType.MOVIE) || media.equals(MediaType.VIDEO) : "Media Type for DVD hast to be MOVIE or VIDEO";
        Disc(titel);
        
        this.media = media;
        this.format = format;
    }  
    
    
  
    
    

    @Override
    public int hashCode() {
        return Objects.hash(titel, format, disc, media);
    }
    
    
    
    
    @Override
    public String toString() {
       return String.format("[<%s> : Titel: %s   Format: %s   Medientyp: %s   Disctyp: %s]", DVD.class.getSimpleName(), this.titel, this.format, this.media, this.disc);
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
        
        return (disc == other.disc) && (media == other.media) && (titel.equals(other.titel) && format.equals(other.format));
    }
}