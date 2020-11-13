import java.io.*;
import java.util.*;
import java.util.LinkedList;

 class Graphh
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    Graphh(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //add an edge into the graph
    void addEdge(int v, int w)  { adj[v].add(w); }

    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited
        visited[v] = true;
        //System.out.print(v + " ");
        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    Graphh getTranspose()
    {
        Graphh g = new Graphh(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all SCCs
    void printSCCs()
    {
        Stack stack = new Stack();
        int s=0;

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        Graphh gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                s++;
            }

        }
        StdOut.println(s);
    }

    public static void main(String args[])
    {
        In in = new In("rosalind_scc.txt");
        int n = in.readInt();
        int edgen = in.readInt();
        Graphh g = new Graphh(n);

        for(int i=0;i<edgen;i++) {
            g.addEdge(in.readInt()-1, in.readInt()-1);

        }
        g.printSCCs();
    }
}
