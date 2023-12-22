import java.util.ArrayList;

public class tarjansalgo extends graph {

    static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int cur, int[] dt, int[] low, int parent, int time) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        for (Edge e : graph[cur]) {
            if (e.dest == parent)
                continue;

            if (vis[e.dest] == false) {
                dfs(graph, vis, e.dest, dt, low, cur, time);
                low[cur] = Math.min(low[cur], low[e.dest]);
                if (low[e.dest] > dt[cur]) {
                    System.out.println(cur + "--------" + e.dest);
                }
            } else {
                low[cur] = Math.min(low[cur], dt[e.dest]);
            }
        }
    }
}
