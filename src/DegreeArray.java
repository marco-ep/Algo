
public class DegreeArray {
    public static void main(String[] args){

        In in = new In("rosalind_deg.txt");
        int k, i, j;
        int vertices  = in.readInt();
        int edges = (in.readInt() *2);
        int[] numbers = new int[edges];

        for(i = 0; i < edges; i++){
           numbers[i] = in.readInt();
        }

        for(j = 0; j < vertices; j++) {
            k = 0;
            for (i = 0; i < edges; i++) {
                if (numbers[i] == j+1) {
                    k++;
                }
            }

            StdOut.println(k + " ");
        }
    }
}
