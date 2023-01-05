//Leetcode 547 : https://leetcode.com/problems/number-of-provinces/description/
class Graph {
    ArrayList<Integer>[] adj;

    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int nbr) {
        adj[src].add(nbr);
    }

    public void DFS(int i, boolean[] vis) {
        if(vis[i] == true) return;   
        vis[i] = true;
        for (int nbr : adj[i]) 
            DFS(nbr, vis);
    }
}

class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //Adj List construction -> O(N*N)
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    g.addEdge(i, j);
                }
            }
        }

        int proviences = 0; // ans
        boolean[] vis = new boolean[n];
        //O(N+E) DFS
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                g.DFS(i, vis); 
                proviences++;
            }
        }
        return proviences;
    }
}