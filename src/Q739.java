public class Q739 {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            /***
             Look ahead of each index to find a greater value.
             */

            int[] out = new int[temperatures.length];
            for(int i=0; i<temperatures.length; i++){
                for(int j=i; j<temperatures.length ; j++){
                    if(temperatures[j]>temperatures[i]){
                        out[i]=j-i;
                        break;
                    }else{
                        out[i] = Math.max(out[i],0);
                    }
                }
            }
            return out;
        }
    }
}
