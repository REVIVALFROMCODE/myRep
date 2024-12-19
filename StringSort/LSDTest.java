package org.StringSort;

public class LSDTest {
    public void LSDsort(String[] a, int W) {//fixed length W
        int R = 256;//Radix for extended ASCII
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {//a[i].charAt(d): character at index d of the string a[i].
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
/*
Sort 1 million 32-bit integers? It took 2*32*1million if you choose LSD.
*/
}
