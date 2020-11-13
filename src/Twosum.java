public class Twosum {
    public static void printDouble(int valn, int[] arr) {
    int k, j, temp1=0, temp2=0;
    k = 0;
    j = valn-1;
    for (k = 0; k < valn; k++) {
        for (j = valn-1; j > k; j--) {
            if (k<j && arr[k] + arr[j] == 0) {

                temp1 = k+1;
                temp2 = j+1;
            }
        }
    }
    if(temp1 != 0)
        StdOut.println((temp1) + " " + (temp2));
    else
        StdOut.println(-1);

    }
    public static void main(String[] args){
        In in = new In("data.txt");
        int rows = in.readInt();
        int valn = in.readInt();
        for(int i = 0; i<rows; i++){
            int[] arr = new int[valn];
            for(int j = 0; j<valn; j++){
                arr[j] = in.readInt();
            }
            printDouble(valn, arr);
        }
    }
}

