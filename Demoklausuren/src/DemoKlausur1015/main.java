package DemoKlausur1015;

public class main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        
        System.out.println("----- AUFGABE 3 -----" );
        Boolean a = (( !true ^ !!true ) || true ) ^ false;
        System.out.printf( "\nAufgabe a: %s", a );
        
        Boolean b = (( false != true ) == ( false ^ true )) || false;
        System.out.printf( "\nAufgabe b:%s", b );
        
        Byte c = (byte)( Short.MIN_VALUE < Character.MIN_VALUE ? 7%-3 : -6%4 );
        System.out.printf( "\nAufgabe c:%s", c );
        
        Character d = (char)( (short)(-2) + 'e' - (char)(1) );
        System.out.printf( "\nAufgabe d:%c", d );
        
        String e = "p" + 1;
        System.out.printf( "\nAufgabe e:%s", e );
        
        int f = Character.MAX_VALUE | 0xFF000000 | 0x00FF0000;
        System.out.printf( "\nAufgabe f:%d", f );
        
        int g = 2*3/*6*5*4*/-8;
        System.out.printf( "\nAufgabe g:%d", g );
        
        int h = (int)( 424242%42 >= 42 ? 1F*1D : (char)( 'e' - 'c' + Character.MIN_VALUE ) );
        System.out.printf( "\nAufgabe h:h: %d", h );
        
        double i = (double)( (17/11)*(7/5)*(3/2) ) + 0.23F;
        System.out.printf( "\nAufgabe i:%.2f", i );
        
        Void j = null;
        System.out.print("\\nAufgabe j:" + j );
        
        System.out.printf("\n\n----- AUFGABE 4 -----" );
        
    }

}
