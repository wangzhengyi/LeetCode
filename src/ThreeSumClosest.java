import java.util.Arrays;
import java.util.Scanner;


public class ThreeSumClosest {
    public static void main(String args[]) {
        int n, target, num[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = cin.nextInt();
            }
            target = cin.nextInt();

            int sum = threeSumClosest(num, target);

            System.out.println(sum);
        }

        cin.close();
    }

    public static int threeSumClosest(int[] num, int target) {
        // special case
        if (num.length < 3) {
            return Integer.MAX_VALUE;
        }
        
        Arrays.sort(num);
        
        int sum, dist;
        sum = num[0] + num[1] + num[2];
        dist = Math.abs(target - sum);

        if (dist == 0) {
            return target;
        }
        
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                // binary search
                int bt = j + 1, ed = num.length - 1;
                while (bt <= ed) {
                    int mid = bt + (ed - bt) / 2;
                    int tmpSum = num[i] + num[j] + num[mid];
                    int tmpDist = target - tmpSum;
                    
                    if (tmpDist == 0) {
                        return target;
                    } else if (tmpDist > 0) {
                        bt = mid + 1;
                    } else {
                        ed = mid - 1;
                    }
                    
                    if (Math.abs(tmpDist) < dist) {
                        sum = tmpSum;
                        dist = Math.abs(tmpDist);
                    }
                }  
            }
        }

        return sum;
    }
}
