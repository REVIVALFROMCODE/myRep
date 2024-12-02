class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n, i=0, j=0;
        int nums[] = new int[m];
        for (int k=0;k<m;k++){ //copy nums1 to nums, then merge nums and nums2 to nums1
            nums[k]=nums1[k];
        }

        for (int k=0; k<len; k++){ // k on nums1
            if (i==m) nums1[k]=nums2[j++]; // run out of nums1
            else if (j==n) nums1[k]=nums[i++]; 
            else if (nums[i]<=nums2[j]) nums1[k]=nums[i++]; //biscal compare, choose small one.
            else nums1[k]=nums2[j++];
        }
    }
}

//solution 2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // 1 2 3 0 0 0, 2 5 6
        // i         k      j
        while (i >= 0 && j >= 0) {// merge from the end
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];// basical compare choose bigger one
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0) //put rest of nums2, because of if there are rest of nums2, tail of nums1 must bigger than head of nums2
            nums1[k--] = nums2[j--];
    }
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        merge1(nums1,m,nums2,n);//delegate to well-known sort model
    }
        private void merge1(int[] nums1, int m, int[] nums2, int n){
        //nums1 1,2,3
        //nums2 2,5,6
        int i =0; int j=0; int k=0; int sz = m+n;
        int res[] = new int[sz];
        while(k<sz){
            if(i==m) res[k++]=nums2[j++];
            else if(j==n) res[k++]=nums1[i++];
            else if(nums1[i]<nums2[j]) res[k++]=nums1[i++];
            else res[k++]=nums2[j++];
        }
        for (i = 0; i < sz; i++) { nums1[i] = res[i];} 
        //return reference and re-assign only lost original address... So we copy step-by-step.
        
    }
}
