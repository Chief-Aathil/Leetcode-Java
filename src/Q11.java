public class Q11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length-1, maxArea=0;
            while(left<right){
                if(height[left]==0) left++;
                else if(height[right]==0) right--;
                else{
                    int area = (right-left)*Math.min(height[left],height[right]);
                    maxArea = Math.max(maxArea,area);
                    if(height[left]<height[right]){
                        int currentLeftHeight = height[left];
                        while(height[left]<=currentLeftHeight && left<right){
                            left++;
                        }
                    }else if(height[left]>height[right]){
                        int currentRightHeight = height[right];
                        while(height[right]<=currentRightHeight && left<right){
                            right--;
                        }
                    }else{
                        int currentHeight = height[left]; // = height[right]
                        while(height[left]<=currentHeight && left<right) left++;
                        while(height[right]<=currentHeight && left<right) right--;
                    }
                }
            }
            return maxArea;
        }
    }
}
