package media;

import java.util.Objects;

import org.junit.jupiter.api.DisplayNameGenerator.Simple;

import media.Disc.MediaType;

public class CD extends Disc {

    //----- VARIABLES -----
    private String interpret;


    //----- CONSTRUCTOR -----
    @Override
    public void Disc() {
        disc = DiscType.CD;
        media = MediaType.AUDIO;
    }

    
    
    public void Disc(String titel) {
        Disc();

        this.titel = titel;
    }
    
    
    
    public void Disc(String titel, String interpret) {
        Disc(titel);
        this.interpret = interpret;
    }
    
    
    
    
    public void Disc(String titel, MediaType media, String interpret) {
        //assert
        assert media == MediaType.AUDIO : "CD needs Media Type Audio";

        disc = DiscType.CD;

        this.media = media;
        this.titel = titel;
        this.interpret = interpret;
    }
    
    

    public void Disc(String titel, MediaType media) {
        //assert
        assert media == MediaType.AUDIO : "CD needs Media Type Audio";

        disc = DiscType.CD;

        this.media = media;
        this.titel = titel;
    }


    
    public String getInterpret() {
        return this.interpret;
    };
    
    

    @Override
    public int hashCode() {
        return Objects.hash(titel, interpret, disc, media);
    }
    
    
    
    
    @Override
    public String toString() {
       return String.format("[<%s> : Titel: %s   Interpret: %s   Medientyp: %s   Disctyp: %s]", DVD.class.getSimpleName(), this.titel, this.interpret, this.media, this.disc);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        
        if (obj == null)
            return false;
        
        
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
        
        return (disc == other.disc) && (media == other.media) && (titel.equals(other.titel) && interpret.equals(other.interpret));
    }
}