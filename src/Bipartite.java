
// Java program to find out whether
// a given graph is Bipartite or not/*

import java.util.*;
import java.lang.*;
import java.io.*;

public class Bipartite {
    public static boolean isBipartiteUtil(int G[][], int src,
                                          int colorArr[], int noden) {
        colorArr[src] = 1;


        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);


        while (!q.isEmpty()) {

            int u = q.getFirst();
            q.pop();

            // Return false if there is a self-loop
            if (G[u][u] == 1)
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 0; v < noden; ++v) {
                // An edge from u to v exists and
                // destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this
                    // adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and
                // destination v is colored with same
                // color as u
                else if (G[u][v] == 1 && colorArr[v] ==
                        colorArr[u])
                    return false;
            }
        }

        return true;
    }

    public static boolean isBipartite(int G[][], int noden) {
        int colorArr[] = new int[noden];
        for (int i = 0; i < noden; ++i)
            colorArr[i] = -1;

        for (int i = 0; i < noden; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr, noden) == false)
                    return false;

        return true;

    }


    public static void main(String[] args) {
        In in = new In("rosalind_bip (1).txt");
        int k = in.readInt();
        int n = 0;
        for (int h = 0; h < k; h++) {
            int noden = in.readInt();
            int edgen = in.readInt();

            //make blank matrix
            int G[][]= new int[noden][noden];
            for(int i = 0; i<noden; i++){
                for(int j=0; j<noden; j++){
                    G[i][j] = 0;
                    //StdOut.println(G[i][j]);
                }
            }
            //actually fill matrix
            for(int i = 0; i<edgen; i++){
                int a = in.readInt();
                int b = in.readInt();
                a--;
                b--;

                G[a][b]=1;
                G[b][a]=1;
            }
        if(isBipartite(G,noden)) {
               System.out.println("1");
            }else{
             System.out.println("-1"); }



            }





    }
}