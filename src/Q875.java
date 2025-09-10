public class Q875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //find max pile
            int max=piles[0];
            for(int p: piles){
                max=Math.max(max,p);
            }

            //min, max k = 1, piles.length
            //binary search to find the min k that satisfies the condition
            int left = 1, right = max, k, minK=max;
            while(left<=right){
                //set k as midpoint of left & right
                k=(right+left)/2;

                //find hours taken for current value of k
                int hours =0;
                for(int p: piles){
                    hours+=Math.ceil((double)p/k);
                }

                //check if it satisfies the condition: hours<=h
                if(hours<=h){
                    //if yes look for smaller k. update min k
                    right = k-1;
                    minK=Math.min(k,minK);
                }else{
                    //if not look for larger k.
                    left = k+1;
                }
            }
            //return min k found
            return minK;


        }
    }
}
