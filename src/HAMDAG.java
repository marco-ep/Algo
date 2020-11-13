import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;

public class HAMDAG {
    int[] topologicalOrder;
    public boolean hasHamiltonianPath(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if(directedCycle.hasCycle()) {
            throw new IllegalArgumentException("Digraph is not a DAG");
        }

        Topological topological = new Topological(digraph);
        topologicalOrder = new int[digraph.V()];
        int arrayIndex = 0;

        for(int vertex : topological.order()) {
            topologicalOrder[arrayIndex++] = vertex;
        }

        for(int i = 0; i < topologicalOrder.length - 1; i++) {
            boolean hasEdgeToNextVertex = false;

            for(int neighbor : digraph.adj(topologicalOrder[i])) {
                if(neighbor == topologicalOrder[i + 1]) {
                    hasEdgeToNextVertex = true;
                    break;
                }
            }

            if(!hasEdgeToNextVertex) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
HAMDAG hamdag = new HAMDAG();
        In in = new In("rosalind_hdag (1).txt");
        int k = in.readInt();

        for (int i = 0; i < k; i++) {

            int v = in.readInt();
            int e = in.readInt();

            Digraph g = new Digraph(v);
            Digraph gs = g;
            Topological gss = new Topological(gs);
            for (int j = 0; j < e; j++) {
                g.addEdge(in.readInt() - 1, in.readInt() - 1);
            }
            if(hamdag.hasHamiltonianPath(g)==true) {

                StdOut.print(1 + " " );
                for(int h = 0; h <v; h++) {
                    StdOut.print(hamdag.topologicalOrder[h]+1 + " ");
                }
            }else{
                StdOut.print(-1 + " ");
            }

        }
    }
}

