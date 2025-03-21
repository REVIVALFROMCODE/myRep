void qsort(int [] a){
	qsort(a,0,a.length-1);
}
void qsort(int[] a, int lo, int hi){
	if(lo>=hi) return;
	int j = partition(a,lo,hi);
	qsort(a,lo,j-1);
	qsort(a,j+1,hi);
}
int partition(int[] a, int lo, int hi){
	int i=lo;
	int j=hi+1;
	int v=a[lo];
	while(true){
		while(a[++i]<=v) if(i==hi) break;
		while(a[--j]>=v) if(j==lo) break;
		if(i>=j) break;
		exch(i,j);	
	}
	exch(lo,j);
	return j;
}
