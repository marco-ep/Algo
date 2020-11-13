
public class NegWeight{

private int distances[];
private int numberofvertices;
public static final int MAX_VALUE = 999;

public NegWeight(int numberofvertices)
        {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
        }

public void BellmanFordEvaluation(int source, int adjacencymatrix[][])
        {
        for (int node = 1; node <= numberofvertices; node++)
        {
        distances[node] = MAX_VALUE;
        }

        distances[source] = 0;
        for (int node = 1; node <= numberofvertices - 1; node++)
        {
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
        for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
        {
        if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
        {
        if (distances[destinationnode] > distances[sourcenode]
        + adjacencymatrix[sourcenode][destinationnode])
        distances[destinationnode] = distances[sourcenode]
        + adjacencymatrix[sourcenode][destinationnode];
        }
        }
        }
        }

        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
        for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
        {
        if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
        {
        if (distances[destinationnode] > distances[sourcenode]
        + adjacencymatrix[sourcenode][destinationnode])
        //System.out.println("The Graph contains negative egde cycle");
        {
        System.out.println("1 "); return;
        }else if(sourcenode==numberofvertices && destinationnode==numberofvertices){System.out.println("-1 ");}
        }
        }
        }

        /*for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            System.out.println("distance of source  " + source + " to "
                    + vertex + " is " + distances[vertex]);
        }*/
        }

public static void main(String... arg)
        {
        In in = new In("rosalind_nwc.txt");
        int k = in.readInt();
        for(int i = 0; i < k; i++) {


        int V = in.readInt();
        int E = in.readInt();
        int adjacencymatrix[][] = new int[V + 1][V + 1];

        for(int h = 1; h<=V; h++){
        for(int l=1; l<=V; l++){
        if(h!=l) {
        adjacencymatrix[h][l] = MAX_VALUE;
        }else{adjacencymatrix[h][l]= 0;}

        }
        }
        for(int j=1; j<=E; j++){
        adjacencymatrix[in.readInt()][in.readInt()] = in.readInt();
        }
        int source = 1;

        NegWeight bellmanford = new NegWeight(V);
        bellmanford.BellmanFordEvaluation(source, adjacencymatrix);
        }
        }
    }