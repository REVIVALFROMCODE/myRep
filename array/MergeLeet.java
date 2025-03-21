public class MergeLeet {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        int m = 3;
        int n = 3;

        Solution.merge(nums1, m, nums2, n);
    }

    static class Solution {
        static public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len = m + n;
            int[] merge = new int[len];
            int i = 0;
            int j = 0;
            int k = 0;
            if (m == 0) {
                merge = nums2;
            } else if (n == 0) {
                merge = nums1;
            } else {//while
                while (k < len) {
                    if (i < m && nums1[i] <= nums2[j]) {
                        merge[k++] = nums1[i++];
                        continue;
                    } else {
                        merge[k++] = nums2[j++];
                    }
                }
            }
            nums1 = merge;
            for(int z : nums1){
                System.out.println(z);
            }
        }
    }


}
