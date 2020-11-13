import edu.princeton.cs.algs4.*;
public class TwoSAT {

    public static void main(String[] args) {

        In in = new In("Rosalind_2sat.txt");
        int howMany = in.readInt();


        for (int i = 0; i < howMany; i++) {

            boolean sat = true;
            int vars = in.readInt();
            int verts = 2 * vars + 1;
            int edges = 2 * in.readInt();

            Digraph g = new Digraph(verts);

            int[] assigned = new int[verts];
            int[] answer = new int[vars + 1];

            for (int j = 0; j < edges / 2; j++) {

                int w = in.readInt();
                if (w < 0) {
                    w = Math.abs(w);
                } else {
                    w += vars;
                }

                int v = in.readInt();

                if (v < 0) {
                    v = Math.abs(v);
                } else {
                    v += vars;
                }

                int notw = 0;
                int notv = 0;

                if (w <= vars) {
                    notw = w + vars;
                } else {
                    notw = w - vars;
                }

                if (v <= vars) {
                    notv = v + vars;
                } else {
                    notv = v - vars;
                }

                g.addEdge(notw, v);
                g.addEdge(notv, w);
            }


            TarjanSCC tarjan = new TarjanSCC(g);

            for (int j = 1; j < vars + 1; j++) {
                if (tarjan.stronglyConnected(j, j + vars)) {
                    sat = false;
                }
            }


            if (sat) {
                StdOut.print(1 + " ");
                for (int j = 1; j < verts; j++) {
                    if (assigned[j] == 0) {
                        DepthFirstDirectedPaths paths = new DepthFirstDirectedPaths(g, j);

                        if (!paths.hasPathTo((j + vars) % verts)) {
                            for (int k = 0; k < verts; k++) {
                                if (paths.hasPathTo(k)) {
                                    if (assigned[k] == 2) {
                                        assigned[j] = 2;
                                        break;
                                    }
                                }
                            }
                        } else {
                            assigned[j] = 2;
                        }
                    }

                    if (assigned[j] == 0) {
                        assigned = assign(assigned, j, g);
                    }
                }

                for (int j = 1; j <= vars; j++) {
                    if (assigned[j] == 1) {
                        answer[j] = -j;
                    } else {
                        answer[j] = j;
                    }
                }


                for (int j = 1; j <= vars; j++) {
                    StdOut.print(answer[j] + " ");
                }
            } else {
                StdOut.print(0);
            }
            StdOut.println();
        }
    }

    public static int[] assign(int[] assigned, int vert, Digraph g) {

        assigned[vert] = 1;

        if (vert < assigned.length / 2) {
            assigned[vert + assigned.length / 2] = 2;
        } else {
            assigned[vert - assigned.length / 2] = 2;
        }

        for (int neighbor : g.adj(vert)) {
            if (assigned[neighbor] != 1) {
                assigned = assign(assigned, neighbor, g);
            }
        }

        return assigned;
    }
}