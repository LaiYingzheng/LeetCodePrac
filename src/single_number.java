/**
 * operator:
 *          ^  =>  or => keep the value that is not repeated
 *             => ( compare two binary number, if one of the two number have is 0, return ; if both of them are 1, return 0)
 *
 *             e.g      000 | 111 | 011
 *                  ^   000 | 101 | 001
 *                     -------------------
 *                      000 | 010 | 010
 *      -----------------------------------------------------------------------
 *          ~ => not => inverse the binary number
 *
 *              e.g. =>   decimal                        binary
 *                          5          0000 0000 0000 0000 0000 0000 0000 0101
 *                       ~5 = -6       1111 1111 1111 1111 1111 1111 1111 1010
 *
 *     -------------------------------------------------------------------------
 *
 *         |  => or => compare two bianry number, if one of the two number is 1, return 1; else return 0
 *
 *                 e.g      000 | 111 | 011
 *                      ^   000 | 101 | 001
 *                     -------------------
 *                          000 | 111 | 011
 *    -------------------------------------------------------------------------
 *
 *         &  => and => compare two bianry number, if one of the two number is 0, return 0; otherwise both of them are 1,; return 1
 *
 *                 e.g      000 | 111 | 011
 *                      ^   000 | 101 | 001
 *                     -------------------
 *                          000 | 111 | 011
 *
 */

public class single_number {
    public int singleNumber(int[] nums) {
        int size = nums.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}