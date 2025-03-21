package org.StringSort;

public class MSD {
    private static final int R=256;
    public static void sort(String[] a){
        String[] aux=new String[a.length];

    }
    private static void sort(String[] a, String[] aux, int lo, int hi, int d){
        if(hi<=lo) return;

        int[] count=new int[R+2];//manipulate just like we have -1 in the end of String
        for(int i=lo;i<=hi;i++){
            count[charAt(a[i],d)+2]++;
        }
        for(int r=0;r<R+1;r++){
            count[r+1]+=count[r];
        }
        for(int i=lo;i<=hi;i++){
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }
        for(int i=lo;i<=hi;i++){
            a[i]=aux[i-lo];
        }

        for(int r=0;r<R;r++){
            sort(a,aux,lo+count[r],lo+count[r+1]-1,d+1);
        }
    }

    private static int charAt(String s, int d){
        if(d<s.length()) return s.charAt(d);
        else return -1;
    }

    public static void InSort(String[] a, int lo, int hi, int d){
        for(int i=lo;i<=hi;i++){
            for(int j=i;j>lo && less(a[i],a[j],d);j--){
                exch(a,j,j-1);
            }
        }
    }//insertion sort, switch to InSort when sub string is small

    private static boolean less(String v, String w, int d){
        return v.substring(d).compareTo(w.substring(d))<0;
    }
}
