package nicoTestFrame;


import static media.Content.AUDIO;
import static media.Content.MOVIE;
import static media.Content.VIDEO;
import static media.Format.NTSC;
import static media.Format.PAL;
//
//
import media.CD;
import media.Disc;
import media.DVD;

import multiPurposeList.*;




public class myTest {

    public myTest() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        MultiPurposeList<Disc> testListe = new MultiPurposeList<Disc>();

        testListe.printElemFirstToLast();



        System.out.printf("----- TEST METHODS - EMPTY -----");
        System.out.printf("----- toString() -----\n");
        System.out.printf("Liste = %s\n", testListe.toString());


        System.out.printf("\n----- isEmpty() -----\n");
        System.out.printf("isEmpty() = %s\n", testListe.isEmpty());

        System.out.printf("\n----- getSize() -----\n");
        System.out.printf("Size = %s\n", testListe.getSize());


        CD heino = new CD( "Sing mit Heino", AUDIO, "Heino" );
        CD heinoZwei = new CD( "Sing mit Heino", AUDIO, "Heino" );
        CD heinoDrei = new CD( "Sing mit Heino", AUDIO, "Heino" );
        CD heinoVier = new CD( "Sing mit Heino", AUDIO, "Heino" );
        CD ledZeppelin = new CD( "IV", AUDIO, "Led Zeppelin" );
        CD theWho = new CD( "Quadrophenia", AUDIO, "Who" );

        DVD bladeRunner = new DVD( "Blade Runner", MOVIE, PAL );
        DVD cadillac = new DVD( "Cadillac Man", MOVIE, PAL );
        DVD sinCity = new DVD( "Sin City - Uncut", MOVIE, NTSC );
        DVD Silver = new DVD( "Silver Streak", MOVIE, NTSC );
        DVD davidBowiedvd = new DVD( "David Bowie: Best of Bowie", VIDEO, PAL );
        DVD U2dvd = new DVD( "U2: Live in Boston", VIDEO, NTSC );
        DVD alienNTSC = new DVD( "alien", MOVIE, NTSC );
        DVD alienPAL = new DVD( "alien", MOVIE, PAL);
        DVD nicoTennis = new DVD( "Nico Tennis", VIDEO, NTSC );
        DVD nicoTennisZwei = new DVD( "Nico Tennis", AUDIO, NTSC );
        DVD predator = new DVD( "Predator", MOVIE, PAL);
        DVD scream = new DVD( "Scream", MOVIE, NTSC );
        DVD haunted = new DVD( "Haunted House", MOVIE, PAL);

        System.out.printf("\n----- contains() -----\n");
        System.out.printf("contains(heino) = %s\n", testListe.contains(heino));




        System.out.printf("----- TEST METHODS - with Objects -----");

        testListe.putNo(0, heino);
        testListe.putNo(0, heinoZwei);
        testListe.putNo(0, heinoDrei);


        System.out.printf("----- toString() -----\n");
        //System.out.printf("Liste = %s\n", testListe.toString());


        System.out.printf("\n----- isEmpty() -----\n");
        System.out.printf("isEmpty() = %s\n", testListe.isEmpty());

        System.out.printf("\n----- getSize() -----\n");
        System.out.printf("Size = %s\n", testListe.getSize());

        System.out.printf("\n----- contains() -----\n");
        System.out.printf("contains(heinoVier) = %s\n", testListe.contains(heinoVier));


        
        System.out.printf("\n----- clear() -----\n");
        //testListe.clear();

        System.out.printf("\n----- after clear - isEmpty() -----\n");
        System.out.printf("isEmpty() = %s\n", testListe.isEmpty());

        System.out.printf("\n----- after clear - getSize() -----\n");
        System.out.printf("Size = %s\n", testListe.getSize());


        System.out.printf("\n----- getPos() -----\n");
        System.out.printf("getNo(0) = %s\n", testListe.getNo(0));
        System.out.printf("getNo(1) = %s\n", testListe.getNo(1));
        System.out.printf("getNo(2) = %s\n", testListe.getNo(2));

        
        System.out.printf("\n----- after clear - getSize() -----\n");
        System.out.printf("Size = %s\n", testListe.getSize());
        
        
        System.out.printf("\n----- extractNo() -----\n");
        System.out.printf("extractNo(1) = %s\n", testListe.extractNo(1));

        
        System.out.printf("\n----- NewSize - getSize() -----\n");
        System.out.printf("Size = %s\n", testListe.getSize());
        
        
        System.out.printf("\n----- getAll() -----\n");
        testListe.printElemFirstToLast();
        
        System.out.printf("\n----- NEW OBJECTS --- puNo() -----\n");
        testListe.putNo(0, U2dvd);
        testListe.printElemFirstToLast();
        System.out.printf("\n----------\n");
        
        testListe.putNo(1, davidBowiedvd );
        testListe.printElemFirstToLast();
        
        System.out.printf("\n----------\n");
        
        testListe.putNo(3, sinCity);
        testListe.printElemFirstToLast();
        
        System.out.printf("\n----------\n");
        testListe.putNo(5, ledZeppelin );
        testListe.printElemFirstToLast();

        System.out.printf("\n----- REPLACE --- setNo() -----\n");
        testListe.setNo(4, alienPAL);
        testListe.printElemFirstToLast();
        System.out.printf("\n----------\n");
        
        System.out.printf("\n----- REMOVE --- removeNo() -----\n");
        testListe.removeNo(5);
        testListe.printElemFirstToLast();
        System.out.printf("\n----------\n");
        
        System.out.printf("\n----- NEW OBJECTS --- puNo() -----\n");
        testListe.putNo(0, ledZeppelin);
        testListe.putNo(0, haunted );
        testListe.putNo(0, scream );
        testListe.putNo(0, predator );
        testListe.putNo(0, nicoTennis );
        testListe.printElemFirstToLast();
        testListe.getHead();
        testListe.getTail();
        
        System.out.printf("Liste enthält: %s? Ergebis: %b \n\n", nicoTennisZwei, testListe.contains(nicoTennisZwei));
        System.out.printf("Liste enthält: %s? Ergebis: %b \n\n", nicoTennis, testListe.contains(nicoTennis));
        System.out.printf("Liste enthält: %s? Ergebis: %b \n\n", alienNTSC, testListe.contains(alienNTSC));
        System.out.printf("Liste enthält: %s? Ergebis: %b \n\n", alienPAL, testListe.contains(alienPAL));
        
        //System.out.printf("\nListe = %s\n", testListe.toString());
        
        
        System.out.printf("\n\n\n----- REMOVE OBJECT remove() -----\n");
        testListe.printElemFirstToLast();
   
     
        
        testListe.remove(nicoTennisZwei);
        testListe.printElemFirstToLast();
        System.out.printf("\n----------\n");
        
        
        System.out.printf("\n\n\n\n\n\n");
        
        

    }

}
