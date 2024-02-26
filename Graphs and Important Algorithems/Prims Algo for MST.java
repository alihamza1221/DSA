 // prims algo for minimum spanning trees  
// conditions : un-directed connected non-negtive weights

    static int primsAlgo(ArrayList<Edge>[] graph, boolean[] vis, int V) {
        System.out.println("\n--primsAlgo--");
        PriorityQueue<Pair> q = new PriorityQueue<>();// not mst
        q.offer(new Pair(0, 0));
        int cost = 0;
        Arrays.fill(vis, false);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!vis[curr.src]) {
                cost += curr.dist;
                vis[curr.src] = true;
                for (int i = 0; i < graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    if (!vis[e.dest]) {
                        q.offer(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println(cost);
        return cost;
    }
/* complexity analysis
   the outer loop iterate O(V) times and we add all the edges inside the pq so, time taken for that is O(E) and the manuplation requires O(log) time for each operation
  and since we take out O(V) verteices out of pq it take Log(V) time in total of it takes about O(V+E)log V time complexity */
//O(V+E)log V time complexity

/* space :
It takes up space E, where E is the number of edges present. We also need an array to store the vertices visited. It takes up space V
 , where V is the total number of vertices present in the graph.In the example dexcribed above, these represent the set vertices 
visited and the edge list. Adding both these will give us the total space complexity of this algorithm. 
 Hence Prim's algorithm has a space complexity of O( E + V ).
  */
