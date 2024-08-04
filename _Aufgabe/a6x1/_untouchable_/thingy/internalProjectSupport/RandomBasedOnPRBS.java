package _untouchable_.thingy.internalProjectSupport;


public class RandomBasedOnPRBS {
    
    //65, 4, 3, 1, 0                                                            // coefficients of 65 bit (prime!) polynominal
    //\=> 65, 64, 62, 61, 0                                                     // coefficients of 65 bit (prime!) polynominal, da "nur" gespiegelt
    //\=> 1__0000_0000__0 .. 0__0001_1011 [2]                                   // 65 bit polynominal with LSB on the left and MSB on the right side
    //\=>    1000_0000__0 .. 0__0000_1101 [2]                                   //"64 bit version",   the MSB known as 1 is missing
    //\=> 1__0000_0000__0000_001b [16]                                          // 65 bit polynominal with LSB on the left and MSB on the right side
    //\=>    8000_0000__0000_000d [16]                                          //"64 bit version",   the MSB known as 1 is missing
    final long poly65withoutMSB = 0x8000_0000__0000_000dL;                      //"64 bit version",   the MSB known as 1 is missing
    
    private long signature;
    
    
    
    public RandomBasedOnPRBS( long seed ){
        if( 0 == seed )  throw new IllegalArgumentException( "non zero value required for seed" );
        signature = seed;
    }//constructor()
    
    
    
    public long nextLong(){
        final boolean signatureMSBset = (0b1 == (signature & 0b1));
        signature >>>= 1;
        if( signatureMSBset )  signature ^= poly65withoutMSB;
        return signature;
    }//method()
    
    public String identifyImplementation(){
        return "PRBS";
    }//method()
    
}//class
