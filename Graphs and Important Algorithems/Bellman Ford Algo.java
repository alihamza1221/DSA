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


//time : O(V * E )  in case  E = V ^ 2 than O ( V ^ 3 ) 
//space : O ( V ^ 2) + O(V) // where O (V) is due to distance matrix
