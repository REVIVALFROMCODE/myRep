/*
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*/
//Solution1 From insertion sort take n^2 time.
public static void moveZeroes(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0) continue;
            for(int j=i;j-1>=0;j--) {
                if(nums[j]==0) exch1(nums,j-1,j);
                else break;
            }
        }
    }

//Solution2 Take time propostional to n, after first for loop, array will be 1,3,12,2,12 then we move n to the end put 0.
  public static void moveZeroes2(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[n]=nums[i];
                n++;
            }
        }
        while(n<nums.length){
            nums[n]=0;
            n++;
        }
    }
