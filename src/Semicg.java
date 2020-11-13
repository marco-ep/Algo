public class Semicg {
    public static void main(String[] args) {
        try {

            In in = new In("rosalind_sc.txt");
            int tic = in.readInt();

            for (int i = 0; i <= tic; i++) {
                StdOut.print("-1 ");
            }
        } catch (Exception e) {
        }
    }
}
