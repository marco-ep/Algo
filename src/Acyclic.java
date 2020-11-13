
import java.util.*;

    // store graph edges
    class Edge
    {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    };

    // represent a graph object
    class Graph
    {
        // An array of Lists to represent adjacency list
        List<List<Integer>> adjList = null;

        // Constructor
        Graph(List<Edge> edges, int N) {
            adjList = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                adjList.add(i, new ArrayList<>());
            }

            // add edges to the undirected graph
            for (Edge edge: edges) {
                adjList.get(edge.source).add(edge.dest);
            }
        }
    }

    class DFSUtil
    {
        // Perform DFS on graph
        private static int DFS(Graph graph, int v, boolean[] discovered,
                               int[] departure, int time)
        {
            // mark current node as discovered
            discovered[v] = true;

            // do for every edge (v -> u)
            for (int u : graph.adjList.get(v))
            {
                // u is not discovered
                if (!discovered[u])
                    time = DFS(graph, u, discovered, departure, time);
            }

            departure[v] = time++;

            return time;
        }

        // returns true if given directed graph is DAG
        public static boolean isDAG(Graph graph, int N)
        {
            // stores vertex is discovered or not
            boolean[] discovered = new boolean[N];

            // stores departure time of a vertex in DFS
            int[] departure = new int[N];

            int time = 0;

            // Do DFS traversal from all undiscovered vertices
            // to visit all connected components of graph
            for (int i = 0; i < N; i++)
                if (discovered[i] == false)
                    time = DFS(graph, i, discovered, departure, time);

            // check if given directed graph is DAG or not
            for (int u = 0; u < N; u++)
            {
                // check if (u, v) forms a back-edge.
                for (int v : graph.adjList.get(u))
                {

                    if (departure[u] <= departure[v])
                        return false;
                }
            }

            // no back edges
            return true;
        }

        // Check if given digraph is a DAG (Directed Acyclic Graph) or not
        public static void main(String[] args)
        {
            In in = new In("rosalind_dag.txt");
            int k = in.readInt();

            for (int h = 0; h < k; h++) {
                int noden = in.readInt();
                int edgen = in.readInt();

                List<Edge> edges = new ArrayList<>(edgen);
                for(int i = 0; i<edgen;i++) {
                    int a = in.readInt()-1;
                    int b = in.readInt()-1;

                    Edge temp = new Edge(a,b);
                    edges.add(temp);
                }
                // Set number of vertices in the graph
                final int N = noden;

                // create a graph from given edges
                Graph graph = new Graph(edges, N);

                // check if given directed graph is DAG or not
                if (isDAG(graph, N))
                    System.out.println("1");
                else
                    System.out.println("-1");


            }

        }
    }

