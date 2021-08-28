import java.util.*;
class Node {
	private int u;
	private int v;
	private int weight;
	Node(int v,int u,int weight) {
		this.v = v;
		this.u = u;
		this.weight = weight;
	}
	Node() {}
	int getV() {
		return v;
	}
	int getU() {
		return u;
	}	
	int getWeight() {
		return weight;
	}
	
}
class Union {
	int parent[];
	int rank[];	
	public int findParent(int node) {
		if(node==parent[node]) return node;
		return parent[node] = findParent(parent[node]);
	}
	public int UnionByRank(int u,int v) {
		u = findParent(u);
		v = findParent(v);
		if(u==v) return -1;
		if(rank[u]<rank[v]) {
			parent[u] = v;
		}else if(rank[u]>rank[v]) {
			parent[v] = u;
		}else {
			parent[v] = u;
			rank[u]++;
		}
		return 1;
	}
	public void init(int n) {
		parent = new int[n];
		rank = new int[n];
		for(int i=0;i<=n-1;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
}
class sortComp implements Comparator<Node> {
	@Override
	public int compare(Node n1,Node n2) {
		if(n1.getWeight() < n2.getWeight()) {
			return -1;
		}else if(n1.getWeight() > n2.getWeight()) {
			return 1;
		}
		return 0;
	}
}
class Kruskal {
	void KruskalAlgo(List<Node> adj,int N) {
		Collections.sort(adj,new sortComp());
		Union un = new Union();
		un.init(N);
		int mstCost = 0;
		List<Node> mst = new ArrayList();
		for(Node neighbor:adj) {
			if(un.findParent(neighbor.getU())!=-1) {
				mstCost+=neighbor.getWeight();
				mst.add(neighbor);
				un.UnionByRank(neighbor.getU(),neighbor.getV());
			}
		}
		for(Node it: mst) {
        	System.out.println(it.getU() + " " +it.getV()); 
        }	

	}
	public static void main(String args[]) {
		int n = 5;
        List<Node> adj = new ArrayList<Node>();		
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));	
		Kruskal obj = new Kruskal(); 
		obj.KruskalAlgo(adj, n);
	}
}