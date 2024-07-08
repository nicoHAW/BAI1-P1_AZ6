package media;

import java.util.Objects;

import org.junit.jupiter.api.DisplayNameGenerator.Simple;


public class CD extends Disc {

    //----- VARIABLES -----
    private String interpret;


    //----- CONSTRUCTOR -----

    public CD(String titel, Content media, String interpret) {
        //assert
        assert media == Content.AUDIO : "CD needs Media Type Audio";


        this.media = media;
        this.titel = titel;
        this.interpret = interpret;
    }



    public void CD(String titel, Content media) {
        //assert
        assert media == Content.AUDIO : "CD needs Media Type Audio";


        this.media = media;
        this.titel = titel;
    }



    public String getInterpret() {
        return this.interpret;
    };



    @Override
    public int hashCode() {
        return Objects.hash(titel, interpret, media);
    }




    @Override
    public String toString() {
        return String.format("[<%s> : Titel: %s   Interpret: %s   Medientyp: %s]", DVD.class.getSimpleName(), this.titel, this.interpret, this.media);
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

        return (media == other.media) && (titel.equals(other.titel) && interpret.equals(other.interpret));
    }
}