import java.util.*;
// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// O(N+E) Time & O(2N) space (Queue and Visited)
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);

        while (q.size() > 0) {
            int front = q.remove();
            if (vis[front] == true)
                continue;

            vis[front] = true;
            res.add(front);
            for (int nbr : adj.get(front)) {
                q.add(nbr);
            }
        }
        return res;
    }
}