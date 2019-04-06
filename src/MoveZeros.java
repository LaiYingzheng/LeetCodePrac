public class MoveZeros {
    class Solution {
        public void moveZeroes(int[] nums) {
            /**
            int size = nums.length;
            int count = 0;
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < size; i ++){
                if(nums[i] != 0){
                    ans.add(nums[i]);
                }else{
                    count += 1;
                }
            }

            for ( int d = 0; d < count; d++){
                ans.add(0);
            }
            for (int n = 0; n< ans.size(); n++){
                nums[n] = ans.get(n);
            }
             **/

            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[zeroCount++] = nums[i];
                }
                while(zeroCount < nums.length){
                    nums[zeroCount++] = 0;

                }
            }
        }
    }
}
