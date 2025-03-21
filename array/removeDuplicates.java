class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i =1; i< nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
}

//II one number can comes two times.
class Solution {
    public int removeDuplicates(int[] nums) {
        int k =1;
        int n =0;
        for(int i=1; i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                n++;
                if(n==1) nums[k++]=nums[i];
                
            }else if(nums[i]!=nums[i-1]){
                n=0;
                nums[k++]=nums[i];
            }
        }
        return k;
    }
}



class Solution {
    public int removeDuplicates(int[] nums) {
        int k =2;
        
        for (int i =2; i<nums.length;i++){
            if(nums[i]!=nums[k-2] ) {
                nums[k++]=nums[i];//save nums[i]
                continue;
            }
        }
        return k;
    }
}
//0,1,2,3,4
//1,1,1,2,2,3, i=2, k=2, nums[2]==nums[1] break
//1,1,1,(2),2,3, i=3, k=2, nums[3]!=[2]!=[1], nums[2]=nums[3]
//1,1,{2},2,(2),3, i=4, k=3, [4]==[2]==[3], here nums[2] switch to equal nums[3] break the condtion, so change it to compare with [k-2]
