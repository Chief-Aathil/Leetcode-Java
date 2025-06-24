import java.util.Arrays;

class Q26 {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for(int i =1; i< nums.length; i++){
            if(nums[uniqueIndex]!=nums[i]){
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        Q26 obj = new Q26();
        int[] nums = {1,1,2};
        int k = obj.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}