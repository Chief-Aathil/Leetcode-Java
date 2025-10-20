public class Q238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] out = new int[nums.length];
            int prefixProduct=1, suffixProduct=1;
            for(int i=0; i<nums.length; i++){
                out[i] = prefixProduct;
                prefixProduct*=nums[i];
            }
            for(int i=nums.length-1; i>=0; i--){
                out[i]*=suffixProduct;
                suffixProduct*=nums[i];
            }
            return out;
        }
    }
}
