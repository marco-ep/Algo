import java.util.Arrays;

public class Threesum {

    public static int find(int[] original, int vals, int num) {
        for (int i = 0; i < vals; i++) {
            if (original[i] == num) {
                return i;
            }
        }
        return-2;
    }

    public static void printTriple(int vals, int[] arr) {
        int i,lo, hi;
        int[] og = arr.clone(); //make copy of original code for correct indexes later

        Arrays.sort(arr); //sort array for speed
        int[] fin = new int[3];

        for (i = 0; i < vals-2; i++) {//increment leftmost bound until 3rd to last
            lo=i+1; //start lo as one above left bound
            hi = vals-1; //start hi at end of array

            while (lo < hi) { //while true, lo and hi will move towards each other until met
                int sum = arr[i] + arr[lo] + arr[hi];

                if (sum == 0) {
                    //implementing find method that takes value from sorted arr, and finds that value's original index
                    fin[0] =(find(og,vals,arr[i]) + 1);
                    fin[1] =(find(og,vals,arr[lo]) + 1);
                    fin[2] =(find(og,vals,arr[hi]) + 1);

                    Arrays.sort(fin); //finally, sorts the indexes in case they are out of order
                    StdOut.println((fin[0]) + " " + (fin[1]) + " " + (fin[2])); //prints indices
                    return;

                } else if(sum>0) {
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        StdOut.println(-1); //if triplet not found

    }

    public static void main(String[] args){
        In in = new In("rosalind_3sum.txt");
        int rows = in.readInt();
        int vals = in.readInt();
        for(int i = 0; i<rows; i++){
            int[] arr = new int[vals];
            for(int j = 0; j<vals; j++){
                arr[j] = in.readInt();
            }
            printTriple(vals, arr);
        }
    }
}
