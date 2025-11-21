public class Q11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length-1, maxArea=0;
            while(left<right){
                if(height[left]==0) left++;
                else if(height[right]==0) right--;
                else{
                    int minHeight = Math.min(height[left], height[right]);
                    int area = (right-left)*minHeight;
                    maxArea = Math.max(maxArea,area);
                    while(height[right]<=minHeight && left<right) right--;
                    while(height[left]<=minHeight && left<right) left++;
                }
            }
            return maxArea;
        }
    }
}
