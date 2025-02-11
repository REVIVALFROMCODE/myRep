public KMP(String pattern){
	int R=3;
	int M=pattern.length();
	dfa=new int[R][M];
	dfa[pattern.charAt(0)][0]=1;
	int X=0;
	for(int j=1;j<M;j++){
		for(int c=0;c<R;c++) dfa[c][j]=dfa[c][X];
		dfa[pattern.charAt(j)][j]=j+1;
		X=dfa[pattern.charAt(j)][X];
	}
}

public int search(String pattern,String text){
	int M=pattern.length();
	int N=text.length();
	for(int i=0,j=0;i<N && j<M;i++){
		j=dfa[text.charAt(i)][j];
	}
	if(j==M) return i-M;
	else return N;
	return -1;
}
