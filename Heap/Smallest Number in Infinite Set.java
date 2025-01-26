/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]
*/

/*
Solution 1 
ALgo: For mock infinite array, For each pop, we add i++ back to pq, Use HashSet records all elements are not in pq.
*/
class SmallestInfiniteSet {
    Heap pq;
    int i;
    HashSet<Integer> set;
    public SmallestInfiniteSet() {
        if(pq!=null) return;
        pq = new Heap(1000);
        i = 1;
        pq.add(i++);
        set=new HashSet<Integer>();
    }

    public int popSmallest() {
        int res = pq.poll();
        set.add(res);
        pq.add(i++);
        return res;
    }

    public void addBack(int num) {
        if(set.contains(num)){
            pq.add(num);
            set.remove(num);
        }
    }
    private static class Heap {// min pq
        int vals[];
        int N;

        Heap(int sz) {
            N = 1;
            vals = new int[sz + 1];
        }
        int min(){
            return vals[1];
        }
        void add(int v) {
            vals[N++] = v;
            swim(N - 1);
        }

        void swim(int i) {
            while (i != 1) {
                int j = i / 2;
                if (vals[j]<vals[i])
                    break;
                swap(i, j);
                i = j;
            }
        }

        int poll() {
            int res = vals[1];
            vals[1] = vals[--N];
            sink(1);
            return res;
        }

        void sink(int i) {
            while (i * 2 <= N - 1) {
                int j = i * 2;
                if (j < N - 1 && vals[j + 1] < vals[j])
                    j++;
                if (vals[j]>=vals[i])
                    break;
                swap(i, j);
                i = j;
            }
        }

        void swap(int i, int j) {
            int tmp = vals[i];
            vals[i] = vals[j];
            vals[j] = tmp;
        }
    }
}


/*
Solution2: Eliminate HashSet for optamize performance. 
We do not add i++ back to pq, but only track i as current. For each pop operation, we compare min(pq.poll(),current)
addBack is allowed only if num is smaller than current i, and pq not contains num.
*/

class SmallestInfiniteSet {
    Heap pq;
    int current;

    public SmallestInfiniteSet() {
        pq = new Heap(300);
        current = 1;
    }

    public int popSmallest() {
        return pq.min()<current? pq.poll():current++;
    }

    public void addBack(int num) {
        if (num < current && !pq.contains(num)) {
            pq.add(num);
        }
    }
    private static class Heap {// min pq
        int vals[];
        int N;

        Heap(int sz) {
            N = 1;
            vals = new int[sz + 1];
        }
        void print(){
            for (int i=0; i<N; i++) {
                System.out.print(vals[i]);
            }
            System.out.println("");
        }

        int min() {
            return N==1? Integer.MAX_VALUE:vals[1];
        }

        void add(int v) {
            vals[N++] = v;
            swim(N - 1);
        }

        void swim(int i) {
            while (i != 1) {
                int j = i / 2;
                if (vals[j] < vals[i])
                    break;
                swap(i, j);
                i = j;
            }
        }

        int poll() {
            int res = vals[1];
            vals[1] = vals[--N];
            sink(1);
            return res;
        }

        void sink(int i) {
            while (i * 2 <= N - 1) {
                int j = i * 2;
                if (j < N - 1 && vals[j + 1] < vals[j])
                    j++;
                if (vals[j] >= vals[i])
                    break;
                swap(i, j);
                i = j;
            }
        }

        void swap(int i, int j) {
            int tmp = vals[i];
            vals[i] = vals[j];
            vals[j] = tmp;
        }

        boolean contains(int v) {//do not iterate whole array, stale data may cause implicit error
            for (int i=0; i<N; i++) {
                if (vals[i] == v)
                    return true;
            }
            return false;
        }
    }
}
