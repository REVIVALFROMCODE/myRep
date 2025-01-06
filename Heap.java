class Heap {
        int[] val;
        int N;

        Heap(int capacity) {
            val = new int[capacity + 1];
            N = 1;
        }

        void exch(int i, int j) {
            int temp = val[i];
            val[i] = val[j];
            val[j] = temp;
        }

        boolean less(int i, int j) {
            return val[i] < val[j];
        }

        void swim(int n) {
//            while(fIndex>=1){
//                if(less(fIndex,n)) exch(fIndex,n);
//                else break;
//                n=fIndex;
//                fIndex=n/2;
//            }
            for (int fIndex = n / 2; fIndex >= 1; fIndex /= 2) {
                if (less(fIndex, n)) exch(fIndex, n);
                else break;
                n = fIndex;
            }
        }

        Heap push(int x) {
            if (N == val.length) ;//resize or delMax
            val[N] = x;
            swim(N++);
            return this;
        }

        void sink(int n) {
            for (int cIndex = 2 * n; cIndex + 1 < N; cIndex *= 2) {
                if (less(n, cIndex) || less(n, cIndex + 1)) {
                    if (less(cIndex, cIndex + 1)) cIndex++;
                    //if(val[cIndex]==-1) break;
                    exch(cIndex, n);
                } else break;
                n = cIndex;
            }
        }

        int delMax() {
            int res = val[1];
            exch(1, N - 1);
            N--;//decrement N before sink(1)
            sink(1);
            return res;
        }
    }
