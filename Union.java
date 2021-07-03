class Union {
	int parent[];
	int rank[];	
	public static int findParent(int node) {
		if(node==parent[node]) return node;
		return parent[node] = findParent(parent[node]);
	}
	public static void UnionByRank(int u,int v) {
		u = findParent(u);
		v = findParent(v);
		if(rank[u]<rank[v]) {
			parent[u] = v;
		}else if(rank[u]>rank[v]) {
			parent[v] = u;
		}else {
			parent[v] = u;
			rank[u]++;
		}
	}
	public void init(int n) {
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i=1i<=n;i++) {
			parent[i] = i;
			rank[i] = i;
		}
	}
}