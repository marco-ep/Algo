import edu.princeton.cs.algs4.ResizingArrayQueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphTraversal {

    static void traverseBreadthFirst(ArrayList<Integer>[] neighbors, int start) {
        ResizingArrayQueue<Integer> q = new ResizingArrayQueue<>();
        Set<Integer> visited = new HashSet<Integer>();
        q.enqueue(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int i = q.dequeue();
            StdOut.println(i);
            for (Integer n : neighbors[i]) {
                if (!visited.contains(n)) {
                    q.enqueue(n);
                    visited.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] neighbors = new ArrayList[5];
        for (int i = 0; i < neighbors.length; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        neighbors[0].add(2);
        neighbors[0].add(3);
        neighbors[1].add(2);
        neighbors[1].add(3);
        neighbors[2].add(0);
        neighbors[2].add(1);
        neighbors[2].add(4);
        neighbors[3].add(0);
        neighbors[3].add(1);
        neighbors[4].add(2);
        traverseBreadthFirst(neighbors, 0);
    }
}
