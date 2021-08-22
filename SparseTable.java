class SparseTable {
	int sparse[][];
	public static int log2(int x) {
    	return (int) (Math.log(x) / Math.log(2));
    }
	public void init(int n,int a[]) {
		int logg = log2(n);
		sparse = new int[n][logg+2];
		for(int j=0;j<=logg;j++) {
			for(int i=0;i<n - (1 << j);i++) {
				if(j==0) sparse[i][j] = a[i];
				else sparse[i][j] = Math.min(sparse[i][j-1],sparse[i+(1<<(j-1))][j-1]);
			}
		}
	}
	
}