import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

public class SIAG {
    public static void main(String[] args) {

        In in = new In("data.txt");
        int k = in.readInt();

        for (int i = 0; i < k; i++) {

            int v = in.readInt();
            int e = in.readInt();
            Graph g = new Graph(v);
            for (int j = 0; j < e; j++)
            {
                g.addEdge(in.readInt()-1, in.readInt()-1);
            }
            Cycle cyc = new Cycle(g);
            if (cyc.hasCycle()==true){
                StdOut.println(1);
            }
            else{
                StdOut.println(-1);
            }
        }
    }
}
