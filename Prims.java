import java.util.*;
class Node implements Comparator<Node>{
	private int v;
	private int weight;
	Node(int v,int weight) {
		this.v = v;
		this.weight = weight;
	}
	int getV() {
		return v;
	}
	Node() {}
	int getWeight() {
		return weight;
	}
	@Override
	public int compare(Node n1,Node n2){
		if(n1.weight < n2.weight) {
			return -1;
		}else if(n1.weight > n2.weight){
			return 1;
		}
		return 0;
	}
}
class Prims {
	void primsAlgo(List<List<Node>> adj,int N) {
		int key[] = new int[N]; // if starting point is 0
		int parent[] = new int[N];
		boolean mstSet[] = new boolean[N]; //marking we had included this in mst
		for(int i=0;i<N;i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>(N,new Node());
		key[0] = 0;
		parent[0] = -1;
		pq.add(new Node(key[0],0));
		while(!pq.isEmpty()) {
			int u = pq.poll().getV();
			mstSet[u] = true;
			for(Node neighbor:adj.get(u)) {
				if(mstSet[neighbor.getV()]==false && neighbor.getWeight() < key[neighbor.getV()]) {
					parent[neighbor.getV()] = u;
					key[neighbor.getV()] = neighbor.getWeight();
					pq.add(new Node(neighbor.getV(),key[neighbor.getV()]));
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.println(parent[i]);
		}
		//parent array will store parent of each node
	}
	public static void main(String args[]) {
		 int n = 5;
        List<List<Node>> adj = new ArrayList<>();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node>());
			
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));
		
		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));
		
		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));
		
		Prims obj = new Prims(); 
		obj.primsAlgo(adj, n); 
	}
}