/*

    pop last digit from the origin number
    push this into the reverse
    Similar to Reverse a String

 */





public class Reverse_Integer {
    public int reverse(int x) {
        int rev = 0;
        while( x!= 0){
            int pop = x%10;
            x /= 10;

            // define the upper boundary value
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            // define the lower boundary value

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
