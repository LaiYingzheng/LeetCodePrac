public class isPalindrome {
    public boolean isPalindrome(int x) {
        int rev = 0;

        /** this section discussed about the special case
         *  1. The Number < 0 ; the negative number will not result in a balance
         *  2. If the Number ends with 0, like 1200, 23120, this will not balance exclude 0
         */

        if ( x < 0 || (x %10 == 0 && x!= 0) ){
            return false;
        }
        /**
         *  get the last few digits and compare the value,
         *  if the Num is a odd digit.  12321 . we only get the last two digit and compare;
         *  x= 123  => x(processed) = 12; rev = 12 ;
         */
        while (x > rev){
            rev = rev *10 +  x%10;
            x /= 10;
        }
        return x == rev || x ==rev /10 ;
    }
}
