//Solution 1: merge two arrays, straitforward approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge
        int m=nums1.length;
        int n=nums2.length;
        int len =m+n;
        int[] aux = new int[len];
        int i=0,j=0,k=0;
        for(k=0;k<len;k++){
            if(i==m) aux[k]=nums2[j++];
            else if(j==n) aux[k]=nums1[i++];
            else if(nums1[i]<nums2[j]) aux[k]=nums1[i++];
            else aux[k]=nums2[j++];
        }
        int middle = len/2;
        double res  = len%2==0? (double)(aux[middle]+aux[middle-1])/2 : aux[middle];
        return res;
    }
}

//Solution 2: iterate two arrays like merge without aux array
//given input new int[]{1,2}, new int[]{3,4} , we must find positions: p1=1 and p2=2 before execute return, consider middle is (2+2)/2=2, for loop can only be excuted (middle -1 ) equals only one time.
//but for odd case, {1,2} {3}, we need p1=1, middle is (1+2)/2=1, for loop should run middle times.
//we also should watch out priority of operation, use parenthesis wisely. e.g. return (double) ((getMin(nums1, nums2) + getMin(nums1, nums2)) / 2) is wrong, 
//because we use int/2 then transform to double, we need transform int to double before over 2. you can use 2.0 of course.
class Solution {
    int p1 = 0, p2 = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int middle = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < middle - 1; ++i) {
                getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < middle; ++i) {
                getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length)
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        else if (p1 < nums1.length)
            return nums1[p1++];
        else if (p2 < nums2.length)
            return nums2[p2++];
        return -1;
    }
}
