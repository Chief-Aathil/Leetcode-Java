public class Q238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] out = new int[nums.length];
            int[] suffix = new int[nums.length];
            int prefixProduct=1, suffixProduct=1;
            for(int i=0; i<nums.length; i++){
                out[i] = prefixProduct;
                prefixProduct*=out[i];
            }
            for(int i=nums.length-1; i>=0; i--){
                suffix[i]= suffixProduct;
                suffixProduct*=out[i];
            }
            for(int i=0; i<nums.length; i++){
                out[i] = out[i]*suffix[i];
            }
            return out;
        }
    }
}
