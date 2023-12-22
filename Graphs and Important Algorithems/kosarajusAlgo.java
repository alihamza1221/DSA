import java.util.ArrayList;
import java.util.Stack;

public class kosarajusAlgo extends graph {
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 15);
        addEdge(graph, 1, 3, 12);
        addEdge(graph, 2, 4, 18);
        addEdge(graph, 3, 4, 5);
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
                System.out.println();
            }
            st.pop();
        }
    }

    void topological_sort(ArrayList<Edge> graph[], int cur, Stack<Integer> st, boolean[] vis) {
        vis[cur] = true;
        for (Edge e : graph[cur]) {
            if (vis[e.dest] == false) {
                topological_sort(graph, e.dest, st, vis);
            }
        }
        st.push(cur);
    }

    // step 2
    void reverseGraph(ArrayList<Edge> graph[], ArrayList<Edge> revGraph[]) {
        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                revGraph[e.dest].add(new Edge(e.dest, i, e.weight));
            }
        }
    }

    // step 3
    void dfs(ArrayList<Edge> graph[], boolean[] vis, Stack<Integer> st) {
        while (!st.empty()) {
            int cur = st.pop();
            if (vis[cur] == false) {
                this.dfs(graph, cur, vis);
            }
        }
    }

    void dfs(ArrayList<Edge> graph[], int cur, boolean[] vis) {
        vis[cur] = true;
        for (Edge e : graph[cur]) {
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
                System.out.print(e.dest);
            }
        }
    }
}