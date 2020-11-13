import edu.princeton.cs.algs4.*;
public class GeneralSink {



    public static void main(String[] args) {

        In in = new In("rosalind_gs.txt");
        int k = in.readInt();

        for (int i = 0; i < k; i++) {

            int v = in.readInt();
            int e = in.readInt();

            Digraph g = new Digraph(v);
            boolean gs = true;

            for (int j = 0; j < e; j++)
            {
                g.addEdge(in.readInt()-1, in.readInt()-1);
            }

            for (int j = 0; j < v; j++)
            {
                gs = true;
                DepthFirstDirectedPaths path = new DepthFirstDirectedPaths(g, j);
                for (int m = 0; m < v; m++)
                {
                    if(!path.hasPathTo(m))
                    {
                        gs = false;
                        break;
                    }
                }
                if(gs)
                {
                    StdOut.print((j+1) + " ");
                    break;
                }
            }
            if(!gs)
            {
                StdOut.print(-1 + " ");
            }
        }
    }
}