package trees;

public class DisjointSet {
	int[] rank, parent; 
    
	public DisjointSet(int n) {
		rank = new int[n]; 
        parent = new int[n];
	} 
	
	public void makeSet(int i) {
		parent[i] = i;
		rank[i] = 0;
	}
	
	public int find(int i) {
		if (parent[i] != i) {
			parent[i] = find(parent[i]);
		}
		return parent[i];
	}
	
	public void union(int i, int j) {
		int i_id = find(i);
		int j_id = find(j);
		if (i_id == j_id) {
			return;
		}
		if (rank[i_id] > rank[j_id]) {
			parent[j_id] = i_id; 
		} else {
			parent[i_id] = j_id; 
			if (rank[i_id] == rank[j_id]) {
				rank[j_id]++;
			}
		}
	}
}
