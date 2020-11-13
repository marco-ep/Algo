public class Majority {
    static int findMajorityElement(int[] arr, int n) {
        int maj = n/2;
        int count, i, j;
        int majElement = -1;
        
        for (i = 0; i < n; i++) {
            count=0;
            for(j=0; j<n; j++){
                if(arr[i]== arr[j]){  //check for matching numbers in array
                    count++; //increases for matches
                }
                if (count > maj){    //if maj element is found
                    majElement = arr[i];
                    return majElement;   //returns if maj Element is found

                }
            }
        }
        return majElement;  //will return maj element, or -1 if none is found

    }
    public static void main(String[] args) {
        int k, n, h, i, j;
        In in = new In("rosalind_maj.txt");
        k = in.readInt();
        n = in.readInt();
        int arr[] = new int[n];

        for(i=0; i < k; i++){   //put data into array
            for(j = 0; j < n; j++){
                arr[j] = in.readInt();
            }
            h = findMajorityElement(arr,k);
            StdOut.println(h);
        }
    }
}
