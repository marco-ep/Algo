public class DubDegreeArray {

    public static void main(String[] args) {

        In in = new In("rosalind_ddeg.txt");
        int i, j, k;
        int v = in.readInt();
        int e = in.readInt() * 2;
        int[] stuff = new int[e];
        int[] dubs = new int[v];
        int [] degree = new int [v];

        for (i = 0; i < e; i++) {
            stuff[i] = in.readInt();
        }

        for (j = 0; j <= v; j++) {
            for (i = 0; i < e; i++) {
                if (stuff[i] == j+1) {
                    degree[j]++;
                }
            }
        }

        for (j = 0; j <= v; j++) {
            for (i = 0; i < e; i++) {
                if(stuff[i] == j+1 && i%2 ==0){
                    k = stuff[i+1];
                    dubs[j] = dubs[j] + degree[k-1];
                }
                else if(stuff[i] == j+1 && i%2 !=0){
                    k = stuff[i-1];
                    dubs[j] = dubs[j] + degree[k-1];
                }
            }
            StdOut.println(dubs[j] + " ");
        }
    }
}
