public class DNA {
    public static void main(String[] args){
        int[] counts = new int[4];
        In in =new In("rosalind_dna.txt");
        String dna = in.readLine();
        for (char nucleotide: dna.toCharArray()){
            counts ["ACGT" .indexOf(nucleotide)]++;
        }
        for (int c : counts){
            StdOut.print(c + " ");
        }
    }
}
