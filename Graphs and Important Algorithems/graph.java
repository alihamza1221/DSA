
//create graph , BFS , DFS
import java.lang.reflect.Array;
import java.util.*;

public class graph {
    static class Edge {
        int dest, src, weight;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            weight = 0;
        }

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int V = 7;

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 0, 2, 1); // Add the reverse edge
        addEdge(graph, 1, 0, 1);
        addEdge(graph, 1, 2, 1); // Add the reverse edge
        addEdge(graph, 2, 1, 1);
        addEdge(graph, 2, 0, 1); // Add the reverse edge
        addEdge(graph, 0, 3, 1);
        addEdge(graph, 3, 4, 1); // Add the reverse edge
        addEdge(graph, 3, 0, 1);
        addEdge(graph, 4, 3, 1); // Add the reverse edge
        // bfs
        boolean[] vis = new boolean[V];
        System.out.println("BFS");
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                bfs(graph, 0, vis);
            }
        }
        boolean v[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        kosarajusAlgo kosarajusAlgo = new kosarajusAlgo();
        kosarajusAlgo.topological_sort(graph, 0, st, v);
        ArrayList<Edge>[] revGraph = (ArrayList<Edge>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            v[i] = false;
            revGraph[i] = new ArrayList<>();
        }
        kosarajusAlgo.reverseGraph(graph, revGraph);

        while (!st.empty()) {
            if (v[st.peek()] == false) {
                kosarajusAlgo.dfs(revGraph, st.peek(), v);
                // System.out.println();
            }
            st.pop();
        }
        System.out.println("\nTarjans Algo");
        int[] low = new int[V];
        int[] dt = new int[V];
        boolean[] newVis = new boolean[V];
        tarjansalgo.dfs(graph, newVis, 0, dt, low, -1, 0);

        // dfs
        System.out.println("\nDFS");
        boolean[] vis1 = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis1[i] == false) {
                dfs(graph, 0, vis1);
            }
        }

        // print source to destination path
        System.out.println("\nSource to destination path");
        boolean[] vis2 = new boolean[V];
        printSourceToDestinationPath(graph, 0, 5, 0 + "", vis2);
        dijkstarsAlgorithem(0, graph, vis2, V);
        ballmanFordAlgo(graph, 0, V);
        primsAlgo(graph, vis, V);
    }

    public static void addEdge(List<Edge>[] graph, int src, int dest, int weight) {
        graph[src].add(new Edge(src, dest, weight));
    }

    public static void bfs(List<Edge>[] graph, int src, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while (q.size() > 0) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (Edge e : graph[curr]) {
                if (vis[e.dest] == false) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    // dfs
    private static void dfs(List<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    private static void printSourceToDestinationPath(List<Edge>[] graph, int curr, int dest, String path,
            boolean[] vis) {
        if (curr == dest) {
            // System.out.println(path);
            return;
        }
        vis[curr] = true; // Mark the current node as visited
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) { // Only visit the node if it has not been visited yet
                printSourceToDestinationPath(graph, e.dest, dest, path + e.dest, vis);
            }
        }
        vis[curr] = false; // Unmark the current node as visited
    }

    static class Pair implements Comparable<Pair> {
        int src;
        int dist;

        Pair(int src, int weight) {
            this.src = src;
            this.dist = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.dist - other.dist;
        }

    }

    // ballman's ford algo

    static void ballmanFordAlgo(List<Edge>[] graph, int src, int V) {
        System.out.println("\n--ballmanFordAlgo--");
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : graph[u]) {
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        for (int u = 0; u < V; u++) {
            for (Edge e : graph[u]) {
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                    System.err.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    // prims algo for minimum spanning trees

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

}
