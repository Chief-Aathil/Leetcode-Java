public class Q80 {
    public int removeDuplicates(int[] nums) {
        int start, end;
        //iterate through elements
        int i = 0;
        while ( i < nums.length) {

            start = i;
            end = i;
            //find the start and end of current number occurences - 2 pointer
            while (end < nums.length -i && nums[start] == nums[end])
                end++;
            int duplicateCount = end - start;

            //reached array end
            if (end >= nums.length-i) {
                if (duplicateCount >= 2)
                    return start + 2;
                return start+1;
            }

            //range of duplicate index : [ start, end-1]

            //find the range to be replaced with next number/s
            if (duplicateCount > 2) {
                //replace with the next numbers(numbers after end pointer)
                int replaceCount = duplicateCount - 2;
                int remainingCount = nums.length - end;
                for (int j = 0, indexToShift = end;j<remainingCount; j++, indexToShift++) {
                    nums[start + 2 + j] = nums[indexToShift];
                }
            }
            //udpate i
            i= duplicateCount>=2 ? start+2: start+1;
        }
        return i;
    }

    public static void main(String[] args) {
        var obj = new Q80();
        int out = obj.removeDuplicates(new int[] {1,1,1,2,2,3});
        System.out.println(out);
    }
}
