package com;


public class Test {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	// runState is stored in the high-order bits
	private static final int RUNNING    = -1 << COUNT_BITS;
	private static final int SHUTDOWN   =  0 << COUNT_BITS;
	private static final int STOP       =  1 << COUNT_BITS;
	private static final int TIDYING    =  2 << COUNT_BITS;
	private static final int TERMINATED =  3 << COUNT_BITS;
	static int a ;

	public Test(){
		System.out.println("333333333333");
	}


	public static void main(String[] args) throws Exception{
		System.out.println((RUNNING | 0) & CAPACITY);
//		System.out.println(Class.forName("com.JsonHelper",true,Thread.currentThread().getClass().getClassLoader()));
	}

	public static void t(int a ){
		String s = "abcdefghijklmnopqrstuvwsyz";
		StringBuffer sb = new StringBuffer("");
		while(a > 0){
			int i = a % 26;
//			if(){}
			sb.append(s.charAt(i));
			i = a / 26;
		}
	}

	public static void t16(int a){

	}
	
	 public static String toString(long i) {
	        if (i == Long.MIN_VALUE)
	            return "-9223372036854775808";
	        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
	        char[] buf = new char[size];
	        getChars(i, size, buf);
	        return new String(buf);
	    }
	 
	 static int stringSize(long x) {
	        long p = 10;
	        for (int i=1; i<19; i++) {
	            if (x < p)
	                return i;
	            p = 10*p;
	        }
	        return 19;
	    }
	 
	  static void getChars(long i, int index, char[] buf) {
	        long q;
	        int r;
	        int charPos = index;
	        char sign = 0;

	        if (i < 0) {
	            sign = '-';
	            i = -i;
	        }

	        // Get 2 digits/iteration using longs until quotient fits into an int
	        while (i > Integer.MAX_VALUE) {
	            q = i / 100;
	            // really: r = i - (q * 100);
	            r = (int)(i - ((q << 6) + (q << 5) + (q << 2)));
	            i = q;
	            buf[--charPos] = DigitOnes[r];
	            buf[--charPos] = DigitTens[r];
	        }

	        // Get 2 digits/iteration using ints
	        int q2;
	        int i2 = (int)i;
	        while (i2 >= 65536) {
	            q2 = i2 / 100;
	            // really: r = i2 - (q * 100);
	            r = i2 - ((q2 << 6) + (q2 << 5) + (q2 << 2));
	            i2 = q2;
	            buf[--charPos] = DigitOnes[r];
	            buf[--charPos] = DigitTens[r];
	        }

	        // Fall thru to fast mode for smaller numbers
	        // assert(i2 <= 65536, i2);
	        for (;;) {
	            q2 = (i2 * 52429) >>> (16+3);
	            r = i2 - ((q2 << 3) + (q2 << 1));  // r = i2-(q2*10) ...
	            buf[--charPos] = digits[r];
	            i2 = q2;
	            if (i2 == 0) break;
	        }
	        if (sign != 0) {
	            buf[--charPos] = sign;
	        }
	    }
	  final static char[] digits = {
	        '0' , '1' , '2' , '3' , '4' , '5' ,
	        '6' , '7' , '8' , '9' , 'a' , 'b' ,
	        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
	        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
	        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
	        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	    };
	    final static char [] DigitOnes = {
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        } ;
	    
	    final static char [] DigitTens = {
	        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
	        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
	        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
	        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
	        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
	        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
	        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
	        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
	        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
	        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
	        } ;
}
