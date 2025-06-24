public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] output = new int[m+n];
        if(n==0) return;
        for(int i =0, p1 =0, p2 = 0;i<m+n; i++){
            if (p2>=n || p1 < m  && nums1[p1] <= nums2[p2]) {
                output[i] = nums1[p1++];
            } else {
                output[i] = nums2[p2++];
            }
        }
        for(int i =0; i<m+n; i++){
            nums1[i] = output[i];
        }
    }

    public static void main(String[] args) {
        var obj = new Q88();
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        obj.merge(nums1,1,nums2,1);
        System.out.println(nums1);
    }
}
