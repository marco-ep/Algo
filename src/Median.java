import java.util.Arrays;
import java.util.Collections;

public class Median {

        public static int partition(Integer [] arr, int l,
                                    int r)
        {
            int x = arr[r], i = l;
            for (int j = l; j <= r - 1; j++)
            {
                if (arr[j] <= x)
                {
                    //Swapping arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    i++;
                }
            }

            //Swapping arr[i] and arr[r]
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;

            return i;
        }

        public static int kthSmallest(Integer[] arr, int l,
                                      int r, int k)
        {
            // If k is smaller than number of elements
            // in array
            if (k > 0 && k <= r - l + 1)
            {
                // Partition the array around last
                // element and get position of pivot
                // element in sorted array
                int pos = partition(arr, l, r);

                // If position is same as k
                if (pos-l == k-1)
                    return arr[pos];

                // If position is more, recur for
                // left subarray
                if (pos-l > k-1)
                    return kthSmallest(arr, l, pos-1, k);

                // Else recur for right subarray
                return kthSmallest(arr, pos+1, r, k-pos+l-1);
            }

            // If k is more than number of elements
            // in array
            return Integer.MAX_VALUE;
        }

        public static void main(String[] args)
        {
            In in = new In("rosalind_med.txt");
            int n = in.readInt();
            Integer arr[] = new Integer[n];
            for(int i=0; i<n; i++){
                arr[i] = in.readInt();
            }
            //Integer arr[] = new Integer[]{2, 36, 5, 21, 8, 13, 11, 20, 5, 4, 1};
            int k = in.readInt();
            System.out.print( kthSmallest(arr, 0, arr.length - 1, k) );
        }
}


