import java.util.Scanner;


public class ContainerWithMostWater {
    public static void main(String[] args) {
        int i, n, area, height[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            height = new int[n];

            for (i = 0; i < n; i++) {
                height[i] = cin.nextInt();
            }

            area = maxArea(height);

            System.out.println(area);
        }

        cin.close();
    }

    public static int maxArea(int[] height) {
        int i, j, lh, rh, area, tmp, len = height.length;

        lh = height[0];
        rh = height[len - 1];
        area = 0;
        i = 0;
        j = len - 1;
        
        while (i < j) {
            tmp = Math.min(lh, rh) * (j - i);
            
            if (tmp > area) {
                area = tmp;
            }
            
            if (lh < rh) {
                while (i < j && height[i] <= lh) {
                    i ++;
                }
                if (i < j) {
                    lh = height[i];
                }
            } else {
                while (i < j && height[j] <= rh) {
                    j --;
                }
                if (i < j) {
                    rh = height[j];
                }
            }
        }

        return area;
    }
}
