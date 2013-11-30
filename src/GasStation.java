import java.util.Scanner;


public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int bt, ed, total;

        total = gas[0] - cost[0];
        for (bt = gas.length - 1, ed = 0; bt > 0 && ed <= gas.length - 1 && bt != ed;) {
            if (total >= 0) {
                ed = ed + 1;
                total += gas[ed] - cost[ed];
            } else {
                total += gas[bt] - cost[bt];
                bt = bt - 1;
            }
        }

        if (total >= 0) {
            if (bt == gas.length - 1) {
                return bt;
            } else {
                return bt + 1;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int i, n, bt, gas[], cost[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            gas = new int[n];
            cost = new int[n];

            for (i = 0; i < n; i++) {
                gas[i] = cin.nextInt();
            }

            for (i = 0; i < n; i++) {
                cost[i] = cin.nextInt();
            }

            bt = canCompleteCircuit(gas, cost);

            System.out.println(bt);
        }

        cin.close();
    }
}
