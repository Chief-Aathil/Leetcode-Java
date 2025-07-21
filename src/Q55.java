import java.util.Arrays;

//55. Jump Game
public class Q55 {
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1)
//            return true;
//        int currentIndex = 0;
//        int maxReachableIndex;
//        int lastIndex = nums.length - 1;
//        while (nums[currentIndex]>0) {
//            maxReachableIndex = currentIndex + nums[currentIndex];
//            if (maxReachableIndex >= lastIndex)
//                return true;
//
//            //find next index which will give the maximum reach
//            int nextMaxReachableIndex = maxReachableIndex;
//            int nextIndex = currentIndex+1;
//            for(int j =currentIndex +1; j<=maxReachableIndex ;j++){
//                if(nextMaxReachableIndex < j+nums[j]){
//                    nextMaxReachableIndex = j + nums[j];
//                    nextIndex = j;
//                }
//            }
//
//            //check if we can reach farther than the current reach
//            if(maxReachableIndex>=nextMaxReachableIndex){
//                return false;
//            }
//
//            //update iteration variables
//            currentIndex = nextIndex;
//
//        }
//        return false;
//    }

    public boolean canJump(int[] nums){
        int maxReach=0;
        for(int i = 0; i< nums.length; i++){
         if(i>maxReach){
             return false;
         }
         maxReach = Math.max(maxReach,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        var obj = new Q55();
        boolean out = obj.canJump(nums);
        System.out.println(out);
    }
}
