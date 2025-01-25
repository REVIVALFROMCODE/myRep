class Solution {
    static{
        for(int i=0; i<500; i++) findKthLargest(new int[]{1,2,3},3);
    }
    public static int findKthLargest(int[] nums, int k) {
        Heap pq = new Heap(k);
        for(int i=0;i<nums.length;i++){
            if(pq.isFull()){
                if(pq.min()<nums[i]) pq.poll();
                else continue;
            }
            pq.add(nums[i]);
        }
        
        return pq.poll();
    }
    private static class Heap{//min heap
        int[] vals;
        int N;
        void print(){
            for(int n:vals){
                System.out.println(n);
            }
        }
        Heap(int sz){
            vals = new int[sz+1];
            N = 1;
        }
        boolean isFull(){
            return N==vals.length;
        }
        int min(){
            return vals[1];
        }
        void add(int v){
            vals[N++] = v;
            swim(N-1);
        }
        void swim(int i){
            while(i!=1 && vals[i] < vals[i/2]){
                swap(i,i/2);
                i = i/2;
            }
        }
        void swap(int i,int j){
            int temp=vals[i];
            vals[i]=vals[j];
            vals[j]=temp;
        }
        int poll(){
            int res = vals[1];
            vals[1] = vals[--N];
            vals[N]=-111;
            sink(1);
            return res;
        }
        void sink(int i){
            //There are two child nodes, both of which must be compared. 
            //Hence &&  vals[i] < vals[2*i] as condition of while loop will break the logic.
            while(2*i <= N-1){
                int j = 2*i;
                if(j < N-1 && vals[j] > vals[j+1]) j++;
                if(vals[i] < vals[j]) break;
                swap(i,j);
                i=j;
            }
        }
    }
}
