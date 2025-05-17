import java.text.DecimalFormat;

public class ArctanSeriesFINAL {

    /*
    // Method to calculate the alternating series for arctan(x)
    public static double arctanAltSeries(double x, int terms) {

        double result = 0;
        for (int k = 0; k < terms; k++) {
            double term = Math.pow(-1, k) * Math.pow(x, 2 * k + 1) / (2 * k + 1);
            result += term;
        }
        return result;
    }
    */

    public static double arctanAltSeries(double x, int terms) {
        if (Math.abs(x) > 1) {
            return Math.PI / 2 - arctanAltSeries(1 / x, terms);
        }

        double result = 0;
        for (int k = 0; k < terms; k++) {
            double term = Math.pow(-1, k) * Math.pow(x, 2 * k + 1) / (2 * k + 1);
            result += term;
        }
        return result;
    }


    // Method to find the smallest N such that |b_{N+1}| <= error
    public static int findN(double error) {
        int N = 0;
        double term = 1;
        while (Math.abs(term) > error) {
            N++;
            term = 1.0 / (Math.pow(3, N + 0.5) * (2 * N + 1));
        }
        return N;
    }

    // Method to find the smallest M such that |S_M - pi/4| <= error
    public static int findM(double error) {
        int M = 0;
        double SM = 0;
        while (true) {
            double term = Math.pow(-1, M) / (2.0 * M + 1);
            SM += term;
            if (Math.abs(SM - Math.PI / 4) <= error) {
                break;
            }
            M++;
        }
        return M;
    }

    public static int findV(double error) {
        int V = 0;
        double x = Math.sqrt(3);
        double SV = 0;
        while (true) {
            double term = Math.pow(-1, V) * Math.pow(x, 2 * V + 1) / (2.0 * V + 1);
            if (Double.isInfinite(term)) {
                break;
            }
            SV += term;
            System.out.println("V: " + V + ", SV: " + SV); // Print out the value of SV at each iteration
            if (Math.abs(SV - Math.PI / 3) <= error) {
                break;
            }
            V++;
        }
        return V;
    }



    // Method to verify the work in part 3
    public static void verifyWorkN(int N) {
        System.out.println("n\tSn\t\t|Sn - pi/6|");
        DecimalFormat df = new DecimalFormat("0.0000000000");
        for (int n = 1; n <= N + 2; n++) {
            double Sn = arctanAltSeries(1 / Math.sqrt(3), n);
            double diff = Math.abs(Sn - Math.PI / 6);
            System.out.println(n + "\t" + df.format(Sn) + "\t" + df.format(diff));
        }
    }

    public static void verifyWorkM(int M) {
        System.out.println("n\tSn\t\t|Sn - pi/4|");
        DecimalFormat df = new DecimalFormat("0.0000000000");
        for (int n = 1; n <= M + 2; n++) {
            double Sn = arctanAltSeries(1, n);
            double diff = Math.abs(Sn - Math.PI / 4);
            System.out.println(n + "\t" + df.format(Sn) + "\t" + df.format(diff));
        }
    }



    public static void main(String[] args) {
        // Step 2: Express arctan(1/sqrt(3)) as an alternating series
        double x = 1 / Math.sqrt(3);
        int terms = 1000; // You can adjust the number of terms as needed
        int N = findN(1e-6);
        double arctan_1_over_sqrt3 = arctanAltSeries(x, N); //change to terms for specific number of terms
        System.out.println("\nStep 2: Express arctan(1/sqrt(3)) as an alternating series");
        System.out.println("arctan(1/sqrt(3)) = " + arctan_1_over_sqrt3);
        System.out.println("Smallest N such that |b_{N+1}| <= 10^-6: " + N);

        // Step 3: Verify the work in part 2
        System.out.println("\nStep 3: Verify the work in part 2");
        verifyWorkN(N);

        // Step 4: Calculation and verification of arctan(1)
        int M = findM(1e-2);
        // m is correct for (m-1) decimal points
        System.out.println("\nStep 4: Calculation and verification of arctan(1)");
        System.out.println("Smallest M such that |S_M - pi| <= 10^-2: " + M);
        System.out.println("S_M: " + arctanAltSeries(1, M));
        System.out.println("|S_M - pi/4|: " + Math.abs(arctanAltSeries(1, M) - Math.PI / 4)); // Compare S_M with pi/4

        System.out.println("\nVerify the work in part 4");
        verifyWorkM(M);  // Verify the results DO NOT TURN ON FOR HIGHER ACCURACY


        // Step 5: Estimating arctan(sqrt(3)) using arctanAltSeries method
        double x3 = Math.sqrt(3);
        int V = findV(1e-2);
        System.out.println("Smallest V such that |S_M - pi| <= 10^-2: " + V);
        double arctan_sqrt3_estimate = arctanAltSeries(x3, V);


        // Estimate pi using the identity pi = 3 * arctan(sqrt(3))
        double pi_estimate = 3 * arctan_sqrt3_estimate;
        System.out.println("\nEstimating pi using arctan(sqrt(3))");
        System.out.println("Estimated value of pi: " + pi_estimate);

        // Check if the estimated pi is within 0.01 of the actual value of pi
        if (Math.abs(pi_estimate - Math.PI) <= 0.01) {
            System.out.println("The estimated value of pi is within 0.01 of the actual value of pi.");
        }
        else {
            System.out.println("The estimated value of pi is not within 0.01 of the actual value of pi.");
        }








       /* // Step 5: Estimating arctan(sqrt(3)) using pi/3
        double arctan_sqrt3 = Math.PI / 3;

        // Estimate pi using the identity pi = 3 * arctan(sqrt(3))
        double pi_estimate = 3 * arctan_sqrt3;
        System.out.println("\nEstimating pi using arctan(sqrt(3))");
        System.out.println("Estimated value of pi: " + pi_estimate);


*/
        /*
        // Step 5.1: Estimating pi using arctan(sqrt(3))
        double x3 = Math.sqrt(3);
        double arctan_sqrt3 = Math.atan(x3);

        // Step 5.2: Estimate pi using the identity pi = 3 * (pi/3)
        double pi_estimate = 3 * arctan_sqrt3;
        System.out.println("\nStep 5: Estimating pi using arctan(sqrt(3))");
        System.out.println("Estimated value of pi: " + pi_estimate);
        */

        /*
        // Step 5.1: Estimating pi using arctan(sqrt(3)) without Math.atan
        double x3 = Math.sqrt(3);
        int terms = 1000; // Increase this value as needed
        double arctan_1_over_sqrt3 = arctanAltSeries(1 / x3, terms);
        double arctan_sqrt3 = Math.PI / 2 - arctan_1_over_sqrt3;

        // Step 5.2: Estimate pi using the identity pi = 3 * arctan(sqrt(3))
        double pi_estimate = 3 * arctan_sqrt3;
        System.out.println("\nStep 5: Estimating pi using arctan(sqrt(3))");
        System.out.println("Estimated value of pi: " + pi_estimate);
        */

    }
}
