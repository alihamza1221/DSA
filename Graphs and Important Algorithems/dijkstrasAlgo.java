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

    static int[] dijkstarsAlgorithem(int src, List<Edge>[] graph, boolean[] vis, int V) {
        System.out.println("--dijkstarsAlgorithem--");
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(src, 0));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!vis[cur.src]) {
                vis[cur.src] = true;
                for (int i = 0; i < graph[cur.src].size(); i++) {
                    Edge e = graph[cur.src].get(i);
                    if (vis[e.dest])
                        continue; // if already visited then continue (if not then it will give TLE)
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight; // relaxation
                        q.offer(new Pair(v, dist[v]));
                    }

                }
            }
        }
        for (int i : dist) {
            System.out.print(i + " ");
        }
        return dist;
    }
//time complexity : O(V^2) for adjecency matrix & O(V * (V + E) logV ) for adjecency List          ---- using binary or fibonacci heap as it takes logv time for updation and removel
// space : O ( V ^ 2 ) as it took this space for graph representation + O ( V ) for distance matrix  + O( V ) binary heap & it's O ( V * E ) for list
