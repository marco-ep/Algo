public class fibonacci {
        static int fib(int n) {

            if (n == 1) {
                return 0 ;
            }
            if (n == 2) {
                return 1 ;
            }
            return fib(n - 1) + fib(n - 2) ;

        }

        public static void main(String[] args) {

            System.out.printf("Enter a whole number\n") ;
            int n = StdIn.readInt();
            int a = fib(n+1) ;

            System.out.printf("%d", a) ;

        }

    }

