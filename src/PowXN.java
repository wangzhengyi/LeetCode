import java.util.Scanner;


public class PowXN {
    public static double power(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static double pow(double x, int n) {
        if (n >= 0) {
            return power(x, n);
        } else {
            return 1.0 / power(x, -n);
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            double x = cin.nextDouble();
            int n = cin.nextInt();

            double res = pow(x, n);

            System.out.println(res);
        }

        cin.close();
    }
}
