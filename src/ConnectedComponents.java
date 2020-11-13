public class ConnectedComponents {

    public static boolean[] visited;

    public static void depthFirstSearch(boolean edges[][], int currVertex) {

        if (visited[currVertex]) {
            return;
        }
        visited[currVertex] = true;

        for (int i = 1; i < edges[currVertex].length; i++) {
            if (edges[currVertex][i]) {
                depthFirstSearch(edges, i);
            }
        }
        return;
    }


    public static void main(String[] args){
        In in = new In("rosalind_cc.txt");
        int vertices = in.readInt();
        int concomps = 0;
        int connections = in.readInt();
        boolean edges[][] = new boolean[vertices+1][vertices+1];
        visited = new boolean[vertices+1];
        for(int i = 0; i<connections; i++){
            int vertex1 = in.readInt();
            int vertex2 = in.readInt();
            edges[vertex1][vertex2]= true;
            edges[vertex2][vertex1]= true;
        }
        for(int i = 1; i < vertices+1; i++){
            if(!visited[i]){
                concomps++;
                depthFirstSearch(edges, i);
            }
        }
StdOut.println(concomps);
    }

}
